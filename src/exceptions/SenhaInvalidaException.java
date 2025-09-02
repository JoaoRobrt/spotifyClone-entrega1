package exceptions;

public class SenhaInvalidaException extends CadastroInvalidoException {
    public SenhaInvalidaException(String message) {
        super(message);
    }
}
