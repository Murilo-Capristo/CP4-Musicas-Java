package Models;

import java.util.Set;

public class Playlist {
    private String nmPlaylist;
    private double duracaoTotal = 0;
    public Set<Musica> musicas;

    public Playlist(String nmPlaylist) {
        this.nmPlaylist = nmPlaylist;
    }
    public void procurarMusica(){}

    public void exibirPlaylist(){}

    public void addMusica(Musica musica){
        this.musicas.add(musica);
        this.duracaoTotal =+ musica.getDuracao();


    }

    public void removeMusica(Musica musica){
        if (this.musicas.remove(musica)){
            this.duracaoTotal =+musica.getDuracao();
        }
    }

    public void deletePlaylist(){}



    public String getNmPlaylist() {
        return nmPlaylist;
    }

    public void setNmPlaylist(String nmPlaylist) {
        this.nmPlaylist = nmPlaylist;
    }

    public double getDuracaoTotal() {
        return duracaoTotal;
    }

    public void setDuracaoTotal(int duracaoTotal) {
        this.duracaoTotal = duracaoTotal;
    }
}
