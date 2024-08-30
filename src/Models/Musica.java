package Models;

import Enums.GeneroEnum;

import java.util.*;

public class Musica {
    private String nmMusica;
    private String nmArtista;
    private String duracao;
    private int duracaoSegundos;
    private GeneroEnum genero;
    private String nomePlaylist;
    public static Set<Musica> musicasCadastradas = new HashSet<>() ;

    public static final Map<GeneroEnum, String> generoMap = new HashMap<>();



    public Musica(String nomePlaylist, Musica m){
        this.nomePlaylist = nomePlaylist;
        this.nmMusica = m.nmMusica;
        this.nmArtista = m.nmArtista;
        this.duracao = m.duracao;
        this.genero = m.genero;
        this.duracaoSegundos = m.duracaoSegundos;
//        musicasCadastradas.add(this);

    }


    static {
        generoMap.put(GeneroEnum.POP, "Pop");
        generoMap.put(GeneroEnum.HIPHOP, "Hip Hop");
        generoMap.put(GeneroEnum.MPB, "MPB");
        generoMap.put(GeneroEnum.SAMBAPAGODE, "Samba/Pagode");
        generoMap.put(GeneroEnum.ELETRONICA, "Eletrônica");
        generoMap.put(GeneroEnum.ROCK, "Rock");
        generoMap.put(GeneroEnum.INDIE, "Indie");
        generoMap.put(GeneroEnum.JAZZ, "Jazz");
        generoMap.put(GeneroEnum.BLUES, "Blues");
        generoMap.put(GeneroEnum.METAL, "Metal");
    }

    public Musica(){}

    public Musica(String nmMusica, String nmArtista, String  duracao, GeneroEnum genero, int duracaoSegundos) {
        this.nmMusica = nmMusica;
        this.nmArtista = nmArtista;
        this.duracao = duracao;
        this.genero = genero;
        this.duracaoSegundos = duracaoSegundos;
        musicasCadastradas.add(this);

        System.out.println("Música '" + nmMusica + "' cadastrada.");
    }

    public static void buscarMusicaporGenero() {
        Scanner leitorInt = new Scanner(System.in);

        if (!musicasCadastradas.isEmpty()) {
            System.out.println("Qual Gênero deseja buscar: ");
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
                    System.out.println("Opção inválida.");
                    return;
            }


            GeneroEnum finalGenero = genero;
            musicasCadastradas.stream()
                    .filter(musica -> musica.getGenero().equals(finalGenero))
                    .sorted(Comparator.comparing(Musica::getNmMusica))
                    .forEach(System.out::println);
        } else {
            System.out.println("Não há músicas cadastradas.");
        }
    }

    public static void listarMusicasCadastradas() {
        if (!musicasCadastradas.isEmpty()) {
            System.out.println("_".repeat(35));
            for (Musica musica : musicasCadastradas) {
                System.out.println(musica.getNmArtista() + " - " + musica.getNmMusica());
                System.out.println("Duração: " + musica.getDuracao() + " \t\tGênero:" + generoMap.get(musica.getGenero()));
                System.out.println("_".repeat(35));
            }
        } else {
            System.out.println("Nenhum musica cadastrada.");;
        }
    }

    public static void buscarMusicaPorNome() {
        Scanner scStr = new Scanner(System.in);
        if (!musicasCadastradas.isEmpty()) {
            System.out.print("Digite o nome da Música: ");
            String nmMusicaBusca = scStr.nextLine();
            boolean achou = false;
            for (Musica musica : musicasCadastradas) {
                if (musica.getNmMusica().toLowerCase().contains(nmMusicaBusca.toLowerCase())){
                    achou = true;
                    musica.exibirMusica();
                    break;
                }
            }

            if (!achou) {
                System.out.println("Música não encontrada.");
            }
        } else {
            System.out.println("Nenhum música cadastrada.");
        }
    }

    public void exibirMusica() {
        System.out.println("_".repeat(35));
        System.out.println(this.getNmArtista() + " - " + this.getNmMusica());
        System.out.println("Duração: " + this.getDuracao() + " \t\tGênero:" + generoMap.get(this.getGenero()));
        System.out.println("_".repeat(35));
    }

    public String toString(){
        return  "Musicas da playlist: " + nomePlaylist + " - " +
                "Duração: " + duracaoSegundos + " segundos" + " - " +
                "Nome: '" + nmMusica + "'" + " - " +
                "Artista: " + nmArtista + " - " +
                "Gênero: " + generoMap.get(this.getGenero());

    }

    public void deletarMusica(Musica musica) {
        musicasCadastradas.remove(musica);
    }

    public String getNmMusica() {
        return nmMusica;
    }

    public void setNmMusica(String nmMusica) {
        this.nmMusica = nmMusica;
    }

    public String getNmArtista() {
        return nmArtista;
    }

    public void setNmArtista(String nmArtista) {
        this.nmArtista = nmArtista;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }
}
