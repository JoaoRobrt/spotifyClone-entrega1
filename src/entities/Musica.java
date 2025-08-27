package entities;

public class Musica extends Midia{

    private GeneroMusica generoMusica;

    public Musica(String titulo, double duracao, Artista artista, GeneroMusica generoMusica) {
        super(titulo, duracao, artista);
        this.generoMusica = generoMusica;
    }

}
