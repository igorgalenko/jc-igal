package tanksGame.battleField;

public class BattleField {

    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    private AbstractFieldObject[][] b = {
        {new Brick()}
    };

    private String[][] battleField =
            {   //1   2   3   4   5   6   7   8   9
                {" ","B","B","B"," ","B","B","B"," "}, //1
                {"B"," "," "," "," "," "," "," ","B"}, //2
                {"B","B","B"," "," "," ","B","B","B"}, //3
                {"B"," ","B","B","B","B","B"," ","B"}, //4
                {"B"," ","B","B"," ","B","B"," ","B"}, //5
                {"B","B","B","B"," ","B","B","B","B"}, //6
                {"B"," "," ","B"," ","B"," "," ","B"}, //7
                {"W"," "," ","B"," ","B"," "," ","B"}, //8
                {"B","B","E","B"," ","B","B","R","B"}  //9
            };

    public BattleField() {

    }

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }

    public String scanQuadrant(int y, int x) {

        return battleField[y][x];

    }

    public void updateQuadrant(int y, int x, String value) {

        battleField[y][x] = value;
    }

    public int getDimentionX() {
        return battleField[0].length;
    }
    public int getDimentionY() {
        return battleField.length;
    }
}
