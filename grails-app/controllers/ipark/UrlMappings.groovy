package ipark

class UrlMappings {

    static mappings = {

        group("/parkingLot"){

            "/"(controller: 'parkingLot') {
                action = [POST : "save", GET: "index"]
            }

            "/$id"(controller: 'parkingLot', resource: 'parkingLot') {
                action = [PUT : "update"]
            }
        }

        "/user"(resource: "user")

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
