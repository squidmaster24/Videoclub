package videoclub

import grails.gorm.services.Service

@Service(Director)
interface DirectorService {

    Director get(Serializable id)

    List<Director> list(Map args)

    Long count()

    void delete(Serializable id)

    Director save(Director director)

}