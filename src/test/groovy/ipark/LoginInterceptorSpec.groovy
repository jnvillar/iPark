package ipark

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class LoginInterceptorSpec extends Specification implements InterceptorUnitTest<LoginInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test loggin interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"loggin")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
