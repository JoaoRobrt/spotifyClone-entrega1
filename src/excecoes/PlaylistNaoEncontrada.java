package excecoes;

public class PlaylistNaoEncontrada extends RuntimeException {
    public PlaylistNaoEncontrada(String message) {
        super(message);
    }
}
