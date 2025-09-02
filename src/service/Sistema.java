package service;

import entities.*;
import exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private Catalogo catalogo;
    private Admin admin;
    private List<Usuario> usuariosCadastrados = new ArrayList<Usuario>();
    private Usuario usuarioLogado;

    public Sistema() {
       this.usuariosCadastrados = new ArrayList<Usuario>();
    }

    public Usuario getUsuarioLogado() {
        return this.usuarioLogado;
    }

    public void login(Scanner scanner) throws UsuarioNaoEncontradoException {
        System.out.println("Digite o nome de usuário: ");
        String nome = scanner.nextLine();

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        if(admin.getNome().equals(nome) && admin.getSenha().equals(senha)){
            System.out.println("Admin logado com sucesso!");
            usuarioLogado = admin;
            return;
        }

        for(Usuario usuario : usuariosCadastrados) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                System.out.println("Usuário logado com sucesso!");
                usuarioLogado = usuario;
                return;
            }
        }

        throw new UsuarioNaoEncontradoException("Usuário ou senha inválidos.");
    }

    public void cadastrarUsuario(Scanner scanner) throws SenhaInvalidaException, EmailJaCadastradoException {
        System.out.println("Digite o nome de usuário: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o seu email: ");
        String email = scanner.nextLine();
        System.out.println("A senha deve conter no minimo 6 caracteres");
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        for(Usuario usuario : usuariosCadastrados) {
            if (usuario.getEmail().equals(email)) {
                throw new EmailJaCadastradoException("Email ja cadastrado");
            }
        }

        if (senha.length() < 6) {
            throw new SenhaInvalidaException("A senha deve conter no minimo 6 caracteres");
        }else{

            Usuario usuarioCadastrado = new Usuario(nome, email, senha);
            usuariosCadastrados.add(usuarioCadastrado);

            System.out.println("Usuário cadastrado com sucesso!");

            usuarioLogado = usuarioCadastrado;

        }

    }

    public void verPlaylists() {
        if(usuarioLogado.getPlaylists().isEmpty()){
            System.out.println("Nenhuma playlist cadastrada");
        }else{
            for (int i = 0; i < usuarioLogado.getPlaylists().size(); i++) {
                System.out.println(i + " * " + usuarioLogado.getPlaylists().get(i).getNome());
            }
        }

    }

    public void criarPlaylist(Scanner scanner) throws PlaylistJaCriadaException {
        System.out.println("Digite o nome da playlist: ");
        String nome = scanner.nextLine();

        usuarioLogado.criarPlaylist(nome);

    }

    public void removerPlaylist(Scanner scanner) throws PlaylistNaoEncontradaException {
        System.out.println("Digite o nome da playlist: ");
        String nome = scanner.nextLine();
        usuarioLogado.removePlaylistByName(nome);


    }

    public void adicionarMidiaAPlaylist(Scanner scan) throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException {
        System.out.println("Digite o nome da playlist: ");
        String nomePlaylist = scan.nextLine();
        System.out.println("Digite o nome da midia: ");
        String nomeMidia = scan.nextLine();

        Midia midia = catalogo.getMidiaByTitulo(nomeMidia);
        usuarioLogado.addMidiaPlaylist(nomePlaylist, midia);
    }

    public void removerMidiaDaPlaylist(Scanner scan) throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException {
        System.out.println("Digite o nome da playlist: ");
        String nomePlaylist = scan.nextLine();
        System.out.println("Digite o nome da midia: ");
        String nomeMidia = scan.nextLine();

        Midia midia = catalogo.getMidiaByTitulo(nomeMidia);
        usuarioLogado.removeMidiaPlaylist(nomePlaylist, midia);
    }
}

