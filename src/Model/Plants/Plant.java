package src.Model.Plants;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import src.Controller.GameMainController;
import src.Model.Act;
import src.Model.GameElements;
import src.Model.Plants.CherryBomb.CherryBomb;
import src.Model.Plants.Chomper.Chomper;
import src.Model.Plants.Pea.PeaShooter.PeaShooter;
import src.Model.Plants.Pea.Repeater.Repeater;
import src.Model.Plants.PotanoMine.PotatoMine;
import src.Model.Plants.Sun.SunFlower;
import src.Model.Plants.Wallnut.Wallnut;
import src.Model.StageCharacter;
import src.Utils.HandleInGridPane;

public class Plant extends GameElements {
    // Variables
    private int col = 0, row = 0;
    private int hp = 0;
    private int dame = 0;
    private int cost = 0;
    private int speedAttack = 0;
    private Timeline timeline = null;
    //
    private Act act = null;
    private StageCharacter stageCharacter = null;
    private HandleInGridPane handleInGridPane = null;
    // Constructor
    public Plant() {
        super();
    }
    public Plant(double x, double y, String path, int width, int height, // lane == row
                 int hp, int col, int row, int cost, int speedAttack, int dame) {

        super(x, y, path, width, height, row);

        this.hp = hp;
        this.col = col;
        this.row = row;
        this.cost = cost;
        this.speedAttack = speedAttack;
        this.dame = dame;
        handleInGridPane = new HandleInGridPane(this);
    }

    // Start tấn công
    public void start() {
        // Tạo timeline tấn công và chạy
    }
    // Stop
    public void stop() {
        if (timeline != null) {
            timeline.stop();
        }
    }
    // Pause tấn công
    public void pause() {
        if (timeline != null) {
            timeline.pause();
        }
    }

    // Resume tấn công
    public void resume() {
        if (timeline != null) {
            timeline.play();
        }
    }
    // Tao anh cay tren GridPane
    public void createImageViewInGridPane() {
        handleInGridPane.createImageViewInGridPane();
    }

    // Xoa anh cay tren GridPane
    public void removeImageViewInGridPane() {
        handleInGridPane.removeImageViewInGridPane();
    }

    // Get và set các thuộc tính
    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getDame() {
        return dame;
    }

    public void setDame(int dame) {
        this.dame = dame;
    }

    public int getSpeedAttack() {
        return speedAttack;
    }

    public void setSpeedAttack(int speedAttack) {
        this.speedAttack = speedAttack;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public StageCharacter getStageCharacter() {
        return stageCharacter;
    }

    public void setStageCharacter(StageCharacter stageCharacter) {
        this.stageCharacter = stageCharacter;
    }
}
