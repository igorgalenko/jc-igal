package tanksGame.battleField;

import tanksGame.Destroyable;
import tanksGame.Direction;
import tanksGame.Drawable;
import tanksGame.Launcher;
import tanksGame.Tanks.AbstractTank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by Venom on 12.06.15.
 */

public class Bullet implements Drawable, Destroyable {

    private int speed;
    private int x;
    private int y;
    private Direction direction;
    private AbstractTank owner;
    private final String IMAGE_FILE = Launcher.resPath+"bullet.png";
    private Image image;

    public Bullet() {
        this(-100, -100, Direction.UP);
    }

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        speed = 10;
        try {
            image = ImageIO.read(new File(IMAGE_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getSpeed() {
        return speed;
    }

    public void setOwner(AbstractTank owner) {
        this.owner = owner;
    }

    public AbstractTank getOwner() {
        return owner;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void updateX(int x) {
        this.x = x;
    }

    public void updateY(int y) {
        this.y = y;
    }

    public void destroy() {
        x = -100;
        y = -100;
    }

    @Override
    public void draw(Graphics g) {
//        g.setColor(new Color(255, 255, 0));
//        g.fillRect(getX(), getY(), 14, 14);

        g.drawImage(image, x, y, 16, 16, Color.BLACK, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
