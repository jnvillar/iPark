package ipark

import JsonMarshallerRegister.JsonMarshallerRegister

class IndexController {
    def index() {
        render 'iPark'
    }

    def updateMarshallers() {
        JsonMarshallerRegister.registerMarshallers(grailsApplication)
        render 'marshallers updated'
    }
}
