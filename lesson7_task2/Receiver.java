package lesson7_task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Receiver implements Runnable {
        private FileCopy service;
        private File file;

    public Receiver(FileCopy service, File file) {
        this.service = service;
        this.file = file;
    }



    @Override
    public void run() {
        try(OutputStream out = new FileOutputStream(file)){
            while(!service.isStop()){
                out.write(service.getBytes());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
