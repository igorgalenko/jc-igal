package day11.lessons.frame15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IVG 2015
 */
public class Demo {

    public static List<String> filesList = new ArrayList<>();
    public static String absolutePath;
    public final static char SEPOR = File.separatorChar;

    public static void main(String[] args) {

        //zip E:\Java\Idea\jc-igal\src\day11 newzip
        //unzip E:\Java\Idea\jc-igal\src\newzip.zip
        ArchivatorService archivatorService = new ArchivatorService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type command to console for running program or type 'help' for getting help");
        String command = scanner.nextLine();

        while (!archivatorService.commandHandling(command)) {
            command = scanner.nextLine();
        }
    }

}
