package ipark

class ReservationService {
    UserService userService

    def create(Map params) {
        Reservation reservation = new Reservation(params)
        reservation.save(flush: true)
        reservation
    }

    def get(Long id){
        Reservation.findById(id)
    }

    def getUserReservations(Long userId){
        User user = userService.get(userId)
        Reservation.findAllByOccupant(user)
    }
}
