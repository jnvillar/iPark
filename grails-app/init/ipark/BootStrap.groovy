package ipark

import grails.converters.JSON

class BootStrap {
    def grailsApplication

    def init = { servletContext ->

        List domainClasses = grailsApplication.getArtefacts("Domain")*.clazz.name
        domainClasses = domainClasses.collect { Class.forName(it) }

        def domainClassesWithMarshaller = domainClasses.findAll {
            it.metaClass.properties.find { it.name == 'marshaller' }
        }

        domainClassesWithMarshaller.each { domainClass ->
            JSON.registerObjectMarshaller(domainClass, domainClass.marshaller)
        }

    }

    def destroy = {
    }
}
