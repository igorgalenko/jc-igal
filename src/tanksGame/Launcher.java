package tanksGame;

import tanksGame.GUI.MainFrame;
import tanksGame.GUI.MainPanel;

/**
 * Created by IVG on 13.06.15.
 */
public class Launcher {

    /*
    TODO
    1. Сделать логирование действий
    2. Перевести на многопоточность
    3. Реализовать GUI для запуска игры
    4. Возможность просмотреть повтор игры из лога
    5. BT7 должен уничтожить штаб
    6. Tiger должен уничтожить Защитника
    7. Прозрачная вода
    8. Экран результатов игры после разрушения штаба или защитника, с возможностью сыграть снова

    */
    public static String resPath = "E:\\Java\\Idea\\jc-igal\\src\\tanksGame\\res\\";

    public static void main(String[] args) throws Exception {

        new MainPanel();
//        ActionField actionField = new ActionField();
//        actionField.runTheGame();
    }
}
