package day12.lessons.frame02_03;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by IVG 2015
 */
public class GUI extends JPanel {

    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private List<Ball> balls;

    public GUI() {

        JFrame frame = new JFrame("Incrediball");
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(3);
        frame.setLocation(300, 300);
        frame.getContentPane().add(this);
//        frame.pack();
        setBackground(Color.black);
        frame.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Demo.fieldWidth = getWidth();

        for (Ball ball : balls) {
            drawingBall(ball, g);
        }
    }

    public void drawingBall(Ball ball, Graphics g) {

        g.setColor(ball.getColor());
        g.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());

    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }
}
