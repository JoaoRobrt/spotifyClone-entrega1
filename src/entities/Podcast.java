package entities;

public class Podcast extends  Midia{
    private GeneroPodcast generoPodcast;

    public Podcast(String titulo, double duracao, Artista artista, GeneroPodcast generoPodcast) {
        super(titulo, duracao, artista);
        this.generoPodcast = generoPodcast;
    }

}
