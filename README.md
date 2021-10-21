# U21 | Image Processing - Bild spiegeln und weichzeichnen

Bildverarbeitung ist ein wichtiges Thema im Design und der
Computergraphik. Um zu verstehen, wie Programme wie zum Beispiel
Photoshop oder Gimp mit Pixelmanipulation komplette Bilder verändern,
sollen Sie in dieser Aufgabe ein Programm implementieren, dass ein Bild horizontal spiegelt.

Schreiben Sie dazu eine Methode ` flipImageHorizontal``(Image img) `, welche
aus einem Image-Objekt die Pixel-Daten ausliest und anschließend so
umdreht, dass das Bild horizontal gespiegelt und dann als neues
Image-Objekt zurückgegeben wird.

![Sopranos](docs/09_sopranos.png){ width=50% }

Gegeben ist folgender Rumpf:

```
    public class ImageProcessing extends GraphicsApp {

        private Image sourceImage;
        private Image workingCopy;

        public void intialize() {
            setupCanvas();
            setupImages();
        }

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
            // image flipping code here
            return img;
        }

        public void onKeyPressed(KeyPressedEvent event) {
            workingCopy = flipImageHorizontal(workingCopy);
            workingCopy.draw();
        }
    }
```

**Erweiterung:** Implementieren Sie die Methode
` flipImageVertical``(Image img) `, mit deren Hilfe das Bild vertikal
gespiegelt wird.
