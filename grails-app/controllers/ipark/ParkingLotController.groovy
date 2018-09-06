package ipark

import grails.converters.JSON
import grails.rest.RestfulController

class ParkingLotController extends RestfulController<ParkingLot> {
    static responseFormats = ['json']
    ParkingLotService parkingLotService

    ParkingLotController() {
        super(ParkingLot)
    }

    @Override
    def index(){
        List<ParkingLot> parkingLots = parkingLotService.search(params)
        render parkingLots as JSON
    }

    @Override
    def save() {
        ParkingLot parkingLot = parkingLotService.create(request.getJSON() as Map)
        showResponse(parkingLot)
    }

    @Override
    def show(){
        ParkingLot parkingLot = parkingLotService.get(params.id as Long)
        render parkingLot as JSON
    }

    @Override
    def delete(){
        parkingLotService.delete(params.id as Long)
        render "deleted"
    }

    def userParkingLots(){
        List<ParkingLot> parkingLots = parkingLotService.getUserParkingLots(params.userId as Long)
        render parkingLots as JSON
    }

    def showResponse(ParkingLot parkingLot){
        def response = parkingLot.hasErrors() ? parkingLot.errors : parkingLot
        render response as JSON
    }
}
