package tanksGame.battleField;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by IVG on 03.07.15.
 */
public class AbstractFieldObject{

    protected Color color;
    protected int armor;
    protected  int x, y;
    protected Image image;
    private BattleField battleField;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics g) {

        g.drawImage(image, x, y, 64, 64, Color.BLACK, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

//    public void destroy() {
//        battleField[y][x] = "";
//    }
}
