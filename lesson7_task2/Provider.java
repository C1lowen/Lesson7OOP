package lesson7_task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Provider implements Runnable {
    private FileCopy service;
    private File file;
    private long length;
    private long available;
    private Progress pp = new Progress();

    public Provider(FileCopy service,File file) {
        this.service = service;
        this.file = file;
        this.length = file.length();
        this.available = length;
    }


    private class Progress implements Runnable{
        @Override
        public void run() {
            for(;available > 0;){
                System.out.println("Загрузилось на " +  (int) (((length - available)) / (length / 100)) + "%");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Загрузилось на " +  100 + "%");
        }
    }

    @Override
    public void run() {
        Thread th1 = new Thread(pp);
        th1.start();
        try(InputStream is = new FileInputStream(file)){
            byte[] bytes;
            while(available > 0){
                bytes = new byte[100];
                readFile(is, bytes);
            }

            service.setStop(true);
            th1.join();
        }catch (InterruptedException | IOException e){
            e.printStackTrace();
        }
    }

    public void readFile(InputStream is, byte[] bytes) throws IOException{
        is.read(bytes);
        service.setBytes(bytes);
        available -= bytes.length;
    }
}
