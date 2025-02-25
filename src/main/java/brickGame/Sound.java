package brickGame;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Sound {
    private static final String MAINMENUMUSIC_FILE = "src/main/resources/Sound/MainMenuMusic.mp3";
    private static final String INGAMEMUSIC_FILE = "src/main/resources/Sound/InGameMusic.mp3";
    private static final String BREAK_FILE = "src/main/resources/Sound/BrickBroken.mp3";
    private static final String LOSEHEART_FILE = "src/main/resources/Sound/LoseHeart.mp3";
    private static final String LOSEGAME_FILE = "src/main/resources/Sound/LoseGame.mp3";
    private static final String LOSESCREEN_FILE = "src/main/resources/Sound/LoseScreenMusic.mp3";
    private static final String PLATFORMHIT_FILE = "src/main/resources/Sound/PlatformHit.mp3";
    private static final String POWERUP_FILE = "src/main/resources/Sound/PowerUp.mp3";
    private static final String LEVELUP_FILE = "src/main/resources/Sound/LevelUp.mp3";
    private static final String SELECTBUTTON_FILE = "src/main/resources/Sound/SelectButton.mp3";
    private static final String HEARTPOWERUP_FILE = "src/main/resources/Sound/HeartPowerUp.mp3";
    private static MediaPlayer mediaPlayer;

    public static void playBackgroundMusic() {
        Media sound = new Media(new File(MAINMENUMUSIC_FILE).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public static void playInGameMusic() {
        Media sound = new Media(new File(INGAMEMUSIC_FILE).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.5);
    }

    public static void playLoseScreenMusic() {
        Media sound = new Media(new File(LOSESCREEN_FILE).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.5);
    }

    public static void stopBackgroundMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public static void stopInGameMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            //System.out.println("in game music stop"); to test out a bug. Its been fixed
        }
    }

    public static void stopLoseScreenMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public static void playBlockBreakSound() {
        Media sound = new Media(new File(BREAK_FILE).toURI().toString());
        MediaPlayer blockBreakMediaPlayer = new MediaPlayer(sound);
        blockBreakMediaPlayer.play();
        blockBreakMediaPlayer.setVolume(0.5);
    }

    public static void playLoseHeartSound() {
        Media sound = new Media(new File(LOSEHEART_FILE).toURI().toString());
        MediaPlayer loseHeartMediaPlayer = new MediaPlayer(sound);
        loseHeartMediaPlayer.play();
        loseHeartMediaPlayer.setVolume(1.5);
    }

    public static void playLoseGameSound() {
        Media sound = new Media(new File(LOSEGAME_FILE).toURI().toString());
        MediaPlayer loseGameMediaPlayer = new MediaPlayer(sound);
        loseGameMediaPlayer.play();
        loseGameMediaPlayer.setVolume(1.5);
    }

    public static void playHitPlatformSound() {
        Media sound = new Media(new File(PLATFORMHIT_FILE).toURI().toString());
        MediaPlayer blockBreakMediaPlayer = new MediaPlayer(sound);
        blockBreakMediaPlayer.play();
        blockBreakMediaPlayer.setVolume(2);
    }

    public static void playObtainPowerUp() {
        Media sound = new Media(new File(POWERUP_FILE).toURI().toString());
        MediaPlayer blockBreakMediaPlayer = new MediaPlayer(sound);
        blockBreakMediaPlayer.play();
        blockBreakMediaPlayer.setVolume(1);
    }

    public static void playObtainHeartPowerUp() {
        Media sound = new Media(new File(HEARTPOWERUP_FILE).toURI().toString());
        MediaPlayer blockBreakMediaPlayer = new MediaPlayer(sound);
        blockBreakMediaPlayer.play();
        blockBreakMediaPlayer.setVolume(1);
    }

    public static void playLevelUp() {
        Media sound = new Media(new File(LEVELUP_FILE).toURI().toString());
        MediaPlayer blockBreakMediaPlayer = new MediaPlayer(sound);
        blockBreakMediaPlayer.play();
        blockBreakMediaPlayer.setVolume(0.75);
    }

    public static void playSelectButton() {
        Media sound = new Media(new File(SELECTBUTTON_FILE).toURI().toString());
        MediaPlayer blockBreakMediaPlayer = new MediaPlayer(sound);
        blockBreakMediaPlayer.play();
        blockBreakMediaPlayer.setVolume(2);
    }
}

