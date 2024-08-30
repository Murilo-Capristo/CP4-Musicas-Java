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
        } else {
            System.out.println("Playlist não encontrada.");
        }
    }

    public void exibirPlaylists() {
        for (Playlist playlist : playlists) {
            System.out.println("- " + playlist.getNmPlaylist() + "\n\tDuração: " + (playlist.getDuracaoTotal()/60));
        }
    }


}
