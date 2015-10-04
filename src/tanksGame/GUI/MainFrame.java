package tanksGame.GUI;

import forTesting.Panel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IVG 2015
 */
public class MainFrame {

    public MainFrame() {

        JFrame frame = new JFrame("Tanks");
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setContentPane(new MainPanel());
//        frame.add(new MainPanel());
        frame.setMinimumSize(new Dimension(200, 200));
        frame.setVisible(true);

    }
}
