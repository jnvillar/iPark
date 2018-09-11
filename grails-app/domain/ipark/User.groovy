package ipark

import grails.rest.Resource
import groovy.transform.EqualsAndHashCode

@Resource(uri = '/users', superClass = UserRestController, formats = ['json'])
@EqualsAndHashCode(includes = 'id,name')
class User {

    String name
    String email
    String password

    static hasMany = [parkingLots: ParkingLot]

    static constraints = {
        name(nullable: false, maxSize: 20, minSize: 3, unique: true)
        email(nullable: false, maxSize: 100, email: true, unique: true)
        password(nullable: false, maxSize: 20, minSize: 3)
    }

    static marshaller = { User user ->

        [
                "id"   : user.id,
                "email": user.email,
                "name" : user.name,
        ]
    }
}
