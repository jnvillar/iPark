package ipark

import Validators.ParkingLotValidator
import grails.converters.JSON

class ParkingLotRestController<T> extends BaseController<T> {
    static responseFormats = ['json']
    ParkingLotService parkingLotService

    ParkingLotRestController(Class<T> domainClass) {
        this(domainClass, false)
    }

    ParkingLotRestController(Class<T> domainClass, boolean readOnly) {
        super(domainClass, readOnly)
    }

    @Override
    def index() {
        List<ParkingLot> parkingLots = parkingLotService.search(params)
        render parkingLots as JSON
    }

    @Override
    def save() {
        ParkingLot parkingLot = parkingLotService.create(request.getJSON() as Map)
        showResponse(parkingLot)
    }

    @Override
    def update() {
        ParkingLotValidator.isOwner(session)
        super.update()
    }

    @Override
    def delete() {
        ParkingLotValidator.isOwner(session)
        super.delete()
    }

    def userParkingLots() {
        List<ParkingLot> parkingLots = parkingLotService.getUserParkingLots(params.userId as Long)
        render parkingLots as JSON
    }
}
