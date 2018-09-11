package ipark

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class UserRestInterceptorSpec extends Specification implements InterceptorUnitTest<UserRestInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test user interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"userRest")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
