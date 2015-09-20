package tanksGame.Tanks;

//import lessons.Frame35.Bullet;
//import lessons.Frame36.BattleField;
//import lessons.Frame39.ActionField;

import tanksGame.ActionField;
import tanksGame.battleField.BattleField;
import tanksGame.Bullet;
import tanksGame.Direction;

import java.awt.*;

/**
 * Created by IVG on 13.06.15.
 */
public abstract class AbstractTank {
    protected int speed;
    private int x;
    private int y;
    private Direction direction;
    private ActionField actionField;
    private BattleField battleField;

    protected Color tankColor;
    protected Color towerColor;

    public AbstractTank(ActionField af, BattleField bf) {

        this(af,bf,64*4,8*64, Direction.UP);
        speed = 10;

    }

    public AbstractTank(ActionField af, BattleField bf, int x, int y, Direction direction) {

        actionField = af;
        battleField = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
        speed = 10;


    }

    public void turn(Direction direction) throws Exception {
        this.direction = direction;
        actionField.processTurn(this);
    }
    public void move() throws Exception {
        actionField.processMove(this);
    }
    public void fire() throws Exception {
        Bullet bullet = new Bullet(x+25,y+25, direction);
        actionField.processFire(bullet);
    }

    public void moveToQuadrant(int v, int h) throws Exception {
        String coordinates = actionField.getQuadrantXY(v, h);
        int separator = coordinates.indexOf("_");
        int y = Integer.parseInt(coordinates.substring(0, separator));
        int x = Integer.parseInt(coordinates.substring(separator + 1));

        if (this.x < x) {
            while (this.x != x) {
                direction = Direction.RIGHT;
                move();
            }
        } else {
            while (this.x != x) {
                direction = Direction.LEFT;
                move();
            }
        }

        if (this.y < y) {
            while (this.y != y) {
                direction = Direction.DOWN;
                move();
            }
        } else {
            while (this.y != y) {
                direction = Direction.UP;
                move();
            }
        }

    }

    public void moveRandom() throws Exception {

    }

    public void clean() throws Exception {

    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
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

    public boolean destroy() {
        x = -100;
        y = -100;
        return true;
    }

    public int getRandomX() {
        return random()*64-64;
    }

    public int getRandomY() {
        return 1*64-64;
    }

    private int random() {
        Long millis = System.currentTimeMillis();
        int r = Integer.valueOf(millis.toString().substring(12))/3;
        if (r == 2) {
            r = 5;
        } else if (r==3) {
            r = 9;
        } else {r=1;}
        return r;
    }

    public void draw(Graphics g) {
        g.setColor(tankColor);
        g.fillRect(this.getX(), this.getY(), 64, 64);

        g.setColor(towerColor);
        if (this.getDirection() == Direction.UP) {
            g.fillRect(this.getX() + 20, this.getY(), 24, 34);
        } else if (this.getDirection() == Direction.DOWN) {
            g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
        } else if (this.getDirection() == Direction.LEFT) {
            g.fillRect(this.getX(), this.getY() + 20, 34, 24);
        } else {
            g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
        }

    }
}
