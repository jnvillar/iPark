package Validators

import Exceptions.ValidationError

class ParkingLotValidator extends Validator {

    static exists = { params ->
        if (!params.parkingLot) {
            throw new ValidationError("Parking Lot does not exists", 404)
        }
    }

    static isOwner = { params ->
        if (params.user != params.parkingLot.creator) {
            throw new ValidationError("You don't have permissions to do that, not the owner", 451)
        }
    }

    static isFree = { params ->
        if (params.parkingLot.reservation) {
            throw new ValidationError("Parking Lot is reserved", 452)
        }
    }

    static isOwner(params) {
        validate([exists, isOwner], params)
    }

    static isFree(params) {
        validate([exists, isFree], params)
    }
}
