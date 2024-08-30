package Models;

import Enums.GeneroEnum;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Musica {
    private String nmMusica;
    private String nmArtista;
    private int duracao;
    private GeneroEnum genero;
    public static Set<Musica> musicasCadastradas = new HashSet<>() ;

    public Musica(){}

    public Musica(String nmMusica, String nmArtista, int  duracao, GeneroEnum genero) {
        this.nmMusica = nmMusica;
        this.nmArtista = nmArtista;
        this.duracao = duracao;
        this.genero = genero;
        musicasCadastradas.add(this);
    }

    public static Musica buscarMusicaPorNome(String nmMusica){
        for (Musica musica : musicasCadastradas){
            if (musica.getNmMusica().toLowerCase().contains(nmMusica.toLowerCase())){
                return musica;
            }
        } return null;
    }

    public void exibirMusica(){
        System.out.println("*".repeat(30));
        System.out.println("Nome: " + nmMusica + "\tDuração: " + duracao + "\n\t\tGenero: " + genero);
        System.out.println("*".repeat(30));
    }

    public void deletarMusica(Musica musica){
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

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }
}
