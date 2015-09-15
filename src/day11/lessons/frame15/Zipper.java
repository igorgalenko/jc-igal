package day11.lessons.frame15;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by IVG 2015
 */
public class Zipper {

    private String parentPath;

    private String archiveName;
    private List<String> filePathList;

    public Zipper() {}

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public void setFilePathList(List<String> filePathList) {
        this.filePathList = filePathList;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public void zipFiles() {

        File zipFile = new File(archiveName);

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {

            zos.setLevel(5);

            for (String filePath : filePathList) {

                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath))) {

                    String zipEntryName = getZipEntryName(filePath);
                    zos.putNextEntry(new ZipEntry(zipEntryName));

                    System.out.println("zipping file: "+zipEntryName);

                    int i;
                    while ((i = bufferedInputStream.read()) >= 0) {
                        zos.write(i);
                    }
                }
            }
            zos.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getZipEntryName(String filePath) {
        return filePath.substring(parentPath.length());
    }
}
