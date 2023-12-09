package brickGame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

        box.setTranslateX(100);
        box.setTranslateY(200);

        root.getChildren().addAll(new ImageView(bgImage), box);

        return root;
    }

    private static class MainMenuButton extends StackPane {
        MainMenuButton(String name, Runnable action) {
            LinearGradient gradient = new LinearGradient(0, 0.5, 1, 0.5, true, CycleMethod.NO_CYCLE,
                    new Stop(0.1, Color.web("white", 0.5)),
                    new Stop(1.0, Color.web("black", 0.5)));

            Rectangle bg = new Rectangle(200, 30, gradient);

            Text text = new Text(name);
            text.fillProperty().bind(Bindings.when(hoverProperty()).then(Color.WHITE).otherwise(Color.GRAY));
            getChildren().addAll(bg, text);
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
}
