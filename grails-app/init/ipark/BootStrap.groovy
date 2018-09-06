package ipark

import JsonMarshallerRegister.JsonMarshallerRegister

class BootStrap {
    def grailsApplication

    def init = { servletContext ->
        JsonMarshallerRegister.registerMarshallers(grailsApplication)
    }

    def destroy = {
    }
}
