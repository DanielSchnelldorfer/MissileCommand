package psta.elements;

import psta.opticsandsound.GameView;
import psta.opticsandsound.OpticalElements;

/**
 * Class for creating and drawing stationed defend missiles
 */
public class StationedDefendMissile {
    private final GameView gameView;
    private final OpticalElements opticalElements;
    private final int positionX;
    private final int positionY;

    /**
     * Constructor of class
     *
     * @param gameView        object for graphical output
     * @param opticalElements delivering strings for graphical output
     * @param positionX       x coordinate of the stationed missile
     * @param positionY       y coordinate of the stationed missile
     */
    public StationedDefendMissile(GameView gameView, OpticalElements opticalElements, int positionX, int positionY) {
        this.gameView = gameView;
        this.opticalElements = opticalElements;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * method for drawing a stationed defend missile
     */
    public void printStationedDefendMissile() {
        gameView.addImageToCanvas(opticalElements.getMissile(), positionX, positionY, 1);
    }


}
