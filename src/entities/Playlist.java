package entities;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;

    private Usuario usuario;
    private List<Midia> midias = new ArrayList<Midia>();

    public Playlist(String nome, Usuario usuario) {
        this.nome = nome;
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getDuracaoTotal() {
        double duracaoTotal = 0;
        for (Midia midia : midias) {
            duracaoTotal += midia.getDuracao();
        }
        return duracaoTotal;
    }

    public List<Midia> getMidias() {
        return midias;
    }

    public void addMidia(Midia midia) {
        midias.add(midia);
    }

    public void removeMidia(Midia midia) {
        midias.remove(midia);
    }
}
