package ipark


class UserRestInterceptor {

    UserRestInterceptor() {
        match(controller: "user", action: "show|update|delete")
    }

    boolean before() {
        session.userId = params.id
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
