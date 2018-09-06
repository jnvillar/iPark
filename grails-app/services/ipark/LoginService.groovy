package ipark

class LoginService {

    def validate(Map params) {
        User user = User.findByNameAndPassword(params.name as String, params.pass as String)
        user
    }
}
