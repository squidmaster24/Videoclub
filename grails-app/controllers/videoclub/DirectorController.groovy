package videoclub

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DirectorController {

    DirectorService directorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond directorService.list(params), model:[directorCount: directorService.count()]
    }

    def show(Long id) {
        respond directorService.get(id)
    }

    def create() {
        respond new Director(params)
    }

    def save(Director director) {
        if (director == null) {
            notFound()
            return
        }

        try {
            directorService.save(director)
        } catch (ValidationException e) {
            respond director.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'director.label', default: 'Director'), director.id])
                redirect director
            }
            '*' { respond director, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond directorService.get(id)
    }

    def update(Director director) {
        if (director == null) {
            notFound()
            return
        }

        try {
            directorService.save(director)
        } catch (ValidationException e) {
            respond director.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'director.label', default: 'Director'), director.id])
                redirect director
            }
            '*'{ respond director, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        directorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'director.label', default: 'Director'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'director.label', default: 'Director'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
