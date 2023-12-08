package brickGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BrickBreakerMainMenu extends Application {
    private Stage stage;
    private Scene scene;
    private VBox root;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        root = new VBox();
        scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();

        Button start = new Button("Start");
        start.setOnAction(e -> {
            try {
                new Main().start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button exit = new Button("Exit");
        exit.setOnAction(e -> {
            stage.close();
        });

        root.getChildren().addAll(start, exit);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
