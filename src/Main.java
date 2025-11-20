import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);

        // Add sONGS HERE
        playlist.addSong(new Song("Song 1", "playlist/on_tha_line.wav"));
        playlist.addSong(new Song("Song 2", "playlist/Aminé - Colors.wav"));
        playlist.addSong(new Song("Song 3", "playlist/Beneath the Mask.wav"));

        WavPlayer player = null;

        while (true) {
            System.out.println("\n===== AUDIO PLAYER MENU =====");
            System.out.println("[1] Show Playlist");
            System.out.println("[2] Play Current Song");
            System.out.println("[3] Pause");
            System.out.println("[4] Stop");
            System.out.println("[5] Next Song");
            System.out.println("[6] Previous Song");
            System.out.println("[7] Choose Song by Number");
            System.out.println("[8] Set Volume");
            System.out.println("[0] Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    playlist.showPlaylist();
                    break;

                case 2:
                    if (playlist.getCurrentSong() == null) {
                        System.out.println("Playlist is empty!");
                        break;
                    }
                    Song current = playlist.getCurrentSong();
                    System.out.println("Now Playing: " + current.getTitle());

                    player = new WavPlayer(current.getPath());
                    player.play();
                    break;

                case 3:
                    if (player != null) player.pause();
                    break;

                case 4:
                    if (player != null) player.stop();
                    break;

                case 5:
                    playlist.nextSong();
                    System.out.println("Next: " + playlist.getCurrentSong().getTitle());
                    break;

                case 6:
                    playlist.prevSong();
                    System.out.println("Previous: " + playlist.getCurrentSong().getTitle());
                    break;

                case 7:
                    playlist.showPlaylist();
                    System.out.print("Enter song number: ");
                    int songIndex = sc.nextInt();
                    sc.nextLine();
                    if (songIndex >= 0 && songIndex < playlist.size()) {
                        playlist.setCurrentIndex(songIndex);
                        System.out.println("Selected: " + playlist.getCurrentSong().getTitle());
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 8:
                    System.out.print("Enter volume (0–100): ");
                    int vol = sc.nextInt();
                    if (player != null) {
                        player.setVolume(vol);
                        System.out.println("Volume set to " + player.getVolume());
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    if (player != null) {
                        player.stop();
                    }
                    return;

                default:
                    System.out.println("Invalid input!");
            }
        }
    }
}
