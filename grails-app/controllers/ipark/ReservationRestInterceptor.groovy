package ipark

class ReservationRestInterceptor {

    ReservationRestInterceptor() {
        match(controller: "reservation", action: "delete|show|update")
    }

    boolean before() {
        session.reservation = Reservation.findById(params.id as Long)
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
