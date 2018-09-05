package ipark

class LocationService {

    def create(Map params) {
        Location location = new Location(params)
        location
    }
}
