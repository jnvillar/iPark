package ipark

class LoginController {
    LoginService loginService

    def login() {
        User user = loginService.validate(request.getJSON())
        session.user = user
        def status = user ? 200 : 404
        render(status: status)
    }

    def logOut(){
        session.user = null
    }
}
