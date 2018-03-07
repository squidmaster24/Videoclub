package videoclub.web.command

import grails.validation.Validateable
import videoclub.MovieBooking
import videoclub.Film


class BookingCommand implements Validateable {

        Film film
        Integer days


        static constraints = {
            importFrom MovieBooking
            film nullable: false
            days nullable: false, min:1, max: 30
        }


}
