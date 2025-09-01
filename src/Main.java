import entities.Playlist;
import entities.Usuario;
import excecoes.SenhaInvalidaException;
import excecoes.UsuarioNaoEncontradoException;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Sistema sistema = new Sistema();
        Scanner scan = new Scanner(System.in);
        Usuario usuarioLogado;
        int opcao;

        if(sistema.getUsuarioLogado() != null) {

            do {
                System.out.println("---Menu----");
                System.out.println("1- Ver Playlists");
                System.out.println("2- Criar Playlist");
                System.out.println("3- Remover Playlist");
                System.out.println("4- Adicionar Midia na Playlist");
                System.out.println("5- Remover Midia da Playlist");
                System.out.println("6- Sair");
                System.out.print("Digite sua opção: ");
                opcao = scan.nextInt();
                scan.nextLine();
                switch (opcao) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                }
            }while (opcao != 6);

        }else {
            do {
                System.out.println("---Menu----");
                System.out.println("1- Logar");
                System.out.println("2- Cadastrar");
                System.out.println("3- Sair");
                System.out.print("Digite sua opção: ");
                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        try {
                            sistema.login(scan);
                        } catch (UsuarioNaoEncontradoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            sistema.cadastrarUsuario(scan);
                        } catch (SenhaInvalidaException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
            } while (opcao != 3);
            System.out.println("Saindo do Sistema!");
        }
        scan.close();
    }
}