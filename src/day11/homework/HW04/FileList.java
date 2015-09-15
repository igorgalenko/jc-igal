package day11.homework.HW04;

import java.io.*;
import java.util.Iterator;

/**
 * Created by IVG 2015
 */
public class FileList<T> extends RandomAccessFile implements Iterable, SimpleList<T> {

    private int lineCount;
    private final String LINE_SEPARATOR = System.lineSeparator();

    public FileList() throws IOException {
        this("SimpleList.txt");
        setLength(0);
        lineCount = 0;
    }

    public FileList(String filePath) throws FileNotFoundException {
        super(filePath, "rw");
        setLineCount();
    }

    private void setLineCount() {
        for (Object obj : this) {
            lineCount++;
        }
    }

    @Override
    public void add(T object) {

        byte[] data = objectToByteArray(object);

        try {

            write(data);
            lineCount++;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean contains(T object) {

        for (Object obj : this) {
            if (obj.toString().equals(object.toString())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void remove(T object) {

        byte[] data = objectToByteArray(object);

        if (contains(object)) {
            try {

                seek(getFilePointer() - data.length);

                write(new byte[1]);
                lineCount--;

                seek(length());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] objectToByteArray(T object) {
        String str = object.toString() + LINE_SEPARATOR;
        return str.getBytes();
    }

    @Override
    public int size() {
        return lineCount;
    }

    @Override
    public Iterator iterator() {
        return new FileIterator();
    }

    private class FileIterator implements Iterator {

        private String currentLine = null;

        private FileIterator() {
            try {
                seek(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean hasNext() {

            try {
                currentLine = readLine();
                while (currentLine != null && currentLine.length() > 0 && currentLine.getBytes()[0] == 0) {
                    currentLine = readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return currentLine != null;

        }

        @Override
        public Object next() {

            return currentLine;

        }
    }
}
