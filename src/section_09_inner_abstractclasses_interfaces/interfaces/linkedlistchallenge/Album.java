package section_09_inner_abstractclasses_interfaces.interfaces.linkedlistchallenge;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }

        return false;
    }

    public boolean addToPlaylist(int trackNumber, List<Song> playList) {
        int index = trackNumber - 1;
        if (index >= 0 && index <= songs.size()) {
            playList.add(songs.get(index));
            return true;
        }

        System.out.println("This album does not have a track " + trackNumber + ".");
        return false;
    }

    public boolean addToPlaylist(String title, List<Song> playList) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }

        System.out.println("The song " + title + " is not in this album.");
        return false;
    }

    private Song findSong(String title) {
        for (Song checkedSong : songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }

        return null;
    }

}
