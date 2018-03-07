package videoclub

import grails.validation.ValidationException
import videoclub.web.command.BookingCommand

import static org.springframework.http.HttpStatus.*

class MovieBookingController {

    MovieBookingService movieBookingService
    FilmService filmService

    static final Integer FILM_PRICE = 5;

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond movieBookingService.list(params), model:[movieBookingCount: movieBookingService.count()]
    }

    def show(Long id) {
        respond movieBookingService.get(id)
    }

    def create(Long filmId) {
        Film film = Film.get(filmId)
        if (!film || !film.availability){
            [film:film]
        }else{
            [bookingCommand: new BookingCommand(), film:film]
        }
    }

    def save(BookingCommand bookingCommand) {


        if (bookingCommand.hasErrors()){
            render (view:"/movieBooking/create", model: [bookingCommand: bookingCommand, film:bookingCommand.film])
            return
        }

        Film film = bookingCommand.film
        Integer days = bookingCommand.days

        if (film.availability){

            MovieBooking movieBooking = new MovieBooking()
            movieBooking.film = film
            movieBooking.days = days
            movieBooking.price = movieBooking.days*FILM_PRICE

                try {
                    movieBookingService.save(movieBooking)
                } catch (ValidationException e) {
                    respond movieBooking.errors, view:'create'
                    return
                }

                film.availability = false
                filmService.save(film)
                flash.message = "Bien!! Has reservado"
                redirect (controller:"film")
        }

        else{
            flash.error = "Película no disponible"
            redirect (controller: "")
        }




//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.created.message', args: [message(code: 'bookingCommand.label', default: 'MovieBooking'), bookingCommand.id])
//                redirect bookingCommand
//            }
//            '*' { respond bookingCommand, [status: CREATED] }
//        }
    }

//    def edit(Long id) {
//        respond movieBookingService.get(id)
//    }
//
//    def update(MovieBooking movieBooking) {
//        if (movieBooking == null) {
//            notFound()
//            return
//        }
//
//        try {
//            movieBookingService.save(movieBooking)
//        } catch (ValidationException e) {
//            respond movieBooking.errors, view:'edit'
//            return
//        }
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.updated.message', args: [message(code: 'movieBooking.label', default: 'MovieBooking'), movieBooking.id])
//                redirect movieBooking
//            }
//            '*'{ respond movieBooking, [status: OK] }
//        }
//    }


    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        movieBookingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'movieBooking.label', default: 'MovieBooking'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'movieBooking.label', default: 'MovieBooking'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
