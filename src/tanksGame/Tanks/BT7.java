package tanksGame.Tanks;

import tanksGame.ActionField;
import tanksGame.battleField.BattleField;
import tanksGame.Direction;

import java.awt.*;

/**
 * Created by Irina on 25.06.2015.
 */
public class BT7 extends AbstractTank {

    public BT7(ActionField af, BattleField bf) {
        super(af, bf);
        speed = speed*2;
        tankColor = new Color(255,0,0);
        towerColor = new Color(255,255,0);
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        speed = speed*2;
        tankColor = new Color(255,0,0);
        towerColor = new Color(255,255,0);
    }


}
