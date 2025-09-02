package entities;

import exceptions.PlaylistJaCriadaException;
import exceptions.PlaylistNaoEncontradaException;

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

    public Playlist buscarPlaylist(String nomeDaPlaylist) {
        for (Playlist playlist : playlists) {
            if (playlist.getNome().equals(nomeDaPlaylist)) {
                return playlist;
            }
        }
        return null;
    }

    public void criarPlaylist(String nomeDaPlaylist) throws PlaylistJaCriadaException {

        if(buscarPlaylist(nomeDaPlaylist) == null) {
            Playlist playlist = new Playlist(nomeDaPlaylist, this);
            this.playlists.add(playlist);
        }else{
            throw new PlaylistJaCriadaException("Playlist ja cadastrada");
        }
    }

    public void removePlaylistByName(String nomeDaPlaylist) throws PlaylistNaoEncontradaException {
        Playlist playlistEncontrada = buscarPlaylist(nomeDaPlaylist);

        if (playlistEncontrada != null) {
            this.playlists.remove(playlistEncontrada);
        } else {
            throw new PlaylistNaoEncontradaException("Playlist nao encontrada");
        }

    }

    public void addMidiaPlaylist(String nomeDaPlaylist, Midia midia) throws PlaylistNaoEncontradaException{
        Playlist playlistEncontrada = buscarPlaylist(nomeDaPlaylist);

        if (playlistEncontrada != null) {
            playlistEncontrada.addMidia(midia);
        } else {
            throw new PlaylistNaoEncontradaException("Playlist nao encontrada");
        }
    }

    public void removeMidiaPlaylist(String nomeDaPlaylist, Midia midia) throws PlaylistNaoEncontradaException{
        Playlist playlistEncontrada = buscarPlaylist(nomeDaPlaylist);

        if (playlistEncontrada != null) {
            playlistEncontrada.removeMidia(midia);
        } else {
            throw new PlaylistNaoEncontradaException("Playlist nao encontrada");
        }
    }


}
