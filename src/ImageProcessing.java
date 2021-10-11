package ImageProcessing;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.graphics.Image;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class ImageProcessing extends GraphicsApp {

    /* Private Konstanten */
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final int FRAME_RATE = 60;
    private static final Color BACKGROUND_COLOR = Colors.WHITE;

    private Image sourceImage;
    private Image workingCopy;

    /*
     * Die initialize-Methode wird einmalig zum Start des Programms
     * aufgerufen.
     */

    @Override
    public void initialize() {
        setupCanvas();
        setupImages();
    }

    /*
     * Die draw-Methode wird so lange wiederholt aufgerufen, bis das Programm
     * beendet wird.
     */
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
        workingCopy.draw();
    }

    private void setupCanvas() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        setFrameRate(FRAME_RATE);
    }

    private void setupImages() {
        sourceImage = new Image(0, 0, "data/assets/sopranos.jpg");
        workingCopy = new Image(0, 0, "data/assets/sopranos.jpg");
    }

    private Image flipImageHorizontal(Image img) {
        int[][] pixels = img.getPixelArray();

        int numLineTotal = pixels.length;
        for (int lineNum = 0; lineNum < numLineTotal; lineNum++) {
            int[] flippedLine = flipLine(pixels[lineNum]);
            pixels[lineNum] = flippedLine;
        }
        img.setPixelArray(pixels);
        return img;
    }

    private int[] flipLine(int[] imageLine) {
        int[] flippedLine = new int[imageLine.length];
        for (int i = 0; i < imageLine.length; i++) {
            flippedLine[imageLine.length - 1 - i] = imageLine[i];
        }
        return flippedLine;
    }

    public void onKeyPressed(KeyPressedEvent event) {
        workingCopy = flipImageHorizontal(workingCopy);
        workingCopy.draw();
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}