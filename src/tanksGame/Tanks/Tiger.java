package tanksGame.Tanks;

import tanksGame.ActionField;
import tanksGame.battleField.BattleField;
import tanksGame.Direction;

import java.awt.*;

/**
 * Created by Irina on 25.06.2015.
 */
public class Tiger extends AbstractTank {

    private int armor = 1;

    public Tiger(ActionField af, BattleField bf) {
        super(af, bf);
        tankColor = new Color(255,0,0);
        towerColor = new Color(255,255,0);
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        tankColor = new Color(255,0,0);
        towerColor = new Color(255,255,0);
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
}
