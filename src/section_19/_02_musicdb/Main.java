package section_19._02_musicdb;

import section_19._02_musicdb.model.Artist;
import section_19._02_musicdb.model.DataSource;
import section_19._02_musicdb.model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static DataSource dataSource;

    static {
        dataSource = new DataSource();
    }

    public static void main(String[] args) {
        if (!dataSource.open()) {
            System.out.println("Can't open datasource.");
            return;
        }

        insertSongExample();

        dataSource.close();
    }

    private static void query1() {
        List<Artist> artists = dataSource.queryArtist(DataSource.ORDER_BY_ASC);
        if (artists == null || artists.isEmpty()) {
            System.out.println("No artists!");
        } else {
            artists.forEach(System.out::println);
        }
    }

    private static void query2() {
        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Iron Maiden", DataSource.ORDER_BY_ASC);
        if (albumsForArtist == null || albumsForArtist.isEmpty()) {
            System.out.println("No albums!");
        } else {
            albumsForArtist.forEach(System.out::println);
        }
    }

    private static void query3() {
        /*
        SELECT artists.name, albums.name, songs.track FROM songs
        INNER JOIN albums ON songs.album = albums._id
        INNER JOIN artists ON albums.artist = artists._id
        WHERE songs.title="Go Your Own Way"
        ORDER BY artists.name, albums.name COLLATE NOCASE ASC
        */

        List<SongArtist> songArtists = dataSource.queryArtistForSong("Go Your Own Way", DataSource.ORDER_BY_ASC);
        if (songArtists == null || songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
        } else {
            for (SongArtist artist : songArtists) {
                System.out.println("Artist name = " + artist.getArtistName() +
                        ", album name = " + artist.getAlbumName() +
                        ", track = " + artist.getTrack());
            }
        }
    }

    private static void query4() {
        int count = dataSource.getCount(DataSource.TABLE_SONGS);
        System.out.println("Number of songs is " + count);
    }

    private static void query5() {
        System.out.println("Create view for SongArtists: " + dataSource.createViewForSongArtist());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title:");
        String title = scanner.nextLine();

        List<SongArtist> songArtists = dataSource.querySongInfoView(title);

        if (songArtists == null || songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for (SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
                    ", album name = " + artist.getAlbumName() +
                    ", track number = " + artist.getTrack()
            );
        }

        scanner.close();
    }

    private static void insertSongExample() {
        dataSource.insertSong("Bird Dog", "Everly Brothers", "All-Time Greatest Hits", 7);
    }

}
