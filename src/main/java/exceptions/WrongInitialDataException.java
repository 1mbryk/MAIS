package exceptions;

public class WrongInitialDataException extends RuntimeException {
    public WrongInitialDataException(String message) {
        super(message);
    }
}
