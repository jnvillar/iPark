package ipark

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

    def delete(Long id){
        get(id).delete(flush: true, failOnError: true)
    }

    def search(Map params){
        if(params.free == "true") return ParkingLot.findAllByOccupant(null)
        ParkingLot.findAll()
    }

    def getUserParkingLots(Long userId){
        User creator = userService.get(userId)
        ParkingLot.findAllByCreator(creator)
    }
}
