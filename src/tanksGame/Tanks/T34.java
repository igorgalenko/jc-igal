package tanksGame.Tanks;

import tanksGame.ActionField;
import tanksGame.Launcher;
import tanksGame.battleField.BattleField;
import tanksGame.Direction;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by IVG on 03.07.15.
 */
public class T34 extends AbstractTank {

    private final String IMAGE_FILE = Launcher.resPath+"2.jpg";

    public T34(ActionField af, BattleField bf) {

        this(af, bf, 64 * 4, 8 * 64, Direction.UP);

    }

    public T34(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        try {
            image = ImageIO.read(new File(IMAGE_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }

    @Override
    public boolean destroy() {
        super.destroy();
        getActionField().showResult();
        return true;
    }
}
