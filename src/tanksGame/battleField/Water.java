package tanksGame.battleField;

import tanksGame.Drawable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by IVG on 03.07.15.
 */
public class Water extends AbstractFieldObject implements Drawable {

    private final String IMAGE_FILE = "water.jpg";

    public Water() {
        color = Color.blue;
        try {
            image = ImageIO.read(new File(IMAGE_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        Composite orig = graphics2D.getComposite();
//        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g.drawImage(image, x, y, 64, 64, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
//        graphics2D.setComposite(orig);
    }
}
