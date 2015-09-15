package day12.lessons.frame02_03;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IVG 2015
 */
public class Demo {

    public static int fieldWidth;
    private static List<Ball> balls;

    public static void main(String[] args) throws InterruptedException {

        GUI gui = new GUI();

        balls = new ArrayList<>();
        fieldWidth = gui.getWidth();

        createBallsCollection();
        gui.setBalls(balls);

        startingMotion();

        while (true) {
            Thread.sleep(1000 / 60);
            gui.repaint();
        }

    }

    private static void createBallsCollection() {

        int localY = 10;
        Ball ball;

        //rainbow colors

        ball = new Ball();
        ball.setColor(Color.red);
        ball.setName("Red");
        ball.setSpeed(1);
        ball.setY(localY);
        balls.add(ball);

        ball = new Ball();
        ball.setColor(Color.orange);
        ball.setName("Orange");
        ball.setSpeed(2);
        ball.setY(getNextY());
        balls.add(ball);

        ball = new Ball();
        ball.setColor(Color.yellow);
        ball.setName("Yellow");
        ball.setSpeed(3);
        ball.setY(getNextY());
        balls.add(ball);

        ball = new Ball();
        ball.setColor(Color.green);
        ball.setName("Green");
        ball.setSpeed(4);
        ball.setY(getNextY());
        balls.add(ball);

        ball = new Ball();
        ball.setColor(new Color(0, 200, 255));
        ball.setName("Light-blue");
        ball.setSpeed(5);
        ball.setY(getNextY());
        balls.add(ball);

        ball = new Ball();
        ball.setColor(Color.blue);
        ball.setName("Blue");
        ball.setSpeed(6);
        ball.setY(getNextY());
        balls.add(ball);

        ball = new Ball();
        ball.setColor(new Color(160, 65, 199));
        ball.setName("Violet");
        ball.setSpeed(7);
        ball.setY(getNextY());
        balls.add(ball);

    }

    private static int getNextY() {
        Ball ball = balls.get(balls.size() - 1);
        return ball.getY() + ball.getDiameter() * 2;
    }

    private static void startingMotion() {

        for (Ball ball : balls) {

            Motion motion = new Motion();
            motion.setBall(ball);
            Thread thread = new Thread(motion, ball.getName());
            thread.start();

        }
    }
}
