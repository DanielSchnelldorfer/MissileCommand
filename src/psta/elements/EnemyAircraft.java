package psta.elements;

import psta.controllers.GameController;
import psta.opticsandsound.OpticalElements;
import psta.opticsandsound.GameView;

/**
 * Class for creating new enemy aircrafts
 */
public class EnemyAircraft {
    protected enum EnemyAircraftStatus {INTACT, DESTROYED}

    protected EnemyAircraft.EnemyAircraftStatus enemyAircraftStatus;
    GameController gameHandler;
    GameView gameView;
    OpticalElements opticalElements;
    private int startX;
    private int startY;
    private int targetX;
    private int targetY;
    private final int velocity;
    private String startSide;
    private long lastTime;
    private final int turbo;
    private int currentX;
    private int currentY;

    /**
     * Constructor for creating new enemy aircraft objects
     *
     * @param gameView        object for graphical output
     * @param gameHandler     object for managing all game elements
     * @param opticalElements object for getting graphical elements
     */
    public EnemyAircraft(GameView gameView, GameController gameHandler, OpticalElements opticalElements) {
        this.gameView = gameView;
        this.gameHandler = gameHandler;
        this.opticalElements = opticalElements;
        enemyAircraftStatus = EnemyAircraftStatus.INTACT;
        turbo = 2;
        velocity = 30;
        chooseStartSide();
        setFlyingRoute();

    }

    /**
     * method for updating enemy aircrafts
     * depending on the start side this method calculates the next movements of the object, draws the object and removes the object
     * when it reaches its target
     */
    public void updateEnemyAircraft() {
        long now = System.currentTimeMillis();
        long timePassed = now - lastTime;

        if (startSide.equals("left")) {
            if (timePassed > velocity) {

                if (currentX < targetX && enemyAircraftStatus == EnemyAircraftStatus.INTACT) {
                    currentX = currentX + turbo;
                    lastTime = now;
                }
                if (currentX >= targetX) {
                    enemyAircraftStatus = EnemyAircraftStatus.DESTROYED;
                    clearEnemyAircraft();
                }

            }

        }
        if (startSide.equals("right")) {
            if (timePassed > velocity) {

                if (currentX > targetX && enemyAircraftStatus == EnemyAircraftStatus.INTACT) {
                    currentX = currentX - turbo;
                    lastTime = now;
                }
                if (currentX <= targetX) {
                    enemyAircraftStatus = EnemyAircraftStatus.DESTROYED;
                    clearEnemyAircraft();
                }

            }

        }
        drawEnemyAircraft();
    }

    /**
     * method draws the enemy aircraft object depending on its start side
     */
    public void drawEnemyAircraft() {
        if (startSide.equals("left")) {
            gameView.addImageToCanvas(opticalElements.getEnemyAircraft(), currentX, currentY, 2);
        }
        if (startSide.equals("right")) {

            StringBuilder aircraftString = new StringBuilder();
            for (String i : opticalElements.getEnemyAircraft().split("\n")) {
                aircraftString.append(i).append("\n");
            }
            String reverseEnemyAircraft = aircraftString.reverse().toString();
            gameView.addImageToCanvas(reverseEnemyAircraft, currentX, currentY, 2);

        }

    }

    /**
     * method removes the enemy aircraft object from the game
     */
    public void clearEnemyAircraft() {
        gameHandler.enemyAircraftList.remove(this);
    }

    /**
     * method randomly chooses starting side of the enemy aircraft object (50% each)
     */
    public void chooseStartSide() {
        double randomNumber = Math.random();
        if (randomNumber <= 0.5) {
            startSide = "left";
        } else {
            startSide = "right";
        }
    }

    /**
     * method sets the flying route and the target coordinates for the enemy aircraft
     * depending on the start side
     */
    public void setFlyingRoute() {
        if (startSide.equals("left")) {
            startX = (int) (Math.random() * (900 - 300 + 1) + 300) * -1;
            startY = (int) (Math.random() * (350 - 70 + 1) + 70);
            targetX = 1000;
        }
        if (startSide.equals("right")) {
            startX = (int) (Math.random() * (2000 - 1200 + 1) + 1200);
            startY = (int) (Math.random() * (350 - 70 + 1) + 70);
            targetX = 0;
        }
        targetY = startY;
        currentY = targetY;
        currentX = startX;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

}

