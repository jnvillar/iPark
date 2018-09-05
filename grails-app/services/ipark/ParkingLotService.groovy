package ipark

class ParkingLotService {
    LocationService locationService
    UserService userService

    def create(Map params) {
        ParkingLot parkingLot = new ParkingLot(params)
        User creator = userService.get(params.creator as Long)
        Location location = locationService.create(params)

        parkingLot.creator = creator
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

    def reserve(Map params){
        User occupant = userService.get(params.occupant as Long)
        ParkingLot parkingLot = get(params.parkingLot as Long)

        parkingLot.occupant = occupant
        parkingLot.save(flush:true, failOnError:true)
    }
}
