package Validators

class Validator {

    static validate(List<Closure> validations, params) {
        validations.each { it.call(params) }
    }
}
