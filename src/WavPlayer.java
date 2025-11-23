import javax.sound.sampled.*;
import java.io.File;

public class WavPlayer extends AudioPlayer {

    private Clip clip;
    private String filePath;

    public WavPlayer(String path) {
        this.filePath = path;
        loadClip();
    }

    private void loadClip() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
            System.out.println("Error loading audio file: " + e.getMessage());
        }
    }

    @Override
    public void play() {
        try {
            if (clip == null) return;

            clip.start();
            setStatus("Playing");
        } catch (Exception e) {
            System.out.println("Error playing audio.");
        }
    }

    @Override
    public void pause() {
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
                setStatus("Paused");
                System.out.println("Audio paused.");
            }
        } catch (Exception e) {
            System.out.println("Error pausing audio.");
        }
    }

    @Override
    public void stop() {
        try {
            if (clip != null) {
                clip.stop();
                clip.setFramePosition(0);
                setStatus("Stopped");
                System.out.println("Audio Stopped.");
            }
        } catch (Exception e) {
            System.out.println("Error stopping audio.");
        }
    }

    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }
}
