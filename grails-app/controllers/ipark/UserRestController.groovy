package ipark

import Validators.UserValidator

class UserRestController<T> extends BaseController<T> {

    UserRestController(Class<T> domainClass) {
        this(domainClass, false)
    }

    UserRestController(Class<T> domainClass, boolean readOnly) {
        super(domainClass, readOnly)
    }

    @Override
    def delete() {
        UserValidator.isOwner(session)
        super.delete()
    }

    @Override
    def update() {
        UserValidator.isOwner(session)
        super.update()
    }

    @Override
    def show() {
        UserValidator.isOwner(session)
        super.show()
    }
}
