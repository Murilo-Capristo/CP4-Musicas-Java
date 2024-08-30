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

        String menu = "*** *** SPOTFIAP *** ***\n\n" +
                "Digite sua opção: \n" +
                "(1) - Criar Playlist\n" +
                "(2) - Exibir Playlist\n" +
                "(3) - Pesquisar na Plalist\n" +
                "(4) - Alterar o nome de uma Playlist\n" +
                "(5) - Excluir Playlist\n" +
                "(6) - Adicionar Músicas em uma Playlist\n" +
                "(7) - Remover Música de uma Playlist\n" +
                "(8) - Cadastrar uma Música\n" +
                "(9) - Sair\n" +
                "> ";

        boolean ligado = true;

        while (ligado) {
            Thread.sleep(1500);
            System.out.print(menu);
            try {
                int opcao = leitorInt.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do playlist: ");
                        String nomePlaylist = leitorStr.nextLine();
                        Playlist playlist = new Playlist(nomePlaylist);
                        break;
                    case 2:
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
                    case 3:
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
                    case 4:
                        System.out.print("Qual playlist deseja alterar?\n> ");

                    case 9:
                        System.out.println("Até logo!");
                        ligado = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Opção Inválida!\n Por favor, digite um número.\n> ");
                leitorInt.nextLine();
            }
        }


    }
}
