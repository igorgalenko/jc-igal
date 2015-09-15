package day11.lessons.frame15;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IVG 2015
 */
public class ArchivatorService implements Archivator {

    private List<String> filePathList = new ArrayList<>();

    @Override
    public void printHelp() {

        System.out.printf("%-20s %s\n", "zip <file> <archive>", ": make zip-archive from file or directory");
        System.out.printf("%-22s %s\n", "","example, zip my_file.txt anyName or zip my_dir anyName");
        System.out.printf("%-20s %s\n", "unzip <filename>", ": unpack zip-archive <filename> to directory <filename>");
        System.out.printf("%-22s %s\n", "", "example, unzip my_file");
        System.out.printf("%-20s %s\n", "help", ": printing this help");
        System.out.printf("%-20s %s\n", "exit", ": close program");
        System.out.println(">");

    }

    @Override
    public void zipFiles(List<String> filePathList, String zipFileName) {

        Zipper zipper = new Zipper();

        zipper.setFilePathList(filePathList);
        zipper.setArchiveName(zipFileName);
        zipper.setParentPath(getParentPath(zipFileName));

        zipper.zipFiles();
    }

    @Override
    public void unzipFiles(String archiveName) {

        Unzipper unzipper = new Unzipper();

        unzipper.setArchiveName(archiveName);

        unzipper.unzipFiles();
    }

    public boolean commandHandling(String inputLine) {

        inputLine = inputLine.toLowerCase();
        while (inputLine.contains("  ")) {
            inputLine = inputLine.replaceAll("  ", " ");
        }
        String[] arr = inputLine.split(" ");

        return commandRunning(arr);

    }

    private boolean commandRunning(String[] commandArray) {

        boolean condition = true;

        if (commandArray.length == 3 && commandArray[0].equals("zip")) {

            createFilePathList(commandArray[1]);

            if (filePathList.size() > 0) {

                String archiveName = generateArchiveName(commandArray[1],commandArray[2]);

                zipFiles(new ArrayList<>(filePathList), archiveName);
            } else {
                System.out.println("can't find files for zip");
                condition = false;
            }

        } else if (commandArray.length == 2 && commandArray[0].equals("unzip")) {

            unzipFiles(commandArray[1]);

        } else if (commandArray.length == 1 && commandArray[0].equals("help")) {
            printHelp();
            condition = false;
        } else if (commandArray.length == 1 && commandArray[0].equals("exit")) {
            //true
        } else {
            System.out.println("Incorrect command");
            condition = false;
        }

        return condition;
    }

    private String generateArchiveName(String sourcePath, String archiveName) {

        String ext = ".zip";

        if (!archiveName.contains(ext)) {
            archiveName += ext;
        }

        String parentPath = getParentPath(sourcePath);

        return parentPath+archiveName;

    }

    private String getParentPath(String filePath) {

        return new File(filePath).getParent()+File.separatorChar;

    }

    private void createFilePathList(String pathname) {

        File file = new File(pathname);

        if (file.exists()) {

            addFileToList(file);

        } else {
            System.out.println("file '"+pathname+"' not found");
        }
    }

    private void addFileToList(File file) {

        if (file.isFile()) {
            filePathList.add(file.getAbsolutePath());
        }

        if (file.isDirectory()) {
            for (File nextFile : file.listFiles()) {
                addFileToList(nextFile);
            }
        }
    }
}
