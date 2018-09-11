package ipark

import Validators.ParkingLotValidator
import Validators.ReservationValidator
import grails.converters.JSON

class ReservationRestController<T> extends BaseController<T> {
    static responseFormats = ['json']
    ReservationService reservationService
    ParkingLotService parkingLotService

    ReservationRestController(Class<T> domainClass) {
        this(domainClass, false)
    }

    ReservationRestController(Class<T> domainClass, boolean readOnly) {
        super(domainClass, readOnly)
    }

    @Override
    def save() {
        Map parameters = request.getJSON()

        parameters.occupant = session.user
        parameters.parkingLot = parkingLotService.get(parameters.parkingLot as Long)

        ParkingLotValidator.isFree(parameters)
        Reservation reservation = reservationService.create(parameters)
        showResponse(reservation)
    }

    @Override
    def update() {
        ReservationValidator.isOwner(session)
        super.update()
    }

    @Override
    def show() {
        ReservationValidator.isOwner(session)
        super.show()
    }

    @Override
    def delete() {
        ReservationValidator.isOwner(session)
        super.delete()
    }

    def userReservations() {
        List<Reservation> userReservations = reservationService.getUserReservations(params.userId as Long)
        render userReservations as JSON
    }
}
