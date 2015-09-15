package day11.lessons;

import java.io.File;
import java.io.IOException;

/**
 * Created by IVG 2015
 * 1. Создай папку с файлом на диске
 * 2. Выведи дерево каталогов
 */
public class Frame05 {

    File file;

    private void createFile() {
        String path = System.getProperty("user.home");
        file = new File(path,"NewFolder");
        file.mkdir();
        path = file.getPath();
        file = new File(path,"NewFile.txt");
        boolean res = false;
        try {
            res = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(res);

    }

    private void printDirectoryTree() {
        String path = System.getProperty("user.home");
        file = new File(path);
        File[] dirs = file.listFiles();
        for (File dir : dirs) {
            if (dir.isDirectory()) {
                System.out.println(dir.getName());
            }

        }
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.home");
        Frame05 frame05 = new Frame05();
        frame05.createFile();
//        frame05.printDirectoryTree();
    }

}
