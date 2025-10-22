package school.sptech.exception;

public class JogoInvalidoException extends Exception {

    public JogoInvalidoException() {
    }

    public JogoInvalidoException(String message) {
        super(message);
    }

    public JogoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public JogoInvalidoException(Throwable cause) {
        super(cause);
    }

    public JogoInvalidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
