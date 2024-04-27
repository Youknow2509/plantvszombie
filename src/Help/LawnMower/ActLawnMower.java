package src.Help.LawnMower;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Controller.Game.GameMainController;
import src.Model.Characters.Zombies.Zombie;

import java.io.Serializable;

public class ActLawnMower implements Serializable {
// Var
    private LawnMower lawnMower;
// Constructor
    public ActLawnMower() {
        super();
    }
    public ActLawnMower(LawnMower lawnMower) {
        super();
        this.lawnMower = lawnMower;
    }
// Method
    // Start
    public void start() {
        lawnMower.setTimeline(new Timeline(new KeyFrame(Duration.seconds(0.2)
                , e -> {
                    handle();
                }
        )));
        lawnMower.getTimeline().setCycleCount(Timeline.INDEFINITE);
        lawnMower.getTimeline().play();
    }

    // Handle
    private void handle() { // Xử lý lắng nghe xem Zombie có ở trước không, nếu có sẽ đổi trạng thái di chuyển và tấn công
        synchronized (GameMainController.getGameData().getZombieAlive()) {
            for (int i = 0; i < GameMainController.getGameData().getZombieAlive().size(); i++) {
                Zombie zombie = GameMainController.getGameData().getZombieAlive().get(i);
                if (zombie.getLane() == lawnMower.getLane()
                        && zombie.getX() - lawnMower.getX() < 35
                        && lawnMower.getX() < zombie.getX())
                {
                    attack();
                    break;
                }
            }
        }
    }

    // Move
    private void move() {
        if (lawnMower.getX() < 1010) {
            lawnMower.setX(lawnMower.getX() + lawnMower.getSpeed());
        }
        else {
            lawnMower.removeImageView();
            lawnMower.getTimeline().stop();
            GameMainController.getGameData().getLawnMowers().remove(lawnMower);
        }
    }

    // Attack zombie
    private void attack() {

        lawnMower.getTimeline().stop();
        lawnMower.changeImageView(lawnMower.getPathImageActive());
        lawnMower.setTimeline(new Timeline(new KeyFrame(Duration.millis(60)
                , e -> {
                    synchronized (GameMainController.getGameData().getZombieAlive()) {
                        boolean f = true;
                        for (int i = 0; i < GameMainController.getGameData().getZombieAlive().size(); i++) {
                            Zombie zombie = GameMainController.getGameData().getZombieAlive().get(i);
                            if (zombie.getLane() == lawnMower.getLane()
                                    && zombie.getX() - lawnMower.getX() <= 10
                                    && zombie.getX() > lawnMower.getX())
                            {
                                // Remove zombie
                                zombie.removeImageView();
                                (GameMainController.getGameData()).getZombieAlive().remove(zombie);

                                f = false;

                                break;
                            }
                        }
                        if (f) {
                            move();
                        }
                    }}
                )
        ));
        lawnMower.getTimeline().setCycleCount(Timeline.INDEFINITE);
        lawnMower.getTimeline().play();
    }

    // Getter and Setter
}
