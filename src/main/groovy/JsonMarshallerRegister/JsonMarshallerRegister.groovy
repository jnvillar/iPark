package JsonMarshallerRegister

import grails.converters.JSON
import grails.core.GrailsApplication

class JsonMarshallerRegister {

    static registerMarshallers(GrailsApplication grailsApplication) {
        List domainClasses = grailsApplication.getArtefacts("Domain")*.clazz.name
        domainClasses = domainClasses.collect { Class.forName(it) }

        def domainClassesWithMarshaller = domainClasses.findAll {
            it.metaClass.properties.find { it.name == 'marshaller' }
        }

        domainClassesWithMarshaller.each { domainClass ->
            JSON.registerObjectMarshaller(domainClass, domainClass.marshaller)
        }
    }
}
