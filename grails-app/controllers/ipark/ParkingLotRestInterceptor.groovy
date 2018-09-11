package ipark

class ParkingLotRestInterceptor {

    ParkingLotRestInterceptor() {
        match(controller: 'parkingLot', action: 'delete|show|update')
    }

    boolean before() {
        session.parkingLot = ParkingLot.findById(params.id as Long)
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
