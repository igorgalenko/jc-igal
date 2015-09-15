package day12.lessons.frame02_03;

/**
 * Created by IVG 2015
 */
public class Motion implements Runnable{

    private Ball ball;
    private final long PAUSE = 50L;

    public Motion() {
    }

    @Override
    public void run() {

        System.out.println("Starting thread "+Thread.currentThread().getName());

        while (true) {
            try {
                movingBall();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    private void movingBall() throws InterruptedException {

//        int destX = Demo.fieldWidth - ball.getDiameter();
        int ballSpeed = ball.getSpeed();

        while (ball.getX() < (Demo.fieldWidth - ball.getDiameter())) {
            ball.updateX(ballSpeed);
            Thread.sleep(PAUSE);
        }

        while (ball.getX() > 0) {
            ball.updateX(-ballSpeed);
            Thread.sleep(PAUSE);
        }
    }
}
