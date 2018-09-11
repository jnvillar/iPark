package ipark

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class ReservationRestInterceptorSpec extends Specification implements InterceptorUnitTest<ReservationRestInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test reservation interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"reservationRest")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
