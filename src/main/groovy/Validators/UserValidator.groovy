package Validators

import Exceptions.ValidationError

class UserValidator extends Validator {

    static isOwner = { session ->
        if ("$session.user.id" != session.userId) {
            throw new ValidationError("You don't have permissions to do that", 451)
        }
    }

    static isOwner(session) {
        validate([isOwner], session)
    }
}
