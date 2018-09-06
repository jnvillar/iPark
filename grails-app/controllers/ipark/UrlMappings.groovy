package ipark

class UrlMappings {

    static mappings = {

        group("/parkingLot") {
            "/"(controller: 'parkingLot') { action = [POST: "save", GET: "index"] }
            "/$id"(controller: 'parkingLot', resource: 'parkingLot') { action = [PUT: "update"] }
        }

        group("/user") {
            "/"(resource: 'user')
            "/$userId/parkingLots"(controller: 'parkingLot', action: 'userParkingLots')
        }

        "/"(controller: 'index', action: [GET: 'index'])
        "/login"(controller: 'login', action: [POST: 'login'])
        "/logout"(controller: 'login', action: [POST: 'logout'])
        "/json"(controller: 'index', action: 'updateMarshallers')

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
