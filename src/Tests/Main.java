package Tests;

import Enums.GeneroEnum;
import Models.Musica;
import Models.Playlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitorStr = new Scanner(System.in);
        Scanner leitorInt = new Scanner(System.in);

        //CRIAR NOVA MUSICA
        while (true) {
            System.out.println("Digite o nome da Musica: ");
            String nmMusica = leitorStr.nextLine();
            System.out.println("Nome do Artista: ");
            String nmArtista = leitorStr.nextLine();
            System.out.println("Duração da Musica (Ex.: 4.36 ):");
            double duracao = leitorInt.nextDouble();
            leitorStr.nextLine();

            System.out.println("Qual o Genero da Musica: ");
            for (GeneroEnum genero : GeneroEnum.values()) {
                System.out.println(genero.ordinal() + " " + genero);
            }
            int generoEscolhido = leitorInt.nextInt();
            leitorStr.nextLine();
            GeneroEnum genero = GeneroEnum.values()[generoEscolhido];

            Musica musica = new Musica(nmMusica,  nmArtista, duracao, genero);
            System.out.println("Musica adicionada a lista de músicas existentes!!");
            System.out.println("Deseja adicionar mais músicas? (sim/não):");
            String resposta = leitorStr.nextLine();
            if (resposta.equalsIgnoreCase("não")||resposta.equalsIgnoreCase("nao")){
                break;

            }
        }
        //CRIAR NOVA PLAYLIST
        System.out.println("Digite o nome da Playlist: ");
        String nmPlaylist = leitorStr.nextLine();

        //BUSCAR MUSICA FORA DA PLAYLIST
        public static Musica buscarMusica
        System.out.println("Digite o nome da Música para buscar: ");
        String buscaMusica = leitorStr.nextLine();





        Musica musica = new Musica("Sei la", "sei la", 2, GeneroEnum.ROCK);
        for (Musica obj : Musica.musicas) {
            System.out.println(obj.getNmMusica());

        }
    }


}


















