package Models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Playlist {
    private String nmPlaylist;
    private int duracaoTotal = 0;
    public Set<Musica> musicasNaPlaylist = new HashSet<Musica>();
    private static PlaylistManager playlistManager;

    public Playlist(String nmPlaylist, Set<Musica> musicasNaPlaylist){
        this.nmPlaylist = nmPlaylist;
        this.musicasNaPlaylist = musicasNaPlaylist;
    }

    public Playlist() {
        if (playlistManager != null) {
            playlistManager.adicionarPlaylist(this);
        }
    }

    public Playlist(String nmPlaylist) {
        this.nmPlaylist = nmPlaylist;
        if (playlistManager != null) {
            playlistManager.adicionarPlaylist(this);
        }
    }

    public void procurarMusica(String nmMusica) {
        for (Musica musica : this.musicasNaPlaylist){
            if (musica.getNmMusica().toLowerCase().contains(nmMusica.toLowerCase())){
                System.out.println(musica.toString());
            } else {
                System.out.println("Música não encontrada.");
            }
        }
    }

    public void exibirPlaylist() {
        System.out.println("*** " + nmPlaylist + " ***");
        int i = 1;
        for (Musica musica : musicasNaPlaylist) {
            System.out.println(i + " - " + musica.getNmMusica());
            i++;
        }

        if (musicasNaPlaylist.isEmpty()) {
            System.out.println("Nenhuma música adicionada.");
        }
    }

    public void adicionarMusica(Musica musica) {
        if (this.musicasNaPlaylist.contains(musica)) {
            System.out.println("A música já está nesta playlist.");
        } else {
            this.musicasNaPlaylist.add(musica);
            this.duracaoTotal += musica.getDuracaoSegundos();
            System.out.println("Música adicionada com sucesso!");
        }
    }

    public void removerMusica(Musica musica) {
        if (this.musicasNaPlaylist.contains(musica)){
            this.musicasNaPlaylist.remove(musica);
            this.duracaoTotal -= musica.getDuracaoSegundos();
        }
    }

    public static void configurarPlaylistManager(PlaylistManager manager) {
        playlistManager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(nmPlaylist, playlist.nmPlaylist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nmPlaylist);
    }


    public String getNmPlaylist() {
        return nmPlaylist;
    }

    public void setNmPlaylist(String nmPlaylist) {
        this.nmPlaylist = nmPlaylist;
    }

    public int getDuracaoTotal() {
        return duracaoTotal;
    }

    public void setDuracaoTotal(int duracaoTotal) {
        this.duracaoTotal = duracaoTotal;
    }
}
