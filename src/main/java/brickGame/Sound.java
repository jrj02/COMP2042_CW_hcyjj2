package brickGame;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Sound {
    private static final String MUSIC_FILE = "src/main/resources/Sound/MainMenuMusic.mp3";
    private static final String INGAMEMUSIC_FILE = "src/main/resources/Sound/InGameMusic.mp3";
    private static MediaPlayer mediaPlayer;

    public static void playBackgroundMusic() {
        Media sound = new Media(new File(MUSIC_FILE).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public static void playInGameMusic() {
        Media sound = new Media(new File(INGAMEMUSIC_FILE).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public static void stopBackgroundMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public static void stopInGameMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}

