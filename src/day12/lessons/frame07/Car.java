package day12.lessons.frame07;

import java.awt.*;
import java.util.Random;

/**
 * Created by IVG 2015
 */
public class Car extends Thread {

    private int x;
    private int y;
    private int speed = 5;
    private Color color;

    private Color[] colors = {Color.RED, Color.BLACK, Color.BLUE, Color.GREEN};
    private Object monitor;

    public Car() {
        x = -100;
        y = -100;
        setRandomColor();
    }

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    private void setRandomColor() {
        Random random = new Random();
        color = colors[random.nextInt(colors.length)];
    }

    @Override
    public void run() {

        boolean notNotified = true;

        try {
            while (x < 1000) {

                if (carNearBridge()) {
                    System.out.println("Beep-beep-beep");
                    synchronized (monitor) {
                        monitor.notify();
                    }
                    System.out.println("Car wait bridge put down");
                    synchronized (this) {
                        wait();
                    }
                    System.out.println("Car moving on");
                }

                if (carCrossedBridge() && notNotified) {
                    System.out.println("Car crossed the bridge");
                    synchronized (monitor) {
                        notNotified = false;
                        monitor.notify();
                    }
                }

                x++;
                sleep(speed);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Car went far away");
        x = -100;

    }

    private boolean carCrossedBridge() {
        int afterBridgeX = 450;
        return x > afterBridgeX;
    }

    private boolean carNearBridge() {
        int nearBridgeX = 300;
        return x + 110 == nearBridgeX;
    }

}
