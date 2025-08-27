package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    private List<Playlist> playlists = new ArrayList<Playlist>();

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }
    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public void removePlaylist(Playlist playlist) {
        this.playlists.remove(playlist);
    }

    public void addMidia(Playlist playlist, Musica musica) {
        playlist.getMusicas().add(musica);
    }
}
