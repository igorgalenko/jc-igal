package tanksGame;

import tanksGame.Tanks.AbstractTank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by IVG 2015
 */
public class KeyboardListener extends KeyAdapter {

    private AbstractTank tank;

    public KeyboardListener() {}

    public void setTank(AbstractTank tank) {
        this.tank = tank;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        System.out.println("KeyboardListener.keyPressed 1");
        int keyCode = e.getKeyCode();

        try {

            switch (keyCode) {

                case KeyEvent.VK_W:
                case KeyEvent.VK_UP:

                    tank.turn(Direction.UP);
                    break;

                case KeyEvent.VK_S:
                case KeyEvent.VK_DOWN:

                    tank.turn(Direction.DOWN);
                    break;

                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:

                    tank.turn(Direction.LEFT);
                    break;

                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:

                    tank.turn(Direction.RIGHT);
                    break;

                case KeyEvent.VK_F:
                case KeyEvent.VK_SPACE:

                    tank.fire();
                    return;

                default:
                    return;
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        tank.move();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }).start();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println("KeyboardListener.keyPressed 2");
    }
}
