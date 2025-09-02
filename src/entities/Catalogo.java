package entities;

import exceptions.ArtistaNaoEncontradoException;
import exceptions.MidiaNaoEncontradaException;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private List<Midia> midias = new ArrayList<Midia>();
    private List<Genero> generos = new ArrayList<Genero>();
    private List<Artista> artistas = new ArrayList<Artista>();
    private int proximoIdArtista = 1;


    public List<Genero> getGeneros() {
        return generos;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public List<Midia> getMidias() {
        return midias;
    }

    public void addMidia(Midia midia) {
        midias.add(midia);
    }

    public void removeMidia(String titulo) throws MidiaNaoEncontradaException {
        if(getMidiaByTitulo(titulo) != null){
            midias.remove(getMidiaByTitulo(titulo));
        }

    }

    public List<Midia> getMidiasByGenero(String descricao) {
        List<Midia> midiasByGenero = new ArrayList<Midia>();
        for (Midia midia : midias) {
            for (Genero genero : midia.getGeneros()) {
                if (genero.getDescricao().equals(descricao)) {
                    midiasByGenero.add(midia);
                }
            }
        }
        return midiasByGenero;
    }

    public List<Midia> getMidiasByArtista(Artista artista) {
        List<Midia> midiasByArtista = new ArrayList<Midia>();
        for (Midia midia : midias) {
            if (midia.getArtista().equals(artista)) {
                midiasByArtista.add(midia);
            }
        }
        return midiasByArtista;
    }

    public Midia getMidiaByTitulo(String titulo) throws MidiaNaoEncontradaException {
        for (Midia midia : midias) {
            if (midia.getTitulo().equals(titulo)) {
                return midia;
            }
        }
        return null;
    }

    public void addArtista(String nome) {
        int id = proximoIdArtista++;
        Artista artista = new Artista(id, nome);
        artistas.add(artista);
    }

    public Artista getArtistaByNome(String nome) throws ArtistaNaoEncontradoException {
        for (Artista artista : artistas) {
            if (artista.getNome().equals(nome)) {
                return artista;
            }
        }
        throw new ArtistaNaoEncontradoException("Artista nao encontrado");
    }

    public Artista getArtistaByid(int id) throws ArtistaNaoEncontradoException {
        for (Artista artista : artistas) {
            if (artista.getId() == id) {
                return artista;
            }
        }
        throw new ArtistaNaoEncontradoException("Artista nao encontrado");
    }

    public void removeArtistaById(int id) throws ArtistaNaoEncontradoException {
        Artista artista = getArtistaByid(id);
        if (artista != null) {
            artistas.remove(artista);
        }

    }


}
