package exceptions;

public class CadastroInvalidoException extends RuntimeException {
    public CadastroInvalidoException(String message) {
        super(message);
    }
}
