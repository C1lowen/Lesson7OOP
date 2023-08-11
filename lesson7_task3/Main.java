package lesson7_task3;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("D:\\One");

        FileSearch fl = new FileSearch();

        SearchTask st = new SearchTask(fl, file, "111.txt");
    }
}
