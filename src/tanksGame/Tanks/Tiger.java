package tanksGame.Tanks;

import tanksGame.ActionField;
import tanksGame.battleField.BattleField;
import tanksGame.Direction;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Irina on 25.06.2015.
 */
public class Tiger extends AbstractTank {

    private int armor = 1;
    private final String IMAGE_FILE = "tiger.png";

    public Tiger(ActionField af, BattleField bf) {
        super(af, bf);
        try {
            image = ImageIO.read(new File(IMAGE_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        try {
            image = ImageIO.read(new File(IMAGE_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean destroy() {
        if (armor > 0) {
            armor--;
            return false;
        }
        super.destroy();
        return true;
    }

    public void destroyDefender(AbstractTank defender) throws Exception {

        BattleField bf = getBattleField();
        int defenderX = defender.getX()/64+1;
        int defenderY = defender.getY()/64+1;

        moveToQuadrant(getY()/64+1,defenderX);
        turn(Direction.DOWN);

        while (defenderX > 0) {
            fire();
            defenderX = defender.getX()/64+1;
        }

    }
}
