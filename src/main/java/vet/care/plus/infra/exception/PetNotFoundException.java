package vet.care.plus.infra.exception;

public class PetNotFoundException extends Throwable {
    public PetNotFoundException(String message) {
        super(message);
    }
}
