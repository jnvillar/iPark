package ipark

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class ParkingLotInterceptorSpec extends Specification implements InterceptorUnitTest<ParkingLotInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test parkingLot interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"parkingLot")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
