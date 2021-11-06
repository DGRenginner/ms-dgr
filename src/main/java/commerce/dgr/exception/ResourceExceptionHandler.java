package commerce.dgr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ErroInternoException.class)
        public ResponseEntity<ErrorModel> erroInternoException(ErroInternoException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorModel erro = new ErrorModel(httpStatus.value(), e.getMessage());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    @ExceptionHandler(LoginNaoEncontradoException.class)
    public ResponseEntity<ErrorModel> loginException(LoginNaoEncontradoException e) {
        HttpStatus httpStatus = HttpStatus.NO_CONTENT;
        ErrorModel erro = new ErrorModel(httpStatus.value(), e.getMessage());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    @ExceptionHandler(SenhaIncorretaException.class)
    public ResponseEntity<ErrorModel> senhaIncorretaException(SenhaIncorretaException e) {
        HttpStatus httpStatus = HttpStatus.NON_AUTHORITATIVE_INFORMATION;
        ErrorModel erro = new ErrorModel(httpStatus.value(), e.getMessage());
        return ResponseEntity.status(httpStatus).body(erro);
    }

    @ExceptionHandler(CadastroJaExistenteException.class)
    public ResponseEntity<ErrorModel> cadastroJaExistenteException(CadastroJaExistenteException e) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ErrorModel erro = new ErrorModel(httpStatus.value(), e.getMessage());
        return ResponseEntity.status(httpStatus).body(erro);
    }
}
