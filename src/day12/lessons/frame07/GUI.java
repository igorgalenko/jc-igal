package day12.lessons.frame07;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by IVG 2015
 */
public class GUI extends JPanel {

    private Bridge bridge;
    private Car car;
    private BufferedImage image = null;

    public GUI() {

        JFrame frame = new JFrame("THREADS INTERACTION");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 400));
        frame.add(this);
        frame.setLocation(200, 200);
        frame.pack();
        frame.setVisible(true);


//        try {
//            image = ImageIO.read(new File("src\\day12\\lessons\\frame07\\res\\car_red.png"));
//            image = ImageIO.read(new File("src\\day12\\lessons\\frame07\\res\\car_police.png"));
//        } catch (IOException e) {
//        }
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.fillRect(0, getHeight() - 100, 300, 100);
        g.fillRect(400, getHeight() - 100, getWidth(), 100);

        drawBridge(g);

        drawCar(g);

    }

    private void drawCar(Graphics graphics) {

        if (car == null) {
            return;
        }

        int carX = car.getX();
        int carY = car.getY();


//        graphics.drawImage(image, carX, carY+10, 100, 50, new ImageObserver() {
//            @Override
//            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
//                return false;
//            }
//        });


        Color oldColor = graphics.getColor();

        graphics.setColor(car.getColor());
        graphics.fillRect(carX, carY, 100, 35);

        graphics.setColor(oldColor);

    }

    private void drawBridge(Graphics graphics) {

        if (bridge == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) graphics;

        Color oldColor = graphics.getColor();

        graphics.setColor(Color.RED);
        g2.setStroke(new BasicStroke(5f));
        g2.drawLine(bridge.getX(), bridge.getY(), bridge.getX2(), bridge.getY2());
        graphics.setColor(oldColor);

    }
}
