
import entities.Usuario;
import excecoes.SenhaInvalidaException;
import excecoes.UsuarioNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

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

        for(Usuario usuario : usuariosCadastrados) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                System.out.println("Usuário logado com sucesso!");
                usuarioLogado = usuario;
                return;
            }
        }

        throw new UsuarioNaoEncontradoException("Usuário ou senha inválidos.");
    }

    public void cadastrarUsuario(Scanner scanner) {
        System.out.println("Digite o nome de usuário: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o seu email: ");
        String email = scanner.nextLine();
        System.out.println("A senha deve conter no minimo 6 caracteres");
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        if (senha.length() < 6) {
            throw new SenhaInvalidaException("A senha deve conter no minimo 6 caracteres");
        }else{

            Usuario usuarioCadastrado = new Usuario(nome, email, senha);
            usuariosCadastrados.add(usuarioCadastrado);

            System.out.println("Usuário cadastrado com sucesso!");
            usuarioLogado = usuarioCadastrado;

        }

    }

    public void verPlaylist() {
        for (int i = 0; i < usuarioLogado.getPlaylists().size(); i++) {
            System.out.println(i + " * " + usuarioLogado.getPlaylists().get(i).getNome());
        }
    }
}

