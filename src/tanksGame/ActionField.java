package tanksGame;

import tanksGame.Tanks.AbstractTank;
import tanksGame.Tanks.T34;
import tanksGame.Tanks.Tiger;
import tanksGame.battleField.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IVG on 12.06.15.
 */
public class ActionField extends JPanel{
    private final boolean COLORDED_MODE = false;
    private BattleField battleField;
    private AbstractTank defender;
    private AbstractTank agressor;
    private Map<String, AbstractFieldObject> fieldObjects;
    private Bullet bullet;

    public ActionField() throws Exception{

        battleField = new BattleField();
        bullet = new Bullet();
        fieldObjects = new HashMap<String, AbstractFieldObject>();
        fieldObjects.put("W", new Water());
        fieldObjects.put("R", new Rock());
        fieldObjects.put("B", new Brick());
        fieldObjects.put("E", new Eagle());
        fieldObjects.put(" ", new Road());
        fieldObjects.put("", new Road());

        defender = new T34(this,battleField);

//        agressor = new BT7(this,battleField, defender.getRandomX(), defender.getRandomY(), Direction.DOWN);
        agressor = new Tiger(this,battleField,0,0,Direction.DOWN);

        setBackground(Color.BLACK);
        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH(), battleField.getBF_HEIGHT() + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        setFocusable(true);
//        requestFocus();
        requestFocusInWindow();
        KeyboardListener keyListener = new KeyboardListener();
        keyListener.setTank(defender);
        addKeyListener(keyListener);

        Redraw fps = new Redraw();
        fps.setPanel(this);
        new Thread(fps).start();

    }

    public AbstractTank getDefender() {
        return defender;
    }

    public AbstractTank getAgressor() {
        return agressor;
    }

    public void runTheGame() throws Exception {

        new Thread(agressor).start();
        new Thread(defender).start();

    }

    boolean processInterception() {

        String YX = getQuadrant(bullet.getX(), bullet.getY());
        int idx = YX.indexOf("_");
        int y = Integer.parseInt(YX.substring(0, idx));
        int x = Integer.parseInt(YX.substring(idx+1));

        if (y >= 0 && y < 9 && x >= 0 && x < 9) {

            if (fieldObjects.get(battleField.scanQuadrant(y, x)) instanceof Destroyable) {

                battleField.updateQuadrant(y, x, " ");
                return true;
            }

            if (!defender.equals(bullet.getOwner())) {
                if ((bullet.getX() / 64 == defender.getX() / 64) && (bullet.getY() / 64 == defender.getY() / 64)) {
                    defender.destroy();
                    return true;
                }
            }

            if (!agressor.equals(bullet.getOwner())) {
                if ((bullet.getX() / 64 == agressor.getX() / 64) && (bullet.getY() / 64 == agressor.getY() / 64)) {
                    agressor.destroy();
                    return true;
                }
            }
        }
        return false;
    }

    public String getQuadrantXY(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    String getQuadrant(int x, int y) {
        return y/64+"_"+x/64;
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        AbstractFieldObject fieldObject = null;

        for (int j = 0; j < battleField.getDimentionY(); j++) {
            for (int k = 0; k < battleField.getDimentionX(); k++) {
                String coordinates = getQuadrantXY(j + 1, k + 1);
                int separator = coordinates.indexOf("_");
                int y = Integer.parseInt(coordinates.substring(0, separator));
                int x = Integer.parseInt(coordinates.substring(separator + 1));
                fieldObject = fieldObjects.get(battleField.scanQuadrant(j,k));


                fieldObject.setX(x);
                fieldObject.setY(y);
                if (fieldObject instanceof Drawable) {
                    fieldObject.draw(g);
                }
            }
        }

        defender.draw(g);
        agressor.draw(g);
        bullet.draw(g);
    }

    public void processTurn(AbstractTank tank) {
        System.out.println("ActionField.processTurn");
    }

    public void processMove(AbstractTank tank) throws Exception {
        int step = 1;
        int covered = 0;
        Direction direction = tank.getDirection();

        // check limits x: 0, 513; y: 0, 513
        if ((direction == Direction.UP && tank.getY() == 0) || (direction == Direction.DOWN && tank.getY() >= 512)
                || (direction == Direction.LEFT && tank.getX() == 0) || (direction == Direction.RIGHT && tank.getX() >= 512)) {
            System.out.println("[illegal move] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            return;
        }

//        processTurn(tank);

        String YX = getQuadrant(tank.getX(), tank.getY());
        int idx = YX.indexOf("_");
        int y = Integer.parseInt(YX.substring(0, idx));
        int x = Integer.parseInt(YX.substring(idx+1));

        while (covered < 64) {
            if (direction == Direction.UP) {
                if (fieldObjects.get(battleField.scanQuadrant(y-1,x)) instanceof Destroyable) {
//                    processFire(bullet);
                }
                tank.updateY(-step);
//				System.out.println("[move up] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            } else if (direction == Direction.DOWN) {
                if (fieldObjects.get(battleField.scanQuadrant(y+1,x)) instanceof Destroyable) {
//                    processFire(bullet);
                }
                tank.updateY(step);
//				System.out.println("[move down] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            } else if (direction == Direction.LEFT) {
                if (fieldObjects.get(battleField.scanQuadrant(y, x - 1)) instanceof Destroyable) {
//                    processFire(bullet);
                }

                tank.updateX(-step);
//				System.out.println("[move left] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            } else {
                if (fieldObjects.get(battleField.scanQuadrant(y, x + 1)) instanceof Destroyable) {
//                    processFire(bullet);
                }
                tank.updateX(step);
//				System.out.println("[move right] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            }
            covered += step;

//            repaint();
            Thread.sleep(tank.getSpeed());
        }

    }

    public void processFire(Bullet bullet) throws Exception  {
        this.bullet = bullet;

        while (true) {

            if (bullet.getY() < -25 || bullet.getY() >= 576) {
                break;
            }
            if (bullet.getX() <= 0 || bullet.getX() >= 576) {
                break;
            }

            if (bullet.getDirection() == Direction.UP) {
                bullet.updateY(bullet.getY() - bullet.getSpeed());
            } else if (bullet.getDirection() == Direction.DOWN) {
                bullet.updateY(bullet.getY()+bullet.getSpeed());
            } else if (bullet.getDirection() == Direction.LEFT) {
                bullet.updateX(bullet.getX()-bullet.getSpeed());
            } else {
                bullet.updateX(bullet.getX()+bullet.getSpeed());
            }

            if(processInterception()) {
                bullet.destroy();
            }

//            repaint();
            Thread.sleep(50);
        }

    }

    public void showResult() {

    }
}
