package lesson7_task2;

import java.io.*;

public class FileCopy{
    private byte[] bytes;

    private boolean turn;
    private boolean stop;

    public static void copy(File fileRed, File fileCopy) throws IOException{
        new FileCopy(fileRed, fileCopy);
    }

    private FileCopy(File fileRed, File fileCopy) throws IOException{
        Thread th1 = new Thread(new Provider(this, fileRed));
        Thread th2 = new Thread(new Receiver(this, fileCopy));

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized byte[] getBytes() {
        for(;!turn;){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        turn = false;
        notifyAll();
        return bytes;
    }

    public synchronized void setBytes(byte[] bytes) {
        for(;turn;){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.bytes = bytes;
        turn = true;
        notifyAll();
    }

    public boolean isStop(){
        return stop;
    }

    public void setStop(boolean stop){
        this.stop = stop;
    }
}
