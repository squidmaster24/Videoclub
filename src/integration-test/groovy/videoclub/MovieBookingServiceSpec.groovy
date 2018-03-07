package videoclub

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MovieBookingServiceSpec extends Specification {

    MovieBookingService movieBookingService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MovieBooking(...).save(flush: true, failOnError: true)
        //new MovieBooking(...).save(flush: true, failOnError: true)
        //MovieBooking movieBooking = new MovieBooking(...).save(flush: true, failOnError: true)
        //new MovieBooking(...).save(flush: true, failOnError: true)
        //new MovieBooking(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //movieBooking.id
    }

    void "test get"() {
        setupData()

        expect:
        movieBookingService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MovieBooking> movieBookingList = movieBookingService.list(max: 2, offset: 2)

        then:
        movieBookingList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        movieBookingService.count() == 5
    }

    void "test delete"() {
        Long movieBookingId = setupData()

        expect:
        movieBookingService.count() == 5

        when:
        movieBookingService.delete(movieBookingId)
        sessionFactory.currentSession.flush()

        then:
        movieBookingService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MovieBooking movieBooking = new MovieBooking()
        movieBookingService.save(movieBooking)

        then:
        movieBooking.id != null
    }
}
