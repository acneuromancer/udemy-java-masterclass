package section_19._02_musicdb;

import section_19._02_musicdb.model.Artist;
import section_19._02_musicdb.model.DataSource;
import section_19._02_musicdb.model.SongArtist;

import java.util.List;

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

        dataSource.querySongsMetaData();

        dataSource.close();
    }

    private static void query1() {
        List<Artist> artists = dataSource.queryArtist(DataSource.ORDER_BY_ASC);
        if (artists == null) {
            System.out.println("No artists!");
        } else {
            artists.forEach(System.out::println);
        }
    }

    private static void query2() {
        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Iron Maiden", DataSource.ORDER_BY_ASC);
        if (albumsForArtist == null) {
            System.out.println("No albums!");
        } else {
            albumsForArtist.forEach(System.out::println);
        }
    }

    private static void query3() {
        List<SongArtist> songArtists = dataSource.queryArtistForSong("Go Your Own Way", DataSource.ORDER_BY_ASC);
        if (songArtists == null) {
            System.out.println("Couldn't find the artist for the song");
        } else {
            for (SongArtist artist : songArtists) {
                System.out.println("Artist name = " + artist.getArtistName() +
                        ", album name = " + artist.getAlbumName() +
                        ", track = " + artist.getTrack());
            }
        }
    }

}
