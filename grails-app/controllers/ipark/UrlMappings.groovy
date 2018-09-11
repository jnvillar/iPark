package ipark

class UrlMappings {

    static mappings = {

        group("/users") {
            "/$userId/parkingLots"(controller: "parkingLot", action: "userParkingLots")
            "/$userId/reservations"(controller: "reservation", action: "userReservations")
        }

        "/login"(controller: "login", action: [POST: "login"])
        "/logout"(controller: "login", action: [POST: "logOut"])

        "/"(controller: "index", action: [GET: "index"])
        "/json"(controller: "index", action: "updateMarshallers")

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
