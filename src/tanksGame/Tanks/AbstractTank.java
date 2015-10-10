package tanksGame.Tanks;

//import lessons.Frame35.Bullet;
//import lessons.Frame36.BattleField;
//import lessons.Frame39.ActionField;

import tanksGame.ActionField;
import tanksGame.Drawable;
import tanksGame.battleField.BattleField;
import tanksGame.battleField.Bullet;
import tanksGame.Direction;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by IVG on 13.06.15.
 */
public abstract class AbstractTank implements Drawable, Runnable{
    protected int speed;
    private int x;
    private int y;
    private Direction direction;
    private ActionField actionField;
    private BattleField battleField;

    protected Color tankColor;
    protected Color towerColor;
    protected Image image;

    public AbstractTank(ActionField af, BattleField bf) {

        this(af,bf,0,0, Direction.UP);
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

    public BattleField getBattleField() {
        return battleField;
    }

    public ActionField getActionField() {
        return actionField;
    }

    public void turn(Direction direction) throws Exception {
        this.direction = direction;
//        actionField.processTurn(this);
    }

    @Override
    public abstract void run();

    public void move() throws Exception {
//        fire();
        actionField.processMove(this);
    }
    public void fire() throws Exception {
        Bullet bullet = new Bullet(x+25,y+25, direction);
        bullet.setOwner(this);
        actionField.processFire(bullet);
    }

    public void moveToQuadrant(int v, int h) throws Exception {

        String coordinates = actionField.getQuadrantXY(v, h);
        int separator = coordinates.indexOf("_");
        int y = Integer.parseInt(coordinates.substring(0, separator));
        int x = Integer.parseInt(coordinates.substring(separator + 1));

        while (this.x != x || this.y != y) {

            changeDirection(x, y);

//            clearPass();

            move();
        }

    }

    public void changeDirection(int x, int y) throws Exception {

//        direction = (this.x < x) ? Direction.RIGHT : Direction.LEFT;
//        direction = (this.y < y) ? Direction.DOWN : Direction.UP;

        if (this.x < x) {
            direction = Direction.RIGHT;
        } else if (this.x > x) {
            direction = Direction.LEFT;
        } else if (this.y < y) {
            direction = Direction.DOWN;
        } else if (this.y > y) {
            direction = Direction.UP;
        }

        System.out.println("Direction = " + direction);
    }

    public void moveRandom() throws Exception {

    }

    public void clearPass() throws Exception {

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

    public int getRandomV() {
        return getRandomPosition()*64-64;
    }

    public int getRandomH() {
        return 1*64-64;
    }

    private int getRandomPosition() {

        int posArr[] = {1, battleField.getDimentionX() / 2, battleField.getDimentionX()};
        Random random = new Random();

        return posArr[random.nextInt(3)];
    }

    public boolean isAlive() {
        return x > 0;
    }

    public void draw(Graphics g) {
//        g.setColor(tankColor);
//        g.fillRect(this.getX(), this.getY(), 64, 64);
//
//        g.setColor(towerColor);
//        if (this.getDirection() == Direction.UP) {
//            g.fillRect(this.getX() + 20, this.getY(), 24, 34);
//        } else if (this.getDirection() == Direction.DOWN) {
//            g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
//        } else if (this.getDirection() == Direction.LEFT) {
//            g.fillRect(this.getX(), this.getY() + 20, 34, 24);
//        } else {
//            g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
//        }
//        Graphics2D graphics2D = (Graphics2D) g;
//        Composite orig = graphics2D.getComposite();
//        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        g.drawImage(image, x, y, 64, 64, Color.BLACK, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
//        graphics2D.setComposite(orig);

    }
}
