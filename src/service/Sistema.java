package service;

import entities.*;
import exceptions.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private Catalogo catalogo;
    private Admin admin;
    private List<Usuario> usuariosCadastrados;
    private Usuario usuarioLogado;

    public Sistema() {
        this.catalogo = new Catalogo();
        this.admin = new Admin("admin", "admin@gmail.com", "admin");
        this.usuariosCadastrados = new ArrayList<Usuario>();

        popularDadosIniciais();
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
                System.out.println(i+1 + " * " + usuarioLogado.getPlaylists().get(i).getNome());
                for(Midia midia : usuarioLogado.getPlaylists().get(i).getMidias()){
                    System.out.println(midia.getTitulo());
                }
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

    public void adicionarMidiaAPlaylist(Scanner scanner) throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException {
        System.out.println("Digite o nome da playlist: ");
        String nomePlaylist = scanner.nextLine();
        System.out.println("Digite o nome da midia: ");
        String nomeMidia = scanner.nextLine();

        Midia midia = catalogo.getMidiaByTitulo(nomeMidia);
        usuarioLogado.addMidiaPlaylist(nomePlaylist, midia);
    }

    public void removerMidiaDaPlaylist(Scanner scanner) throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException {
        System.out.println("Digite o nome da playlist: ");
        String nomePlaylist = scanner.nextLine();
        System.out.println("Digite o nome da midia: ");
        String nomeMidia = scanner.nextLine();

        Midia midia = catalogo.getMidiaByTitulo(nomeMidia);
        usuarioLogado.removeMidiaPlaylist(nomePlaylist, midia);
    }

    public void adicionarMidiaAoCatalogo(Scanner scanner) throws RecursoNaoEncontradoException, IllegalArgumentException, ArtistaNaoEncontradoException {
    System.out.println("Digite o nome da midia: ");
    String nomeMidia = scanner.nextLine();
    System.out.println("Digite o nome do artista: ");
    String nomeArtista = scanner.nextLine();
    Artista artista = catalogo.getArtistaByNome(nomeArtista);

    double duracao;
    try {
        System.out.println("Digite a duração da musica: ");
        duracao = scanner.nextDouble();
    }catch (InputMismatchException e) {
        System.out.println("Duração inválida!");
        scanner.nextLine();
        return;
    }

    System.out.println("Selecione o tipo de Midia: ");
    System.out.println("1 - Musica\n2 - AudioBook\n3 - PodCast");
    int tipoMidia = scanner.nextInt();
    scanner.nextLine();
  switch (tipoMidia) {
    case 1:
        Musica musica = new Musica( nomeMidia, duracao, artista);
        System.out.println("Digite o nome do genero: ");
        System.out.println("1 - Rock\n2 - Pop\n3 - MPB\n4 - Jazz\n5 - Classic");
        String nomeGeneroMusica = scanner.nextLine();
        GeneroMusica generoMusica = GeneroMusica.valueOfDescricao(nomeGeneroMusica);

        musica.addGenero(generoMusica);

        catalogo.addMidia(musica);
        break;
    case 2:
        AudioBook audioBook = new AudioBook( nomeMidia, duracao, artista);
        System.out.println("Digite o nome do genero: ");
        System.out.println("1 - Ficcao\n2 - Romance\n3 - Aventura\n4 - Drama");
        String nomeGeneroAudioBook = scanner.nextLine();
        GeneroAudioBook generoAudioBook = GeneroAudioBook.valueOfDescricao(nomeGeneroAudioBook);
        audioBook.addGenero(generoAudioBook);

        catalogo.addMidia(audioBook);
        break;
    case 3:
        PodCast podCast = new PodCast( nomeMidia, duracao, artista);
        System.out.println("Digite o nome do genero: ");
        System.out.println("1 - Humor\n2 - Notícias\n3 - Cultura\n4 - Esportes");
        String nomeGeneroPodCast = scanner.nextLine();
        GeneroPodCast generoPodCast = GeneroPodCast.valueOfDescricao(nomeGeneroPodCast);
        podCast.addGenero(generoPodCast);

        catalogo.addMidia(podCast);
        break;

    }
  }

    public void removerMidiaDoCatalogo(Scanner scanner) throws RecursoNaoEncontradoException {
        System.out.println("Digite o nome da midia: ");
        String nomeMidia = scanner.nextLine();

        catalogo.removeMidia(nomeMidia);
    }

    public void listarMidias() {
        if (catalogo.getMidias().isEmpty()) {
            System.out.println("Nenhuma midia cadastrada");
        }else{
            for (int i = 0; i < catalogo.getMidias().size(); i++) {
                System.out.println(i+1 + " * " + catalogo.getMidias().get(i).getTitulo());
            }
        }

    }

    public void adicionarArtistaAoCatalogo(Scanner scanner) throws ArtistaJaCadastradoException {
        System.out.println("Digite o nome do artista: ");
        String nomeArtista = scanner.nextLine();
        catalogo.addArtista(nomeArtista);
    }

    public void removerArtistaDoCatalogo(Scanner scanner) throws ArtistaNaoEncontradoException {
    System.out.println("Digite o id do artista: ");
    int idArtista = scanner.nextInt();
    scanner.nextLine();

    catalogo.removeArtistaById(idArtista);
    }

    public void listarArtistas() {
        if (catalogo.getArtistas().isEmpty()) {
            System.out.println("Nenhum artista cadastrado");
        } else {
            for (int i = 0; i < catalogo.getArtistas().size(); i++) {
                System.out.println(i + 1 + " * " + catalogo.getArtistas().get(i).getNome());
            }
        }
    }

    public void listarUsuarios() {
        if (usuariosCadastrados.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado");
        }else{
            for (int i = 0; i < usuariosCadastrados.size(); i++) {
                System.out.println(i+1 + " * " + usuariosCadastrados.get(i).getNome());
            }
        }

    }

    public void logout(){
        System.out.println("Deslogado com sucesso!");
        this.usuarioLogado = null;
    }

    private void popularDadosIniciais() {
        System.out.println("Populando o sistema com dados iniciais...");

        // --- Criando Artistas ---
        catalogo.addArtista("Queen");
        catalogo.addArtista("Legião Urbana");
        catalogo.addArtista("Dua Lipa");
        catalogo.addArtista("Caetano Veloso");
        catalogo.addArtista("Miles Davis");
        catalogo.addArtista("Jovem Nerd e Azaghal");
        catalogo.addArtista("Folha de S.Paulo");
        catalogo.addArtista("Machado de Assis");
        catalogo.addArtista("J.K. Rowling");

        // --- Criando Músicas ---
        Musica m1 = new Musica("Bohemian Rhapsody", 5.92,catalogo.getArtistaByNome("Queen"));
        m1.addGenero(GeneroMusica.ROCK);
        catalogo.addMidia(m1);

        Musica m2 = new Musica("Tempo Perdido", 5.03, catalogo.getArtistaByNome("Legião Urbana"));
        m2.addGenero(GeneroMusica.ROCK);
        catalogo.addMidia(m2);

        Musica m3 = new Musica("Don't Start Now", 3.05, catalogo.getArtistaByNome("Dua Lipa"));
        m3.addGenero(GeneroMusica.POP);
        catalogo.addMidia(m3);

        Musica m4 = new Musica("Sozinho", 2.98, catalogo.getArtistaByNome("Caetano Veloso"));
        m4.addGenero(GeneroMusica.MPB);
        catalogo.addMidia(m4);

        Musica m5 = new Musica("So What", 9.39, catalogo.getArtistaByNome("Miles Davis"));
        m5.addGenero(GeneroMusica.JAZZ);
        catalogo.addMidia(m5);

        // --- Criando Podcasts ---
        PodCast p1 = new PodCast("NerdCast RPG: Cthulhu 1", 115.0, catalogo.getArtistaByNome("Jovem Nerd e Azaghal"));
        p1.addGenero(GeneroPodCast.HUMOR);
        catalogo.addMidia(p1);

        PodCast p2 = new PodCast("O Atentado na Eslováquia", 25.5, catalogo.getArtistaByNome("Folha de S.Paulo"));
        p2.addGenero(GeneroPodCast.NOTICIAS);
        catalogo.addMidia(p2);

        // --- Criando AudioBooks ---
        AudioBook a1 = new AudioBook("Dom Casmurro", 480.0, catalogo.getArtistaByNome("Machado de Assis"));
        a1.addGenero(GeneroAudioBook.ROMANCE);
        catalogo.addMidia(a1);

        AudioBook a2 = new AudioBook("Harry Potter e a Pedra Filosofal", 550.0, catalogo.getArtistaByNome("J.K. Rowling"));
        a2.addGenero(GeneroAudioBook.AVENTURA);
        catalogo.addMidia(a2);

        System.out.println("Dados carregados!");
    }
}

