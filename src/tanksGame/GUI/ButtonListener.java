package tanksGame.GUI;

import tanksGame.ActionField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by IVG 2015
 */
public class ButtonListener extends MouseAdapter {

    private JFrame frame;

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        JButton button = (JButton) e.getSource();
        String name = button.getName();

        switch (name) {
            case "newGame":

                try {
                    new ActionField().runTheGame();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                frame.dispose();

                break;
            case "about":
                 System.out.println("show about");
                break;
            default:
                System.exit(0);
        }
    }
}
