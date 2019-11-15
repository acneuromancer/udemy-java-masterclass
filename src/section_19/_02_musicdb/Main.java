package section_19._02_musicdb;

import section_19._02_musicdb.model.Artist;
import section_19._02_musicdb.model.DataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        if (!dataSource.open()) {
            System.out.println("Can't open datasource.");
            return;
        }

        List<Artist> artists = dataSource.queryArtist(DataSource.ORDER_BY_ASC);
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }

        artists.forEach(System.out::println);

        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Iron Maiden", DataSource.ORDER_BY_ASC);

        albumsForArtist.forEach(System.out::println);

        dataSource.close();
    }

}
