package commerce.dgr.exception;

public class ErroInternoException extends Exception {

    public String message;

    public ErroInternoException(String message) {
      this.message = message;

    }

}
