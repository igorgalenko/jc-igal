package tanksGame.battleField;

import tanksGame.Destroyable;
import tanksGame.Drawable;
import tanksGame.Launcher;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by IVG on 03.07.15.
 */
public class Eagle extends AbstractFieldObject implements Drawable, Destroyable{

    private String IMAGE_FILE = Launcher.resPath+"Flag.png";

    public Eagle() {
        color = Color.YELLOW;
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
