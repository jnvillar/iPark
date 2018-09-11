package ipark

import grails.rest.*

@Resource(uri = '/parkingLots', formats = ['json'], superClass = ParkingLotRestController)
class ParkingLot {

    Location location
    Date createdAt = new Date()
    Long space
    String description
    User creator
    String picture
    boolean parkingMeter = false

    static belongsTo = [creator: User]
    static hasOne = [reservation: Reservation]

    static constraints = {
        location nullable: false
        space nullable: true
        description nullable: false, blank: false
        creator nullable: false
        picture nullable: true
        reservation nullable: true
    }

    static marshaller = { ParkingLot parkingLot ->

        return [
                "id"          : parkingLot.id,
                "creator"     : parkingLot.creator,
                "location"    : parkingLot.location,
                "picture"     : parkingLot.picture,
                "space"       : parkingLot.space,
                "description" : parkingLot.description,
                "parkingMeter": parkingLot.parkingMeter,
                "createdAt"   : parkingLot.createdAt,
                "reservation" : parkingLot.reservation ? [
                        "id"       : parkingLot.reservation.id,
                        "occupant" : [
                                "id"  : parkingLot.reservation.occupant.id,
                                "name": parkingLot.reservation.occupant.name
                        ],
                        "createdAt": parkingLot.reservation.createdAt,
                        "minutes"  : parkingLot.reservation.minutes,
                ] : null
        ]
    }
}
