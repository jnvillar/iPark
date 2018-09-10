package ipark

import grails.rest.Resource

@Resource(uri = '/reservation', formats = ['json'])
class Reservation {

    User occupant
    Date createdAt = new Date()
    Long minutes

    static belongsTo = [parkingLot: ParkingLot]

    static constraints = {
        occupant nullable: false, validator: { value, domain -> domain.parkingLot.creator != value }
        parkingLot nullable: false, validator: { value, domain -> value.reservation == null }
    }

    static marshaller = { Reservation reservation ->

        return [
                "id"        : reservation.id,
                "minutes"   : reservation.minutes,
                "createdAt" : reservation.createdAt,
                "occupant"  : [
                        id  : reservation.occupant.id,
                        name: reservation.occupant.name,
                ],
                "parkingLot": reservation.parkingLot ? [
                        id      : reservation.parkingLot.id,
                        location: reservation.parkingLot.location
                ] : null
        ]
    }
}
