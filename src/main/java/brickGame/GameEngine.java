
package brickGame;

import javafx.animation.AnimationTimer;

public class GameEngine {

    private OnAction onAction;
    private long lastUpdateTime = 0;
    private boolean isStopped = true;
    private long time = 0;

    public void setOnAction(OnAction onAction) {
        this.onAction = onAction;
    }

    public void setFps(int fps) {
    }

    public void start() {
        lastUpdateTime = 0;
        isStopped = false;
        onAction.onInit();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (lastUpdateTime == 0) {
                    lastUpdateTime = now;
                }

                long elapsedNanoSeconds = now - lastUpdateTime;
                double elapsedSeconds = elapsedNanoSeconds / 1_000_000_000.0;


                onAction.onUpdate();
                onAction.onPhysicsUpdate();


                lastUpdateTime = now;
                time++;
                onAction.onTime(time);

                if (isStopped) {
                    stop();
                }
            }
        }.start();
    }

    public void stop() {
        isStopped = true;
    }

    public interface OnAction {
        void onUpdate();

        void onInit();

        void onPhysicsUpdate();

        void onTime(long time);
    }
}
