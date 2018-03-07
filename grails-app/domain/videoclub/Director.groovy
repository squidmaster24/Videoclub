package videoclub

class Director {

    String name
    Integer birthYear

    static hasMany = [films: Film]

    static constraints = {
        name blank: false, minSize: 4
        birthYear nullable: true
    }

    @Override
    String toString() {
        return "$name ($id)"
    }
}


