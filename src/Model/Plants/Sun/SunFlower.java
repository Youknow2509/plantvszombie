package src.Model.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import src.Config.Path;
import src.Model.Plants.Plant;
import src.Model.Plants.Sun.Sun;

import java.util.ArrayList;
import java.util.List;

public class SunFlower extends Plant {
    // Var infomation of SunFlower
    private static final  int HP = 100;
    private static final  int COST = 50;
    private static final  int WIDTH = 60;
    private static final  int HEIGHT = 60;
    private static final int TIMEOUT_FLOWERSUN = 6000;
    private static final int SPEED_ATTACK = 4500;
    private static final int DAME = 0;
    // Var
    private List<Timeline> timelineList;
    // Constructor
    public SunFlower() {
        super();
        timelineList = new ArrayList<Timeline>();
    }
    public SunFlower(double x, double y, int col, int row) {
        super(x, y, Path.ASSETS_Image_SunFlower, WIDTH, HEIGHT, HP, col, row, COST, SPEED_ATTACK, DAME);
        createImageViewInGridPane();
        timelineList = new ArrayList<Timeline>();
    }
    // Tạo ra mặt trời - Adapter Pattern
    @Override
    public void start() {
        setTimeline(new Timeline(new KeyFrame(javafx.util.Duration.millis(SPEED_ATTACK), e -> {
            Sun sun = new Sun((int)this.getX() - 5,(int)this.getY() + 30, this.getRow(), timelineList);
            sun.flowerCreateSun();
        })));
        getTimeline().setCycleCount(Timeline.INDEFINITE);
        getTimeline().play();
    }
    
}
