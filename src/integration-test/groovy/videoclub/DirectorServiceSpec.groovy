package videoclub

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DirectorServiceSpec extends Specification {

    DirectorService directorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Director(...).save(flush: true, failOnError: true)
        //new Director(...).save(flush: true, failOnError: true)
        //Director director = new Director(...).save(flush: true, failOnError: true)
        //new Director(...).save(flush: true, failOnError: true)
        //new Director(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //director.id
    }

    void "test get"() {
        setupData()

        expect:
        directorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Director> directorList = directorService.list(max: 2, offset: 2)

        then:
        directorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        directorService.count() == 5
    }

    void "test delete"() {
        Long directorId = setupData()

        expect:
        directorService.count() == 5

        when:
        directorService.delete(directorId)
        sessionFactory.currentSession.flush()

        then:
        directorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Director director = new Director()
        directorService.save(director)

        then:
        director.id != null
    }
}
