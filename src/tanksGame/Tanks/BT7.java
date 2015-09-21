package tanksGame.Tanks;

import tanksGame.ActionField;
import tanksGame.battleField.BattleField;
import tanksGame.Direction;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by IVG on 25.06.2015.
 */
public class BT7 extends AbstractTank {

    private final String IMAGE_FILE = "tank.jpg";

    public BT7(ActionField af, BattleField bf) {
        super(af, bf);
        speed = speed*2;
        try {
            image = ImageIO.read(new File(IMAGE_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        speed = speed*2;
        try {
            image = ImageIO.read(new File(IMAGE_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroyDefender(AbstractTank defender) {

    }

}
