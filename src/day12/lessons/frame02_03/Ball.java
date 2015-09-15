package day12.lessons.frame02_03;

import java.awt.*;

/**
 * Created by IVG 2015
 */
public class Ball {

    private Color color;
    private int speed;
    private int x;
    private int y;
    private int diameter;
    private String name;

    public Ball() {

        color = Color.BLACK;
        name = "Unknown";
        speed = 1;
        diameter = 25;
        x = 0;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setY(int y) {
        if (y < 0 || y > Demo.fieldWidth) {
            y = 0;
        }
        this.y = y;
    }

    public void setSpeed(int speed) {

        if (speed > 10) {
            System.out.println("Speed for "+name+" ball is to high. It will set on 10");
            speed = 10;
        } else if (speed < 1) {
            System.out.println("Speed for "+name+" ball is to low. It will set on 1");
            speed = 1;
        }

        this.speed = speed;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getName() {
        return name;
    }

    public void updateX(int speed) {
        x += speed;
        if (x < 0) {
            x = 0;
        }
        if (x > Demo.fieldWidth) {
            x = Demo.fieldWidth;
        }
    }
}
