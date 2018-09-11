package ipark


class LoginInterceptor {

    LoginInterceptor() {
        match(controller: "user", action: "update|delete")
        match(controller: "parkingLot", action: "delete|update|save|userParkingLots")
        match(controller: "reservation", action: "*")
    }

    boolean before() {

        if (LoginService.isLogged(session)) {
            return true
        }

        render(status: 401, text: "Unauthorized, you are not logged")
        return false
    }

    boolean after() { true }

    void afterView() {}
}
