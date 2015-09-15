package day11.lessons.frame15;

import java.util.List;

/**
 * Created by IVG 2015
 */
public interface Archivator {

    void printHelp();

    void zipFiles(List<String> filesList,String zipFileName);

    void unzipFiles(String archiveName);
}
