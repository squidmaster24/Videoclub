package videoclub

class Film {

    String title2
    Integer year
    Date publishDate
    Boolean availability =  true

    static belongsTo = [director:Director]



    static constraints = {
        year min:1900
        title blank: false, minSize: 4
        publishDate nullable: true
        director nullable:true
    }

    String toString() {
        return "$title"
    }
}
