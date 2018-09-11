package ipark

import Validators.ParkingLotValidator

class ParkingLotService {
    LocationService locationService
    UserService userService

    def create(Map params) {
        ParkingLot parkingLot = new ParkingLot(params)
        Location location = locationService.create(params)
        parkingLot.location = location
        parkingLot.save(flush:true)
        parkingLot
    }

    def get(Long id){
        ParkingLot.findById(id)
    }

    def delete(ParkingLot parkingLot){
        parkingLot.delete(flush: true, failOnError: true)
    }

    def search(Map params){
        if(params.free == "true") return ParkingLot.findAllByReservation(null)
        ParkingLot.findAll()
    }

    def getUserParkingLots(Long userId){
        User creator = userService.get(userId)
        ParkingLot.findAllByCreator(creator)
    }
}
