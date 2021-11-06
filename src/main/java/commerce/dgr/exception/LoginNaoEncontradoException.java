package commerce.dgr.exception;

import org.springframework.http.HttpStatus;

public class LoginNaoEncontradoException extends Exception {

    public LoginNaoEncontradoException(String message) {
        super(message);
    }

}
