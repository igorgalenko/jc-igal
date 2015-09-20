package tanksGame;

import java.awt.*;

/**
 * Created by Venom on 12.06.15.
 */

public class Bullet implements Drawable, Destroyable {

    private int speed;
    private int x;
    private int y;
    private Direction direction;

    public Bullet() {
        speed = 10;
        x = -100;
        y = -100;
    }

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        speed = 10;

    }

    public int getSpeed() {
        return speed;
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
        g.setColor(new Color(255, 255, 0));
        g.fillRect(getX(), getY(), 14, 14);

    }
}
