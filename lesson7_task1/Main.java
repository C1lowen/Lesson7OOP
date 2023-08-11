package lesson7_task1;

public class Main {
    public static void main(String[] args) {
        Port port = new Port();

        Ship ship1 = new Ship(true, 10, port, "корабиль 1");
        Ship ship2 = new Ship(false, 10, port, "корабиль 2");
        Ship ship3 = new Ship(false, 10, port, "корабиль 3");


        Thread th1 = new Thread(ship1);
        Thread th2 = new Thread(ship2);
        Thread th3 = new Thread(ship3);


        th1.start();
        th2.start();
        th3.start();

    }
}
