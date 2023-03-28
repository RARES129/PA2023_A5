package homework.exceptions;

/**
 * initialization exception, if the starting objects cannot be found.
 */
public class InitializationException extends Exception {

    public InitializationException(String message) {
        super(message);
    }
}
