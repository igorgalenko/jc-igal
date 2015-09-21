package tanksGame.battleField;

import tanksGame.Destroyable;
import tanksGame.Drawable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by IVG on 03.07.15.
 */
public class Brick extends AbstractFieldObject implements Destroyable, Drawable{

    private final String IMAGE_FILE = "Brick.jpg";

    public Brick() {
        color = Color.RED;
        try {
            image = ImageIO.read(new File(IMAGE_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
