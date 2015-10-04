package tanksGame.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IVG 2015
 */
public class MainPanel extends JPanel {

    public MainPanel() {

        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("Tanks");
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setContentPane(this);
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(200, 200));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 0, 5, 0);
        constraints.gridx = 0;
        constraints.fill = GridBagConstraints.CENTER;

        ButtonListener listener = new ButtonListener();
        listener.setFrame(frame);

        JButton button = new JButton("New game");
        button.setName("newGame");
        constraints.gridy = 0;
        button.addMouseListener(listener);
        add(button, constraints);

        Dimension preferredSize = button.getPreferredSize();

        button = new JButton("Exit");
        button.setName("exit");
        constraints.gridy = 2;
        button.setPreferredSize(preferredSize);
        button.addMouseListener(listener);
        add(button, constraints);

        button = new JButton("About");
        button.setName("about");
        constraints.gridy = 1;
        button.setPreferredSize(preferredSize);
        button.addMouseListener(listener);
        add(button, constraints);

    }
}
