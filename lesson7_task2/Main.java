package lesson7_task2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("D:\\One\\naaa.txt");
        File fileCopy = new File("D:\\One\\newFile.txt");

        long start = System.currentTimeMillis();
        try {
            FileCopy.copy(file, fileCopy);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();

        System.out.println("Время: " + (end-start) + "ms");

        long start2 = System.currentTimeMillis();

        try {
            copyFile(file, fileCopy);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long end2 = System.currentTimeMillis();

        System.out.println("Время: " + (end2-start2) + "ms");
    }
    public static void copyFile(File fileRead, File fileOut) throws IOException{
        try(InputStream is= new FileInputStream(fileRead);
            OutputStream out = new FileOutputStream(fileOut)){
            is.transferTo(out);
        }

    }

}
