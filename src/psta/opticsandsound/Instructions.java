package psta.opticsandsound;

import java.awt.*;
import java.util.HashMap;

/**
 * Class showing the key game instructions to the player for 10 seconds at the beginning of every level.
 */
public class Instructions {
    private final GameView gameView;
    private final OpticalElements opticalElements;
    private long lastTime;
    private final long measureTime;

    /**
     * Constructor of the class.
     *
     * @param gameView        object for showing graphical output
     * @param opticalElements object for getting required strings for the output
     */
    public Instructions(GameView gameView, OpticalElements opticalElements) {
        this.gameView = gameView;
        this.opticalElements = opticalElements;
        measureTime = System.currentTimeMillis();
    }

    /**
     * Method for showing instructions to the player for 10 seconds at the beginning of every game level.
     */
    public void showInstructions() {
        long measureTimeNew = System.currentTimeMillis();
        if (measureTimeNew < measureTime + 10000) {

            long now = System.currentTimeMillis();
            long timePassed = now - lastTime;
            if (timePassed > 1000) {


                gameView.addImageToCanvas(opticalElements.getRedArrows(), 165, 450, 2);
                gameView.addImageToCanvas(opticalElements.getRedArrows(), 245, 450, 2);
                gameView.addImageToCanvas(opticalElements.getRedArrows(), 325, 450, 2);
                gameView.addImageToCanvas(opticalElements.getRedArrows(), 505, 450, 2);
                gameView.addImageToCanvas(opticalElements.getRedArrows(), 605, 450, 2);
                gameView.addImageToCanvas(opticalElements.getRedArrows(), 695, 450, 2);
                if (timePassed > 2000) {
                    lastTime = now;
                }
            }

            HashMap<Character, Color> colormap = gameView.getColormap();
            colormap.put('b', new Color(0, 204, 255));
            gameView.setColormap(colormap);
            gameView.addTextToCanvas("DEFEND   CITIES", 150, 400, 40, Color.BLUE);

        }

    }


}
