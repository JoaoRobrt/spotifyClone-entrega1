package exceptions;

public class PlaylistNaoEncontradaException extends RecursoNaoEncontradoException {
    public PlaylistNaoEncontradaException(String message) {
        super(message);
    }
}
