package psta.missilecommand;

import psta.opticsandsound.GameView;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Class menue for showing the menue and choosing the gameMode at the beginning of the game
 */
public class Menu {
    private final GameView gameView;
    private long lastTime;
    private boolean godMode;

    /**
     * Constructor of the class menue
     *
     * @param gameView handed object gameView for creating graphical and audio output
     */
    Menu(GameView gameView) {
        this.gameView = gameView;
    }

    /**
     * This method starts the menue and requires player input for choosing the level (by mouseclick on one of both fields)
     */
    public void startMenue() {

        gameView.playSound("waitingSound.wav", true);

        while (true) {
            long now = System.currentTimeMillis();
            long timePassed = now - lastTime;
            if (timePassed > 1000) {

                gameView.addTextToCanvas("Choose Gamemode", 140, 100, 50, Color.BLUE);
                if (timePassed > 2000) {
                    lastTime = now;
                }
            }

            gameView.addTextToCanvas("Normal", 360, 220, 40, Color.RED);
            gameView.addTextToCanvas("Godmode", 360, 290, 40, Color.RED);
            gameView.addRectangleToCanvas(340, 215, 300, 60, 5, false, Color.YELLOW);
            gameView.addRectangleToCanvas(340, 285, 300, 60, 5, false, Color.YELLOW);
            gameView.addTextToCanvas("INSTRUCTIONS:", 380, 410, 20, Color.BLUE);
            gameView.addTextToCanvas("Destroy the incoming enemy missiles ", 110, 440, 20, Color.BLUE);
            gameView.addTextToCanvas("with defend missiles by mouseclick", 110, 470, 20, Color.BLUE);
            gameView.printCanvas();

            Thread.onSpinWait();

            MouseEvent[] mouseEvents = gameView.pollMouseEvents();
            for (MouseEvent mouseEvent : mouseEvents) {
                if (mouseEvent.getID() == MouseEvent.MOUSE_CLICKED) {
                    if (mouseEvent.getX() > 340 && mouseEvent.getX() < 640 && mouseEvent.getY() > 220 && mouseEvent.getY() < 280) {
                        godMode = false;
                        gameView.stopAllSounds();
                        return;

                    }
                    if (mouseEvent.getID() == MouseEvent.MOUSE_CLICKED) {
                        if (mouseEvent.getX() > 340 && mouseEvent.getX() < 640 && mouseEvent.getY() > 290 && mouseEvent.getY() < 350) {
                            godMode = true;
                            gameView.stopAllSounds();
                            return;

                        }
                    }
                }
            }
        }
    }

    public boolean getGodMode() {
        return godMode;
    }
}
