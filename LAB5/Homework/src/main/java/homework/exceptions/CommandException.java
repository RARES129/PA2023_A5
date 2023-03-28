package homework.exceptions;

/**
 * command exception, if the corresponding reference is null
 */
public class CommandException extends Exception {
    public CommandException(String message) {
        super(message);
    }
}
