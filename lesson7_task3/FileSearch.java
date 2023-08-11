package lesson7_task3;

import java.io.File;
import java.io.IOException;

public class FileSearch{

    private int count;

    public void folderFileCheck(File folder, String name) {
        if(folder.isDirectory()) {
            File[] files = folder.listFiles();
            for (var file : files) {
                if (file.isDirectory()) {
                    SearchTask st = new SearchTask(this, file, name);
                    count += 1;
                    synchronized (this) {
                        for (; count > 2;) {
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                String nameFile = file.getName();
                if (nameFile.equals(name)) {
                    System.out.println(file);
                }
            }
        }
        synchronized (this) {
            notifyAll();
        }

    }



}
