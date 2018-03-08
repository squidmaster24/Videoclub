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
            <label>Film</label>${bookingCommand.film.title}
        </div>

            <input type="hidden" name="film.id" value="${bookingCommand.film.id}"/>
            <div class="fieldcontain">
                <label for="days">Días de alquiler</label>

                <input type="text" name="days" value="${bookingCommand.days}" required="" id="days">

            </div>

            </div><div class="fieldcontain">
                <label>Availability</label>${bookingCommand.film.availability}
            </div>

        </fieldset>


        <fieldset class="buttons">
            <g:if test="${bookingCommand.film.availability}">
                <input type="submit" name="save" class="save" value="Reservar" id="save">
            </g:if>
            <g:else>
                <input type="submit" name="unbook" class="unbook" value="Cancelar reserva" id="unbook">
            </g:else>
        </fieldset>

        </g:form>
    </body>
</html>
