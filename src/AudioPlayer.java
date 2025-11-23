public abstract class AudioPlayer implements Playable {

    private String status;

    public AudioPlayer() {
        this.status = "Stopped";
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
