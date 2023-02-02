package exception;

public class IncorrectEmail extends RuntimeException {

    public IncorrectEmail(String message) {
        super(message);
    }

}
