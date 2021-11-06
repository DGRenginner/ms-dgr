package commerce.dgr.exception;

public class CadastroJaExistenteException extends Exception {

    public String message;

    public CadastroJaExistenteException(String message) {
      this.message = message;

    }

}
