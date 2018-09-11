package ipark

import Exceptions.ValidationError
import grails.converters.JSON
import grails.rest.RestfulController

class BaseController<T> extends RestfulController<T> {

    BaseController(Class<T> domainClass) {
        this(domainClass, false)
    }

    BaseController(Class<T> domainClass, boolean readOnly) {
        super(domainClass, readOnly)
    }

    def handleException(ValidationError e) {
        render(status: e.status, text: e.message)
    }

    def showResponse(Object domain) {
        def response = domain.hasErrors() ? domain.errors : domain
        render response as JSON
    }

}
