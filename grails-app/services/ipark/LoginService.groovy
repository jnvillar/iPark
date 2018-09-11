package ipark

class LoginService {

    def validate(Map params) {
        User user = User.findByNameAndPassword(params.name as String, params.pass as String)
        user
    }

    static isLogged(session) {
        session.user != null
    }

    static hasPermissions(session, Long id) {
        isLogged(session) && (session.user.id == id)
    }
}
