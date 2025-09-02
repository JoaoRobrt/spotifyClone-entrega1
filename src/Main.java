import entities.Admin;
import entities.Usuario;
import exceptions.*;
import service.Sistema;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Sistema sistema = new Sistema();
        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        boolean executando = true;

        while(executando) {

            if(sistema.getUsuarioLogado() == null) {
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
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

            }else if (sistema.getUsuarioLogado() instanceof Admin) {
                do {
                    System.out.println("---Menu Admin----");
                    System.out.println("1- Adicionar Midia ao Catalogo");
                    System.out.println("2- Remover Midia do Catalogo");
                    System.out.println("3- Listar Midias do Catalogo");
                    System.out.println("4- Listar Usuários");
                    System.out.println("5- Listar Artistas");
                    System.out.println("6- Adicionar Artista ao Catalogo");
                    System.out.println("7- Remover Artista do Catalogo");
                    System.out.println("8- Deslogar");
                    System.out.print("Digite sua opção: ");

                    try {
                        opcao = scan.nextInt();
                    } catch (Exception e) {
                        System.out.println("Opção inválida!");
                        opcao = 0;
                    } finally {
                        scan.nextLine();
                    }
                    switch (opcao) {
                        case 1:
                            try {
                                sistema.adicionarMidiaAoCatalogo(scan);
                            } catch (RecursoNaoEncontradoException e) {
                                System.out.println(e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            try {
                                sistema.removerMidiaDoCatalogo(scan);
                            } catch (RecursoNaoEncontradoException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 3:
                            sistema.listarMidias();
                            break;
                        case 4:
                            sistema.listarUsuarios();
                            break;
                        case 5:
                            sistema.listarArtistas();
                            break;
                        case 6:
                            try {
                                sistema.adicionarArtistaAoCatalogo(scan);
                            } catch (RecursoNaoEncontradoException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 7:
                            try {
                                sistema.removerArtistaDoCatalogo(scan);
                            } catch (RecursoNaoEncontradoException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 8:
                            sistema.logout();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }


                }while (sistema.getUsuarioLogado() !=null && opcao != 4);
            }else if (sistema.getUsuarioLogado() != null) {
                System.out.println("Bem vindo, " + sistema.getUsuarioLogado().getNome() + "!");

                do {
                    System.out.println("---Menu----");
                    System.out.println("1- Ver Playlists");
                    System.out.println("2- Criar Playlist");
                    System.out.println("3- Remover Playlist");
                    System.out.println("4- Adicionar Midia na Playlist");
                    System.out.println("5- Remover Midia da Playlist");
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
                            System.out.println("Ate mais, " + sistema.getUsuarioLogado().getNome() + "!");
                            sistema.logout();
                            break;
                    }
                }while (sistema.getUsuarioLogado() != null && opcao != 6 );
            }
        }
        System.out.println("Obrigado por usar o sistema! Ate mais!");
        scan.close();
    }
}


