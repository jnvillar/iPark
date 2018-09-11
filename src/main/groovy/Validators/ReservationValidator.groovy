package Validators

import Exceptions.ValidationError

class ReservationValidator extends Validator {
    static exists = { session ->
        if (session.reservation == null) {
            throw new ValidationError("reservation does not exists", 404)
        }
    }

    static isOwner = { session ->
        if (session.user != session.reservation?.occupant) {
            throw new ValidationError("You don't have permissions to do that, not owner", 451)
        }

    }

    static isOwner(session) {
        validate([exists, isOwner], session)
    }
}
