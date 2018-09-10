package ipark

import grails.converters.JSON
import grails.rest.RestfulController

class ReservationController extends RestfulController<Reservation> {
    static responseFormats = ['json']
    ReservationService reservationService

    ReservationController() {
        super(Reservation)
    }

    @Override
    def save() {
        Reservation reservation = reservationService.create(request.getJSON() as Map)
        showResponse(reservation)
    }

    def userReservations() {
        List<Reservation> userReservations = reservationService.getUserReservations(params.userId as Long)
        render userReservations as JSON
    }

    def showResponse(Reservation reservation) {
        def response = reservation.hasErrors() ? reservation.errors : reservation
        render response as JSON
    }
}
