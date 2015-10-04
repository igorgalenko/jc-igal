package tanksGame.battleField;

import tanksGame.Drawable;
import tanksGame.Launcher;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by IVG on 03.07.15.
 */
public class Rock extends AbstractFieldObject implements Drawable {

    private final String IMAGE_FILE = Launcher.resPath+"rock.jpg";


    public Rock() {
        color = Color.GRAY;
        armor = 1;
        try {
            image = ImageIO.read(new File(IMAGE_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
