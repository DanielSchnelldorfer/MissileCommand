package psta.opticsandsound;

import psta.controllers.GameController;
import psta.missilecommand.MissileCommandMain;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Class for showing the game stats after very level, including 10 bonus points for every stationed defense missile that is left
 * plus 100 bonus points for every city that survived until the end.
 */
public class GameStats {

    private final GameView gameView;
    private final GameController gameController;
    private final OpticalElements opticalElements;
    private final MissileCommandMain missileCommandMain;
    private long lastTime;
    private int missilesLeft;

    /**
     * Constructor of the class.
     *
     * @param gameView        object for graphical output
     * @param gameController  object for managing all game elements
     * @param opticalElements object containing graphical elements
     */
    public GameStats(GameView gameView, GameController gameController, OpticalElements opticalElements, MissileCommandMain missileCommandMain) {
        this.gameView = gameView;
        this.gameController = gameController;
        this.opticalElements = opticalElements;
        this.missileCommandMain = missileCommandMain;

    }

    /**
     * Method showing the game stats after every game level and playing waiting screen sound.
     */
    public void showStats() {

        gameView.printCanvas();
        gameView.playSound("waitingSound.wav", true);

        while (true) {

            long now = System.currentTimeMillis();
            long timePassed = now - lastTime;

            gameView.addImageToCanvas(opticalElements.getMountains(), 0, 490, 4);
            gameView.addRectangleToCanvas(340, 100, 300, 60, 5, false, Color.YELLOW);
            gameView.addImageToCanvas(opticalElements.getCity(), 490, 330, 2);
            gameView.addImageToCanvas(opticalElements.getMissile(), 500, 385, 2);
            gameView.addTextToCanvas(String.valueOf(100 * gameController.citiesList.size()), 390, 330, 30, Color.RED);
            gameView.addTextToCanvas(String.valueOf(10 * (calculateMissilesLeft())), 390, 380, 30, Color.RED);


            if (gameController.getLevel() == 1 || gameController.getLevel() == 2) {
                gameView.addTextToCanvas("NEXT LEVEL", 360, 120, 25, Color.RED);
            }
            if (gameController.getLevel() == 3) {
                gameView.addRectangleToCanvas(340, 180, 300, 60, 5, false, Color.YELLOW);
                gameView.addTextToCanvas("END GAME", 380, 120, 25, Color.RED);
                gameView.addTextToCanvas("REPLAY", 400, 200, 25, Color.RED);    ////


            }
            if (timePassed > 1000) {

                gameView.addTextToCanvas("LEVEL " + gameController.getLevel() + " FINISHED", 180, 20, 40, Color.BLUE); //ergänzen auch mit timer
                gameView.addTextToCanvas("BONUS POINTS:", 340, 280, 25, Color.BLUE);
                if (timePassed > 2000) {
                    lastTime = now;
                }


            }
            gameView.printCanvas();
            Thread.onSpinWait();
            MouseEvent[] mouseEvents = gameView.pollMouseEvents();
            for (MouseEvent mouseEvent : mouseEvents) {
                if (mouseEvent.getID() == MouseEvent.MOUSE_CLICKED) {
                    if (mouseEvent.getX() > 340 && mouseEvent.getX() < 640 && mouseEvent.getY() > 100 && mouseEvent.getY() < 160) {
                        if (gameController.getLevel() == 1 || gameController.getLevel() == 2) {
                            gameView.stopAllSounds();
                            return;
                        }
                        if (gameController.getLevel() == 3)
                            missileCommandMain.setGameToStop();
                        gameView.closeGameView(true);
                    }
                    if (mouseEvent.getX() > 340 && mouseEvent.getX() < 640 && mouseEvent.getY() > 180 && mouseEvent.getY() < 240) {
                        if (gameController.getLevel() == 3) {
                            gameView.stopAllSounds();
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * Method for pausing the game for given amount of milliseconds.
     *
     * @param milliSeconds time in milliseconds for pausing the game
     */
    public void waitMilliSeconds(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method for calculating the amount of missiles that are left after the game.
     *
     * @return the amount of defend missiles left.
     */
    public int calculateMissilesLeft() {

        missilesLeft = (gameController.stationedDefendMissilesListB1.size() + gameController.stationedDefendMissilesListB2.size() + gameController.stationedDefendMissilesListB3.size());
        return missilesLeft;
    }
}

