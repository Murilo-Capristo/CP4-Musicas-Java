package Models;

import java.util.HashSet;
import java.util.Set;

public class PlaylistManager {
    public Set<Playlist> playlists = new HashSet<>();


    public void adicionarPlaylist(Playlist playlist) {
        playlists.add(playlist);
        System.out.println("Playlist criada: " + playlist.getNmPlaylist());
    }

    public void deletarPlaylist(Playlist playlist) {
        if (this.playlists.contains(playlist)) {
            this.playlists.remove(playlist);
            System.out.println("Playlist deletada com sucesso!");
        }
    }

    public void exibirPlaylists() {
        if (this.playlists.size() == 0) {
            System.out.println("Nenhuma Playlist criada.");
        } else {
            System.out.println("*".repeat(35));
            for (Playlist playlist : playlists) {
                System.out.println("Playlist: " + playlist.getNmPlaylist());
                System.out.print("Qtd. Músicas: " + (playlist.musicasNaPlaylist.stream().count()));
                System.out.println("\t Duração total: " + (playlist.getDuracaoTotal()/60) + "m.");
                System.out.println("*".repeat(35));
            }
        }
    }


}
