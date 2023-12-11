package brickGame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
//import sun.plugin2.message.Message;

public class Score {
    public void show(final double x, final double y, int score, final Main main) {
        String sign = (score >= 0) ? "+" : "";
        final Label label = new Label(sign + score);
        label.setTranslateX(x);
        label.setTranslateY(y);
        main.root.getChildren().add(label);

        Timeline timeline = new Timeline();
        for (int i = 0; i < 21; i++) {
            final int scaleValue = i;
            KeyFrame keyFrame = new KeyFrame(
                    Duration.millis(i * 15),
                    e -> {
                        label.setScaleX(scaleValue);
                        label.setScaleY(scaleValue);
                        label.setOpacity((20 - scaleValue) / 20.0);
                    }
            );
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.setOnFinished(e -> main.root.getChildren().remove(label));
        timeline.play();
    }
    public void showMessage(String message, final Main main) {
        final Label label = new Label(message);
        label.setTranslateX(220);
        label.setTranslateY(340);
        main.root.getChildren().add(label);

        Timeline timeline = new Timeline();
        for (int i = 0; i < 21; i++) {
            final int scaleValue = Math.abs(i - 10);
            int finalI = i;
            KeyFrame keyFrame = new KeyFrame(
                    Duration.millis(i * 15),
                    e -> {
                        label.setScaleX(scaleValue);
                        label.setScaleY(scaleValue);
                        label.setOpacity((20 - finalI) / 20.0);
                    }
            );
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.setOnFinished(e -> main.root.getChildren().remove(label));
        timeline.play();
    }

    public void showGameOver(final Main main) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Sound.playLoseScreenMusic();
                Label label = new Label("Game Over :(");
                label.setTranslateX(200);
                label.setTranslateY(250);
                label.setScaleX(2);
                label.setScaleY(2);

                Button restart = new Button("Restart");
                restart.setTranslateX(220);
                restart.setTranslateY(300);
                restart.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        main.restartGame();
                    }
                });

                main.root.getChildren().addAll(label, restart);

            }
        });
    }

    public void showWin(final Main main) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Label label = new Label("You Win :)");
                label.setTranslateX(200);
                label.setTranslateY(250);
                label.setScaleX(2);
                label.setScaleY(2);


                main.root.getChildren().addAll(label);

            }
        });
    }
}
