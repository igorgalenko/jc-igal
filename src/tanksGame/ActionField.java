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
    private int gameMode;

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

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH(), battleField.getBF_HEIGHT() + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
        repaint();
    }

    public AbstractTank getDefender() {
        return defender;
    }

    public AbstractTank getAgressor() {
        return agressor;
    }

    public void runTheGame() throws Exception {


        agressor.destroyDefender(defender);
//        defender.fire();

//        battleField = new BattleField();
//        tank = new Tank(this, battleField);

//        tank.moveToQuadrant(5, 5);
//        tank.moveToQuadrant(2, 1);
//        tank.moveToQuadrant(7, 6);

//        for (int i = 0; i < battleField.getDimentionY(); i++) {
//            for (int j = 0; j < battleField.getDimentionX(); j++) {
//                if(!battleField.scanQuadrant(i,j).trim().isEmpty()) {
//                    tank.moveToQuadrant(i + 1, j + 1);
//                }
//            }
//            i++;
//            if(i>=battleField.getDimentionY()) {
//                break;
//            }
//            for (int j = battleField.getDimentionX()-1; j >= 0; j--) {
//                if(!battleField.scanQuadrant(i,j).trim().isEmpty()) {
//                    tank.moveToQuadrant(i+1, j+1);
//                }
//            }
//        }
    }

    boolean processInterception() {

        String YX = getQuadrant(bullet.getX(), bullet.getY());
        int idx = YX.indexOf("_");
        int y = Integer.parseInt(YX.substring(0, idx));
        int x = Integer.parseInt(YX.substring(idx+1));

        if (y >= 0 && y <= 9 && x >= 0 && x <= 9) {

            if (fieldObjects.get(battleField.scanQuadrant(y, x)) instanceof Destroyable) {
                battleField.updateQuadrant(y,x," ");
                return true;
            }

            if ((bullet.getX()/64 == defender.getX()/64) && (bullet.getY()/64 == defender.getY()/64)) {
                defender.destroy();
                return true;

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

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = Color.BLACK;//new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }


        for (int j = 0; j < battleField.getDimentionY(); j++) {
            for (int k = 0; k < battleField.getDimentionX(); k++) {
                String coordinates = getQuadrantXY(j + 1, k + 1);
                int separator = coordinates.indexOf("_");
                int y = Integer.parseInt(coordinates.substring(0, separator));
                int x = Integer.parseInt(coordinates.substring(separator + 1));
                fieldObject = fieldObjects.get(battleField.scanQuadrant(j,k));
//                if (battleField.scanQuadrant(j,k).equals("B")) {
//                    fieldObject = brick;
////                    g.setColor(new Color(0, 0, 255));
////                    g.fillRect(x, y, 64, 64);
//                } else if (battleField.scanQuadrant(j,k).equals("W")) {
////                    fieldObject = new Water();
//                } else if (battleField.scanQuadrant(j,k).equals("E")) {
////                    fieldObject = new Eagle();
//                } else if (battleField.scanQuadrant(j,k).equals("R")) {
////                    fieldObject = new Rock();
//                } else {
//                    fieldObject = road;
//                }

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
//        g.setColor(new Color(255, 0, 0));
//        g.fillRect(defender.getX(), defender.getY(), 64, 64);
//
//        g.setColor(new Color(0, 255, 0));
//        if (defender.getDirection() == Direction.UP) {
//            g.fillRect(defender.getX() + 20, defender.getY(), 24, 34);
//        } else if (defender.getDirection() == Direction.DOWN) {
//            g.fillRect(defender.getX() + 20, defender.getY() + 30, 24, 34);
//        } else if (defender.getDirection() == Direction.LEFT) {
//            g.fillRect(defender.getX(), defender.getY() + 20, 34, 24);
//        } else {
//            g.fillRect(defender.getX() + 30, defender.getY() + 20, 34, 24);
//        }

//        g.setColor(new Color(255, 255, 0));
//        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);

//        //agressor
//        g.setColor(new Color(0, 0, 0));
//        g.fillRect(agressor.getX(), agressor.getY(), 64, 64);
//
//        g.setColor(new Color(0, 255, 0));
//        if (agressor.getDirection() == Direction.UP) {
//            g.fillRect(agressor.getX() + 20, agressor.getY(), 24, 34);
//        } else if (agressor.getDirection() == Direction.DOWN) {
//            g.fillRect(agressor.getX() + 20, agressor.getY() + 30, 24, 34);
//        } else if (agressor.getDirection() == Direction.LEFT) {
//            g.fillRect(agressor.getX(), agressor.getY() + 20, 34, 24);
//        } else {
//            g.fillRect(agressor.getX() + 30, agressor.getY() + 20, 34, 24);
//        }

//        g.setColor(new Color(255, 255, 0));
//        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);

    }

    public void processTurn(AbstractTank tank) {
        repaint();
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

        processTurn(tank);

        String YX = getQuadrant(tank.getX(), tank.getY());
        int idx = YX.indexOf("_");
        int y = Integer.parseInt(YX.substring(0, idx));
        int x = Integer.parseInt(YX.substring(idx+1));

        while (covered < 64) {
            if (direction == Direction.UP) {
                if (fieldObjects.get(battleField.scanQuadrant(y-1,x)) instanceof Destroyable) {
                    processFire(bullet);
                }
                tank.updateY(-step);
//				System.out.println("[move up] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            } else if (direction == Direction.DOWN) {
                if (fieldObjects.get(battleField.scanQuadrant(y+1,x)) instanceof Destroyable) {
                    processFire(bullet);
                }
                tank.updateY(step);
//				System.out.println("[move down] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            } else if (direction == Direction.LEFT) {
                if (fieldObjects.get(battleField.scanQuadrant(y, x - 1)) instanceof Destroyable) {
                    processFire(bullet);
                }

                tank.updateX(-step);
//				System.out.println("[move left] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            } else {
                if (fieldObjects.get(battleField.scanQuadrant(y, x + 1)) instanceof Destroyable) {
                    processFire(bullet);
                }
                tank.updateX(step);
//				System.out.println("[move right] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
            }
            covered += step;

            repaint();
            Thread.sleep(tank.getSpeed());
        }

    }

    public void processFire(Bullet bullet) throws Exception  {
        this.bullet = bullet;
        bullet.updateX(agressor.getX() + 25);
        bullet.updateY(agressor.getY()+25);

        while (true) {

            if (bullet.getY() <= 0 || bullet.getY() >= 576) {
                break;
            }
            if (bullet.getX() <= 0 || bullet.getX() >= 576) {
                break;
            }

            if (agressor.getDirection() == Direction.UP) {
                bullet.updateY(bullet.getY() - bullet.getSpeed());
            } else if (agressor.getDirection() == Direction.DOWN) {
                bullet.updateY(bullet.getY()+bullet.getSpeed());
            } else if (agressor.getDirection() == Direction.LEFT) {
                bullet.updateX(bullet.getX()-bullet.getSpeed());
            } else {
                bullet.updateX(bullet.getX()+bullet.getSpeed());
            }

            if(processInterception()) {
                bullet.destroy();
            }

            repaint();
            Thread.sleep(50);
        }

    }
    
}
