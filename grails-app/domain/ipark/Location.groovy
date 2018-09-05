package ipark

class Location {

    String latitude
    String longitude

    static belongsTo = ParkingLot

    static constraints = {
    }

}
