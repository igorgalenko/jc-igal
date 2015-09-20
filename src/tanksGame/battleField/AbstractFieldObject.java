package tanksGame.battleField;

import java.awt.*;

/**
 * Created by IVG on 03.07.15.
 */
public abstract class AbstractFieldObject{

    protected Color color;

    protected  int x, y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 64, 64);

    }

}
