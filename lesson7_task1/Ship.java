package lesson7_task1;

public class Ship implements Runnable{
    private boolean turn;
    private int boxes;
    private Port port;

    private String name;

    public Ship(boolean turn, int boxes, Port port, String name) {
        this.turn = turn;
        this.boxes = boxes;
        this.port = port;
        this.name = name;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getBoxes() {
        return boxes;
    }

    public void setBoxes(int boxes) {
        this.boxes = boxes;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            port.isDockDistribution(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
