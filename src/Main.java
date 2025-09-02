import entities.Admin;
import exceptions.*;
import service.Sistema;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Sistema sistema = new Sistema();
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("---Menu----");
            System.out.println("1- Logar");
            System.out.println("2- Cadastrar");
            System.out.println("3- Sair");
            System.out.print("Digite sua opção: ");
           try {
               opcao = scan.nextInt();
           }catch (Exception e) {
               System.out.println("Opção inválida!");
               opcao = 0;
           }finally {
               scan.nextLine();
           }

            switch (opcao) {
                case 1:
                    try {
                        sistema.login(scan);
                    } catch (RecursoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        sistema.cadastrarUsuario(scan);
                    } catch (CadastroInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    break;
            }
        } while (opcao != 3 && sistema.getUsuarioLogado() == null);

        if(sistema.getUsuarioLogado() == null) {

            System.out.println("Saindo do service.Sistema!");

        }
        if(sistema.getUsuarioLogado().getClass().equals(Admin.class)) {
            do{
                System.out.println("---Menu Admin----");
                System.out.println("1- Adicionar Midia ao Catalogo");
                System.out.println("2- Remover Midia do Catalogo");
                System.out.println("3- Adicionar Usuário");
                System.out.println("4- Remover Usuário");
                System.out.println("5- Listar Usuários");
                System.out.println("6- Deslogar");
                System.out.print("Digite sua opção: ");

                try{
                    opcao = scan.nextInt();
                }catch (Exception e) {
                    System.out.println("Opção inválida!");
                    opcao = 0;
                }finally {
                    scan.nextLine();
                }
        }while (opcao != 6);



        if (sistema.getUsuarioLogado() != null && !sistema.getUsuarioLogado().getClass().equals(Admin.class)) {
            System.out.println("Bem vindo, " + sistema.getUsuarioLogado().getNome() + "!");

            do {
                System.out.println("---Menu----");
                System.out.println("1- Ver Playlists");
                System.out.println("2- Criar Playlist");
                System.out.println("3- Remover Playlist");
                System.out.println("4- Adicionar Midia na Playlist");
                System.out.println("5- Remover Midia da Playlist");
                System.out.println("6- Sair");
                System.out.print("Digite sua opção: ");
                try{
                    opcao = scan.nextInt();
                }catch (Exception e) {
                    System.out.println("Opção inválida!");
                    opcao = 0;
                }finally {
                    scan.nextLine();
                }
                switch (opcao) {
                    case 1:
                        sistema.verPlaylists();
                        break;
                    case 2:
                        try {
                            sistema.criarPlaylist(scan);
                        } catch (PlaylistJaCriadaException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            sistema.removerPlaylist(scan);
                        } catch (RecursoNaoEncontradoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            sistema.adicionarMidiaAPlaylist(scan);
                        } catch (RecursoNaoEncontradoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            sistema.removerMidiaDaPlaylist(scan);
                        } catch (RecursoNaoEncontradoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        break;
                }
            }while (opcao != 6);

            System.out.println("Ate mais, " + sistema.getUsuarioLogado().getNome() + "!");

            scan.close();
        }


    }
    }
}

