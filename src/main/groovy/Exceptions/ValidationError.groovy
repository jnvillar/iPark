package Exceptions

class ValidationError extends RuntimeException {
    int status

    ValidationError(String message, int status = 400) {
        super(message)
        this.status = status
    }
}
