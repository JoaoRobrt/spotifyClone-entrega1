package entities;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Midia {
    private String titulo;
    private double duracao;

    private Artista artista;

    private Set<Genero> generos = new LinkedHashSet<>();

    protected Midia(String titulo, double duracao, Artista artista) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Set<Genero> getGeneros() {
        return generos;
    }


}
