public class Song {

    private String title;
    private String filePath;

    public Song(String title, String path) {
        this.title = title;
        this.filePath = path;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return filePath;
    }

    @Override
    public String toString() {
        return title + " (" + filePath + ")";
    }
}
