package tanksGame;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by IVG 2015
 */
public class Redraw implements Runnable{

    private JPanel panel;
    private AtomicBoolean needRedraw;

    public Redraw() {
        needRedraw = new AtomicBoolean(true);
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        while (needRedraw.get()) {
//            System.out.println("Redraw.run");
            panel.repaint();
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNeedRedraw(AtomicBoolean needRedraw) {
        this.needRedraw = needRedraw;
    }
}
