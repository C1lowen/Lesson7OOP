package lesson7_task1;

public class Dock {
    private int numOfDock;

    public Dock(int numOfDock) {
        super();
        this.numOfDock = numOfDock;
    }

    public int getNumOfDock() {
        return numOfDock;
    }

    public void setNumOfDock(int numOfDock) {
        this.numOfDock = numOfDock;
    }

    public synchronized void unloadShip(Ship ship) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            ship.setBoxes(10 - i);
            System.out.println("Dock " + numOfDock + ": " + ship.getName() + " коробки: " + ship.getBoxes());
            Thread.sleep(500);
        }
        System.out.println(ship.getName() + " Выгрузка завершена");
    }
}
