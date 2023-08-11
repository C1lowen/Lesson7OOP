package lesson7_task3;

import java.io.File;

public class SearchTask implements Runnable{
    private FileSearch fl;
    private Thread thr;
    private File file;
    private String nameFile;


    public SearchTask(FileSearch fl, File file, String nameFile) {
        this.fl = fl;
        this.file = file;
        this.nameFile = nameFile;
        thr = new Thread(this);
        thr.start();
    }

    public Thread getThr() {
        return thr;
    }

    public void setThr(Thread thr) {
        this.thr = thr;
    }

    @Override
    public void run() {
        fl.folderFileCheck(file, nameFile);
    }
}
