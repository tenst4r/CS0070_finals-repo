public abstract class AudioPlayer implements Playable {

    private int volume;
    private String status;

    public AudioPlayer() {
        this.volume = 50;
        this.status = "Stopped";
    }

    public void setVolume(int v) {
        if (v < 0) v = 0;
        if (v > 100) v = 100;
        this.volume = v;
    }

    public int getVolume() {
        return volume;
    }

    public String getStatus() {
        return status;
    }

    protected void setStatus(String s) {
        this.status = s;
    }

    @Override
    public abstract void play();

    @Override
    public abstract void pause();

    @Override
    public abstract void stop();
}
