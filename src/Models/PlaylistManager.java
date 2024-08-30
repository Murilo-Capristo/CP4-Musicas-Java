package Models;

import Enums.GeneroEnum;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
            playlists.forEach(playlist -> {
                System.out.println("Playlist: " + playlist.getNmPlaylist());
                System.out.print("Qtd. Músicas: " + (playlist.musicasNaPlaylist.stream().count()));
                System.out.println("\t Duração total: " + (playlist.getDuracaoTotal()/60) + "m.");
                System.out.println("*".repeat(35));
            });
        }
    }
    public void carregarPlaylist(){
        Musica musica1 = new Musica("Shape of You", "Ed Sheeran", "3m30s", GeneroEnum.POP, 210);
        Musica musica2 = new Musica("Blinding Lights", "The Weeknd", "3m20s", GeneroEnum.POP, 200);
        Musica musica3 = new Musica("Rolling in the Deep", "Adele", "3m48s", GeneroEnum.POP, 228);
        Musica musica4 = new Musica("Lose Yourself", "Eminem", "5m26s", GeneroEnum.HIPHOP, 326);
        Musica musica5 = new Musica("Sicko Mode", "Travis Scott", "5m12s", GeneroEnum.HIPHOP, 312);
        Musica musica6 = new Musica("Numb", "Linkin Park", "3m07s", GeneroEnum.ROCK, 187);
        Musica musica7 = new Musica("Smells Like Teen Spirit", "Nirvana", "5m01s", GeneroEnum.ROCK, 301);
        Musica musica8 = new Musica("Zombie", "The Cranberries", "5m07s", GeneroEnum.ROCK, 307);
        Musica musica9 = new Musica("Take Five", "Dave Brubeck", "5m24s", GeneroEnum.JAZZ, 324);
        Musica musica10 = new Musica("So What", "Miles Davis", "9m22s", GeneroEnum.JAZZ, 562);
        Musica musica11 = new Musica("Come Together", "The Beatles", "4m20s", GeneroEnum.INDIE, 260);
        Musica musica12 = new Musica("Wake Up", "Arcade Fire", "5m33s", GeneroEnum.INDIE, 333);
        Musica musica13 = new Musica("Highway to Hell", "AC/DC", "3m28s", GeneroEnum.METAL, 208);
        Musica musica14 = new Musica("Enter Sandman", "Metallica", "4m31s", GeneroEnum.METAL, 271);
        Musica musica15 = new Musica("Little Wing", "Jimi Hendrix", "2m24s", GeneroEnum.BLUES, 144);
        Musica musica16 = new Musica("The Thrill Is Gone", "B.B. King", "5m24s", GeneroEnum.BLUES, 324);
        Musica musica17 = new Musica("Diva", "Beyoncé", "3m20s", GeneroEnum.ELETRONICA, 200);
        Musica musica18 = new Musica("Titanium", "David Guetta feat. Sia", "4m05s", GeneroEnum.ELETRONICA, 245);
        Musica musica19 = new Musica("Aquarela", "Toquinho", "3m40s", GeneroEnum.SAMBAPAGODE, 220);
        Musica musica20 = new Musica("Canta Canta Minha Gente", "Zeca Pagodinho", "3m00s", GeneroEnum.SAMBAPAGODE, 180);


        var musicasCurtidas = new Playlist("Musicas Curtidas", Set.of(musica1,musica2,musica3));
        var musicasNaoCurtidas = new Playlist("Músicas não Curtidas", Set.of(musica4, musica5, musica6));
        playlists.add(musicasNaoCurtidas);
        playlists.add(musicasCurtidas);}




    public void exibirPlaylistsPorDuracao(){
        Set<Musica>dadosMusicas = playlists.stream()
                        .flatMap(p-> p.musicasNaPlaylist.stream()
                                .map(m-> new Musica(p.getNmPlaylist(),m))
                                        .sorted(Comparator.comparing(Musica::getDuracaoSegundos)))
                                .collect(Collectors.toSet());
        dadosMusicas.forEach(System.out::println);


    }


}
