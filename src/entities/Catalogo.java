package entities;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private List<Midia> midias = new ArrayList<Midia>();

    public List<Midia> getMidiasByGenero(String descricao) {
        List<Midia> midiasByGenero = new ArrayList<Midia>();
        for (Midia midia : midias) {
            for (Genero genero : midia.getGeneros()) {
                if(genero.getDescricao().equals(descricao)) {
                    midiasByGenero.add(midia);
                }
            }
        }
        return midiasByGenero;
    }

    public List<Midia> getMidiasByArtista(Artista artista) {
        List<Midia> midiasByArtista = new ArrayList<Midia>();
        for (Midia midia : midias) {
            if(midia.getArtista().equals(artista)) {
                midiasByArtista.add(midia);
            }
        }
        return midiasByArtista;
    }

    public Midia getMidiaByTitulo(String titulo) {
        for (Midia midia : midias) {
            if(midia.getTitulo().equals(titulo)) {
                return midia;
            }
        }
        return null;
    }

}
