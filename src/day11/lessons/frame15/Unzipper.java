package day11.lessons.frame15;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by IVG 2015
 */
public class Unzipper {

    private String archiveName;

    public Unzipper() {}

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public void unzipFiles() {

        String destPath = archiveName.replaceAll("\\.zip", "");

        ZipEntry zipEntry;
        String fileName;

        File destFolder = new File(destPath);

        destPath = destPath + File.separatorChar;

        if (!destFolder.exists()) {
            destFolder.mkdirs();
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archiveName))) {

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {

                fileName = zipEntry.getName();

                System.out.println("unzipping: " + fileName);

                File zipedFile = new File(destPath + fileName);

                if (zipedFile.isDirectory()) {
                    zipedFile.mkdirs();
                    continue;
                }

                zipedFile.getParentFile().mkdirs();

                try (BufferedOutputStream bufferedOutputStream =
                             new BufferedOutputStream(new FileOutputStream(zipedFile.getAbsolutePath()))) {

                    int i;
                    while ((i = zipInputStream.read()) > 0) {
                        bufferedOutputStream.write(i);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
