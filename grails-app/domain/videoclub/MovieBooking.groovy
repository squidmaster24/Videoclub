package videoclub

class MovieBooking {

    Film film
    Integer days
    Date bookingDate
    Date returnDate
    Double price

    static constraints = {
        film nullable:false

    }
}
