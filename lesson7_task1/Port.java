package lesson7_task1;

public class Port {
    private Dock dock1 = new Dock(1);
    private Dock dock2 = new Dock(2);
    public void isDockDistribution(Ship ship) throws InterruptedException{
        if(ship.isTurn()){
            dock1.unloadShip(ship);
        }else{
            dock2.unloadShip(ship);
        }

    }
}
