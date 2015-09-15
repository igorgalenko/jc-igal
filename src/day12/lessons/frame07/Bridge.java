package day12.lessons.frame07;

/**
 * Created by IVG 2015
 */
public class Bridge implements Runnable {

    private int x;
    private int y;
    private int radius;
    private int angle;

    private Object monitor;

    public Bridge() {
/* TODO
* на второй машине мост поднялся и все стоят, если уменьшить скорость работы моста*/

        x = 300;
        radius = 100;
        angle = -45;
    }

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX2() {
        return (int) (x + radius * Math.cos(Math.toRadians(angle)));
    }

    public int getY2() {
        return (int) (y + radius * Math.sin(Math.toRadians(angle)));
    }


    @Override
    public void run() {

        try {
            while (true) {

                System.out.println("Bridge waiting for a car");
                synchronized (this) {
                    wait();
                }
                movingBridge();

                System.out.println("Bridge make some job");
                synchronized (monitor) {
                    monitor.notify();
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void movingBridge() {

        if (angle < 0) {
            putDown();
        } else {
            getUp();
        }
    }

    private void putDown() {

        while (angle < 0) {
            angle++;
            goSleep();
        }

    }

    private void getUp() {

        while (angle > -45) {
            angle--;
            goSleep();
        }
    }

    private void goSleep() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isWaitingCar() {
        return angle == -45;
    }
}
