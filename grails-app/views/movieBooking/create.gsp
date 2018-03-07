<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
    <head>
        <meta name="layout" content="main" />
        <title>Booking film</title>
    </head>
    <body>
    <g:form controller="movieBooking" action="save" method="post">

        <fieldset>
        <div class="fieldcontain">
            <label>Film</label>${film.title}
        </div>

            <input type="hidden" name="film.id" value="${film.id}"/>
            <div class="fieldcontain">
                <label for="days">Días de alquiler</label>

                <input type="text" name="days" value="" required="" id="days">

            </div>

            </div><div class="fieldcontain">
                <label>Availability</label>${film.availability}
            </div>

        </fieldset>

        <fieldset class="buttons">
            <input type="submit" name="save" class="save" value="Reservar" id="save">
        </fieldset>

        </g:form>
    </body>
</html>
