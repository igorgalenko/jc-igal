package day12.lessons.frame07;

/**
 * Created by IVG 2015
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Bridge bridge = new Bridge();
        GUI gui = new GUI();
        Car auto = new Car();

        bridge.setY(gui.getHeight() - 100);
        gui.setBridge(bridge);

        gui.setCar(auto);

        auto.setY(gui.getHeight() - 150);
        auto.setMonitor(bridge);
        bridge.setMonitor(auto);

        new Thread(bridge).start();
        auto.start();

        while (true) {

            if (!auto.isAlive() && bridge.isWaitingCar()) {
                auto = new Car();
                auto.setY(gui.getHeight() - 150);
                gui.setCar(auto);
                auto.setMonitor(bridge);
                bridge.setMonitor(auto);
                auto.start();
            }

            gui.repaint();
            Thread.sleep(1000 / 60);
        }
    }
}
