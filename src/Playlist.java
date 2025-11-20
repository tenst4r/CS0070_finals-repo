import java.util.ArrayList;

public class Playlist {

    private ArrayList<Song> songs;
    private int currentIndex;

    public Playlist() {
        songs = new ArrayList<>();
        currentIndex = 0;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(int index) {
        if (index >= 0 && index < songs.size()) {
            songs.remove(index);
        }
    }

    public Song getCurrentSong() {
        if (songs.isEmpty()) return null;
        return songs.get(currentIndex);
    }

    public Song nextSong() {
        if (songs.isEmpty()) return null;
        currentIndex = (currentIndex + 1) % songs.size();
        return getCurrentSong();
    }

    public Song prevSong() {
        if (songs.isEmpty()) return null;
        currentIndex = (currentIndex - 1 + songs.size()) % songs.size();
        return getCurrentSong();
    }

    public void showPlaylist() {
        System.out.println("Playlist:");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println(i + ". " + songs.get(i));
        }
    }

    public int size() {
        return songs.size();
    }

    // CHOOSE SONG 0 BASED
    public void setCurrentIndex(int index) {
        if (index >= 0 && index < songs.size()) {
            this.currentIndex = index;
        }
    }
}
