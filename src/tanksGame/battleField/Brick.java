package tanksGame.battleField;

import tanksGame.Destroyable;
import tanksGame.Drawable;

import java.awt.*;

/**
 * Created by IVG on 03.07.15.
 */
public class Brick extends AbstractFieldObject implements Destroyable, Drawable{

    public Brick() {
        color = Color.RED;
    }

    @Override
    public void destroy() {

    }

}
