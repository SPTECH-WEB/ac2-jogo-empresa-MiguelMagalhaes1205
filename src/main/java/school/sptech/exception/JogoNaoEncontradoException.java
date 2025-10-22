package school.sptech.exception;

public class JogoNaoEncontradoException extends Exception {

    public JogoNaoEncontradoException() {
    }

    public JogoNaoEncontradoException(String message) {
        super(message);
    }

    public JogoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public JogoNaoEncontradoException(Throwable cause) {
        super(cause);
    }

    public JogoNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
