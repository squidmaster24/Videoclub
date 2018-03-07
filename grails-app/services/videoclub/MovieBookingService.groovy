package videoclub

import grails.gorm.services.Service

@Service(MovieBooking)
interface MovieBookingService {

    MovieBooking get(Serializable id)

    List<MovieBooking> list(Map args)

    Long count()

    void delete(Serializable id)

    MovieBooking save(MovieBooking movieBooking)

}