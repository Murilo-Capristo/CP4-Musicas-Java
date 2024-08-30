package Tests;

import Enums.GeneroEnum;
import Models.Musica;
import Models.Playlist;
import Models.PlaylistManager;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PlaylistManager manager = new PlaylistManager();
        Playlist.configurarPlaylistManager(manager);

        Scanner leitorStr = new Scanner(System.in);
        Scanner leitorInt = new Scanner(System.in);

        String menu = "\n*** *** SPOTFIAP *** ***\n\n" +
                "Digite sua opção: \n" +
                "(1) - Listar Playlists\n" +
                "(2) - Criar Playlist\n" +
                "(3) - Exibir Playlist\n" +
                "(4) - Pesquisar na Plalist\n" +
                "(5) - Alterar o nome de uma Playlist\n" +
                "(6) - Excluir Playlist\n" +
                "(7) - Adicionar Músicas em uma Playlist\n" +
                "(8) - Remover Música de uma Playlist\n" +
                "(9) - Listar Músicas\n" +
                "(10) - Buscar Música\n" +
                "(11) - Cadastrar uma Música\n" +
                "(12) - Sair\n" +
                "> ";

        boolean ligado = true;

        while (ligado) {
            Thread.sleep(1500);
            System.out.print(menu);
            try {
                int opcao = leitorInt.nextInt();

                switch (opcao) {
                    case 1:
                        manager.exibirPlaylists();
                        break;

                    case 2:
                        System.out.print("Digite o nome do playlist: ");
                        String nomePlaylist = leitorStr.nextLine();
                        Playlist playlist = new Playlist(nomePlaylist);
                        break;

                    case 3:
                        boolean achou = false;
                        if (manager.playlists.isEmpty()) {
                            System.out.println("Nenhuma playlist criada.");
                            break;
                        }
                        System.out.println("Digite o nome da Playlist: ");
                        String nomePlaylist2 = leitorStr.nextLine();

                        for (Playlist plylist : manager.playlists) {
                            if (plylist.getNmPlaylist().toLowerCase().contains(nomePlaylist2.toLowerCase())) {
                                plylist.exibirPlaylist();
                                achou = true;
                                break;
                            }
                        }

                        if (achou == false) {
                            System.out.println("Playlist não encontrada!");
                        }

                        break;

                    case 4:
                        System.out.print("Em qual Playlist deseja procurar?\n> ");
                        String nmPlaylist = leitorStr.nextLine();
                        Playlist playlistEscolhida;
                        boolean encontrou = false;
                        for (Playlist plylist : manager.playlists) {
                            if (plylist.getNmPlaylist().toLowerCase().contains(nmPlaylist.toLowerCase())) {
                                playlistEscolhida = plylist;
                                encontrou = true;

                                System.out.print("Digite o nome da música: ");
                                String musicaEscolhida = leitorStr.nextLine();

                                boolean musicaAchada = false;
                                for (Musica musica : playlistEscolhida.musicasNaPlaylist) {
                                    if (musica.getNmMusica().toLowerCase().contains(musicaEscolhida.toLowerCase())) {
                                        musica.exibirMusica();
                                        musicaAchada = true;
                                        break;
                                    }
                                }

                                if (musicaAchada == false) {
                                    System.out.println("Música não encontrada na Playlist!");
                                }
                                break;
                            }
                        }

                        if (encontrou == false) {
                            System.out.println("Playlist não encontrada!");
                        }

                        break;

                    case 5:
                        System.out.print("Qual playlist deseja alterar?\n> ");
                        String playlistAlterar = leitorStr.nextLine();
                        boolean axou = false;
                        for (Playlist plylist : manager.playlists) {
                            if (plylist.getNmPlaylist().toLowerCase().contains(playlistAlterar.toLowerCase())) {
                                axou = true;
                                System.out.println("Playlist '" + plylist.getNmPlaylist() + "' encontrada.");
                                System.out.print("Digite o novo nome: ");

                                String novoNome = leitorStr.nextLine();
                                plylist.setNmPlaylist(novoNome);
                                System.out.println("Nome alterado com sucesso!");
                                break;
                            }
                        }

                        if (axou == false) {
                            System.out.println("Playlist não encontrada!");
                        }

                        break;

                    case 6:
                        if (manager.playlists.isEmpty()) {
                            System.out.println("Nenhuma playlist criada.");
                            break;
                        } else {
                            System.out.print("Qual playlist deseja excluir?\n> ");
                            String playlistExcluir = leitorStr.nextLine();
                            boolean achado = false;

                            for (Playlist plylist : manager.playlists) {
                                if (plylist.getNmPlaylist().toLowerCase().contains(playlistExcluir.toLowerCase())) {
                                    achado = true;
                                    System.out.println("Playlist '" + plylist.getNmPlaylist() + "' encontrada.");
                                    System.out.print("Tem certeza que deseja excluir? (Sim/Não)\n> ");
                                    String confirmacao;
                                    confirmacao = leitorStr.nextLine();

                                    if (confirmacao.toLowerCase().charAt(0) == 's') {
                                        manager.deletarPlaylist(plylist);
                                    } else {
                                        System.out.println("Playlist não deletada.");
                                    }
                                    break;
                                }
                            }

                            if (achado == false) {
                                System.out.println("Playlist não encontrada!");
                            }
                            break;
                        }

                    case 7:
                        if (manager.playlists.isEmpty()) {
                            System.out.println("Nenhuma playlist criada.");
                        } else {
                            System.out.print("Digite o nome da Playlist: ");
                            String nomePlaList = leitorStr.nextLine();

                            boolean achados = false;
                            for (Playlist plylist : manager.playlists) {
                                if (plylist.getNmPlaylist().toLowerCase().contains(nomePlaList.toLowerCase())) {
                                    achados = true;
                                    System.out.println("Playlist '" + plylist.getNmPlaylist() + "' Selecionada.");
                                    System.out.print("Digite o nome da música a adicionar: ");
                                    String musicaAdicionar = leitorStr.nextLine();

                                    boolean achadinho = false;
                                    for (Musica musica : Musica.musicasCadastradas) {
                                        if (musica.getNmMusica().toLowerCase().contains(musicaAdicionar.toLowerCase())) {
                                            achadinho = true;
                                            plylist.adicionarMusica(musica);
                                            break;
                                        }
                                    }

                                    if (achadinho == false) {
                                        System.out.println("Música não encontrada.");
                                    }
                                }
                            }

                            if (achados == false) {
                                System.out.println("Playlist não encontrada.");
                            }
                            break;
                        }

                        break;

                    case 8:
                        if (manager.playlists.isEmpty()) {
                            System.out.println("Nenhuma playlist criada.");
                        } else {
                            System.out.print("Digite o nome da Playlist: ");
                            String nomePList = leitorStr.nextLine();

                            boolean achades = false;
                            for (Playlist plylist : manager.playlists) {
                                if (plylist.getNmPlaylist().toLowerCase().contains(nomePList.toLowerCase())) {
                                    achades = true;
                                    System.out.println("Playlist '" + plylist.getNmPlaylist() + "' Selecionada.");
                                    System.out.print("Digite o nome da música a remover: ");
                                    String musicaAdicionar = leitorStr.nextLine();

                                    boolean axadinho = false;
                                    for (Musica musica : Musica.musicasCadastradas) {
                                        if (musica.getNmMusica().toLowerCase().contains(musicaAdicionar.toLowerCase())) {
                                            axadinho = true;
                                            plylist.removerMusica(musica);
                                            break;
                                        }
                                    }

                                    if (axadinho == false) {
                                        System.out.println("Música não encontrada.");
                                    }
                                }
                            }

                            if (achades == false) {
                                System.out.println("Playlist não encontrada.");
                            }
                            break;
                        }

                        break;

                    case 9:
                        Musica.listarMusicasCadastradas();
                        break;

                    case 10:
                        Musica.buscarMusicaPorNome();
                        break;

                    case 11:
                        System.out.print("Digite o nome da Música: ");
                        String nmMusicaNova = leitorStr.nextLine();
                        System.out.print("Digite o Autor da Música: ");
                        String autorMscNova = leitorStr.nextLine();
                        System.out.print("Quantos MINUTOS a música possui: ");
                        int minutos = leitorInt.nextInt();
                        System.out.print("Agora os SEGUNDOS: ");
                        int segundos = leitorInt.nextInt();
                        int duracaoSegundos = minutos*60 + segundos;
                        String duracao = minutos + ":" + segundos;
                        System.out.println("Escolha o gênero desta música: ");
                        System.out.println("(1) - Pop");
                        System.out.println("(2) - Hip Hop");
                        System.out.println("(3) - MPB");
                        System.out.println("(4) - Samba/Pagode");
                        System.out.println("(5) - Eletrônica");
                        System.out.println("(6) - Rock");
                        System.out.println("(7) - Indie");
                        System.out.println("(8) - Jazz");
                        System.out.println("(9) - Blues");
                        System.out.println("(10) - Metal");
                        System.out.print("> ");
                        int opcaoGenero = leitorInt.nextInt();
                        GeneroEnum genero = null;
                        switch (opcaoGenero) {
                            case 1:
                                genero = GeneroEnum.POP;
                                break;
                            case 2:
                                genero = GeneroEnum.HIPHOP;
                                break;
                            case 3:
                                genero = GeneroEnum.MPB;
                                break;
                            case 4:
                                genero = GeneroEnum.SAMBAPAGODE;
                                break;
                            case 5:
                                genero = GeneroEnum.ELETRONICA;
                                break;
                            case 6:
                                genero = GeneroEnum.ROCK;
                                break;
                            case 7:
                                genero = GeneroEnum.INDIE;
                                break;
                            case 8:
                                genero = GeneroEnum.JAZZ;
                                break;
                            case 9:
                                genero = GeneroEnum.BLUES;
                                break;
                            case 10:
                                genero = GeneroEnum.METAL;
                                break;
                            default:
                                System.out.println("Opção Inválida!");
                                break;
                        }

                        if (genero != null) {
                            Musica musicaNova = new Musica(nmMusicaNova, autorMscNova, duracao, genero, duracaoSegundos);
                        }
                        break;

                    case 12:
                        System.out.println("Até logo!");
                        ligado = false;
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.print("Opção Inválida!\n Por favor, digite um número.\n> ");
                leitorInt.nextLine();
            }
        }


    }
}
