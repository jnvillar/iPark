package ipark

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class ParkingLotRestInterceptorSpec extends Specification implements InterceptorUnitTest<ParkingLotRestInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test parkingLot interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"parkingLotRest")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
