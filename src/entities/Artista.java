package entities;

import java.util.ArrayList;
import java.util.List;

public class Artista {
    private int id;
    private String nome;

    private List<Midia> midias = new ArrayList<Midia>();

    public Artista(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Midia> getMidias() {
        return midias;
    }

    public void addMidia(Midia midia) {
        this.midias.add(midia);
    }

    public void removeMidia(Midia midia) {
        this.midias.remove(midia);
    }
}
