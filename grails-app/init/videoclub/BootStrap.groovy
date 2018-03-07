package videoclub

class BootStrap {

    def init = { servletContext ->
        new Film(year:2007, title:"The man from earth").save()
        new Film(year:2003, title:"Identity").save()
        new Film(year:1997, title:"La princesa Mononoke").save()
        new Film(year:2016, title:"Captain Fantastic").save()
        Director director = new Director(name: "Paco").save()
        new Film(year:2011, title:"Maktub", director: director).save()
        new Director(name: "Tommy Lee Jones", birthYear: 1946).save()
        new Film(year:2011, title:"The sunset limited", director: director).save()
        new Film(year:2012, title:"Disconnect").save()

    }
    def destroy = {
    }
    public BootStrap ( ) { } }
