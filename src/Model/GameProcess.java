//package src.Model;
//
//public class GameProcess {
//    // Variables
//    private GameData gameData = null;
//    private CardPlants cardPlants = null;
//    private Timeline timelineGame = null;
//    // Constructor
//    public GameProcess(GameData gameData) {
//        this.gameData = gameData;
//        cardPlants = new CardPlants(gameData.getListCardPlant());
//    }
//
//    // Start Game
//    public void startGame() {
//
//        // Phục hồi dữ liệu cũ (Nếu có)
//        // Tạo ảnh cây gắn hành động đang tồn tại
//        for (int i = 0; i < gameData.getListPlant().size(); i++) {
//            Plant plant = gameData.getListPlant().get(i);
//            plant.createImageViewInGridPane();
//
//            plant.startAnimation();
//        }
//        // Tạo ảnh zombie gắn hành động Zombie đang tồn tại sẵn trong game
//        for (int i = 0; i < gameData.getZombieAlive().size(); i++) {
//            Zombie zombie = gameData.getZombieAlive().get(i);
//            zombie.createImageView();
//
//            zombie.startAnimation();
//        }
//
//
//        // Tạp card
//        cardPlants.getCards();
//
//
//        // Chạy Timeline Game
//        timelineGame = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
//            gameData.setTick(gameData.getTick() + 1);
////            // Xử lí tạo ra dropsun sau một khoảng thời gian
////            if (durationDropSun == 0) {
////                dropSun.CreatSunDrop();
////                durationDropSun = dropSun.getDurationDropSun();
////            }
////            else {
////                durationDropSun--;
////            }
//            // Xử lí tạo ra zombie
//            while ((gameData.getZombieSpawner()).size() > 0 && (gameData.getZombieSpawner()).get(0).getTime() == gameData.getTick()) {
//                ZombieSpawner zombieSpawner = (gameData.getZombieSpawner()).get(0);
//
//                Zombie zombie = zombieSpawner.getZombie();
//
//                zombie.createImageView();
//
//                zombie.startAnimation();
//                (gameData.getZombieAlive()).add(zombie);
//                (gameData.getZombieSpawner()).remove(0);
//            }
//            // Kiểm tra trạng thái game và cập nhập phần trăm game
//            // TODO: Thêm các trạng thái game và timneline game
//
//        }));
//        timelineGame.setCycleCount(Timeline.INDEFINITE);
//        timelineGame.play();
//    }
//    // Pause Game
//    public void pauseGame() {
//        // Pause Timeline main game
//        timelineGame.pause();
//        // Pause Timeline của các zombie
//        for (int i = 0; i < gameData.getZombieAlive().size(); i++) {
//            gameData.getZombieAlive().get(i).stopAnimation();
//        }
//        // Pause Timeline của các cây
//        for (int i = 0; i < gameData.getListPlant().size(); i++) {
//            gameData.getListPlant().get(i).stopAnimation();
//        }
//    }
//    // Load Game
//    public void loadGame() {
//        // TODO Load Game
//    }
//    // Save Game
//    public void saveGame() {
//        // TODO Save Game
//    }
//
//    // Getters and Setters
//}