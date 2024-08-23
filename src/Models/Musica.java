package Models;

import Enums.GeneroEnum;

import java.util.HashSet;
import java.util.Set;

public class Musica {
    private String nmMusica;
    private String nmArtista;
    private double duracao;
    private GeneroEnum genero;
    public static Set<Musica> musicas = new HashSet<>() ;

    public Musica(){}

    public Musica(String nmMusica, String nmArtista, double duracao, GeneroEnum genero) {
        this.nmMusica = nmMusica;
        this.nmArtista = nmArtista;
        this.duracao = duracao;
        this.genero = genero;
        musicas.add(this);
    }
    public static Musica buscarMusicaPorNome(String nmMusica){
        for (Musica musica : musicas){
            if (musica.getNmMusica().contains(nmMusica.toLowerCase())){
                return musica;
            }
        }return null;
    }


    public void deletarMusica(){}

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
