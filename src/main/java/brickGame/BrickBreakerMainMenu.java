package brickGame;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.util.Duration;


public class BrickBreakerMainMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    private Parent createContent() {
        Pane root = new Pane();

        root.setPrefSize(500, 700);

        Image bgImage = new Image(getClass().getResource("/MainMenuImage.jpg").toExternalForm(), 500, 700, false, true);

        VBox box = new VBox(10, new MainMenuButton("Start", () -> {}),
                new MainMenuButton("LoadSave", () -> {}),
                new MainMenuButton("Exit", Platform::exit));

        box.setBackground(new Background(new BackgroundFill(Color.web("black", 0.6), null, null)));
        box.setTranslateX(150);
        box.setTranslateY(500);

        root.getChildren().addAll(new ImageView(bgImage), box);

        return root;
    }

    private static class MainMenuButton extends StackPane {
        MainMenuButton(String name, Runnable action) {
            LinearGradient gradient = new LinearGradient(0, 0.5, 1, 0.5, true, CycleMethod.NO_CYCLE,
                    new Stop(0.1, Color.web("black", 0.75)),
                    new Stop(1.0, Color.web("black", 0.5)));

            Rectangle bg = new Rectangle(200, 30, gradient);
            Rectangle bg1 = new Rectangle(200, 30, Color.web("black", 0.25));
            Rectangle line = new Rectangle(5, 30);
            FillTransition transition = new FillTransition(Duration.seconds(0.5), bg1, Color.web("black", 0.25), Color.web("white", 0.25));

            transition.setAutoReverse(true);
            transition.setCycleCount(Integer.MAX_VALUE);

            hoverProperty().addListener((observableValue, oldValue, isHovering) -> {
                if (isHovering) {
                    transition.playFromStart();
                } else {
                    transition.stop();
                    bg1.setFill(Color.web("black", 0.25));
                }
            });

            Text text = new Text(name);
            text.setFont(Font.font(20.0));
            text.fillProperty().bind(Bindings.when(hoverProperty()).then(Color.DARKRED).otherwise(Color.DARKGREY));

            line.fillProperty().bind(Bindings.when(hoverProperty()).then(Color.DARKRED).otherwise(Color.WHITE));
            line.widthProperty().bind(Bindings.when(hoverProperty()).then(5).otherwise(3));

            setOnMouseClicked(e -> action.run());

            setOnMousePressed(e -> bg.setFill(Color.WHITE));

            setOnMouseReleased(e -> bg.setFill(gradient));

            setAlignment(Pos.CENTER_LEFT);

            HBox box = new HBox(15, line, text);
            box.setAlignment(Pos.CENTER_LEFT);

            getChildren().addAll(bg, bg1, box);
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
}
