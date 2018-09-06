package ipark

import grails.rest.*

@Resource(uri = '/parkingLot', formats = ['json'])
class ParkingLot {

    Location location
    Date createdAt = new Date()
    Long space
    String description
    User occupant
    User creator
    String picture

    static belongsTo = [creator: User]

    static constraints = {
        location nullable: false
        space nullable: true
        description nullable: false, blank: false
        occupant nullable: true
        creator nullable: false
        picture nullable: true
    }

    static marshaller = { ParkingLot parkingLot ->

        return [
                "id"         : parkingLot.id,
                "creator"    : parkingLot.creator,
                "occupant"   : parkingLot.occupant,
                "location"   : parkingLot.location,
                "picture"    : parkingLot.picture,
                "space"      : parkingLot.space,
                "description": parkingLot.description,
                "createdAt"  : parkingLot.createdAt
        ]
    }
}
