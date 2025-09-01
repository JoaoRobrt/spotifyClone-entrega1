package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    private List<Playlist> playlists = new ArrayList<Playlist>();

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
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
    public void addPlaylist(String nomeDaPlaylist) {

        Playlist playlist = new Playlist(nomeDaPlaylist, this);
        this.playlists.add(playlist);
    }

    public void removePlaylistByName(String nomeDaPlaylist) {

        for(Playlist playlist : playlists) {
            if (playlist.getNome().equals(nomeDaPlaylist)) {
                this.playlists.remove(playlist);
            }
        }
    }

    public void addMidiaPlaylist(String nomeDaPlaylist, Midia midia) {

        for (Playlist playlist : playlists) {
            if (playlist.getNome().equals(nomeDaPlaylist)) {
                playlist.addMidia(midia);
            }
        }
    }

    public void removeMidiaPlaylist(String nomeDaPlaylist, Midia midia) {

        for (Playlist playlist : playlists) {
            if (playlist.getNome().equals(nomeDaPlaylist)) {
                playlist.removeMidia(midia);
            }
        }
    }

}
