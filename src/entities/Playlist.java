package entities;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;

    private Usuario usuario;
    private List<Musica> musicas = new ArrayList<Musica>();

    public double getDuracaoTotal() {
        double duracaoTotal = 0;
        for (Musica musica : musicas) {
            duracaoTotal += musica.getDuracao();
        }
        return duracaoTotal;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }
}
