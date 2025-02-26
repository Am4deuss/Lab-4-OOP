import java.awt.*;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarModel {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    /*public static void main(String[] args) {
        // Instance of this class
        CarModel cc = new CarModel();

        ArrayList<Car> allVehicles = new ArrayList<>();
        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        Scania scania = new Scania();
        allVehicles.add(volvo);
        allVehicles.add(saab95);
        allVehicles.add(scania);
        int currentY = 0;

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        for(Car vehicle : allVehicles){
            vehicle.updatePos(0, currentY);
            cc.cars.add(vehicle);
            cc.frame.drawPanel.addToCarAndPoint(vehicle, new Point((int)vehicle.getX(), (int)vehicle.getY()));
            currentY += 100;
        }

        // Start the timer
        cc.timer.start();
    }*/

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars){
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania) car).setFlatbedAngle(70);
            }
        }
    }

    void lowerBed(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania) car).setFlatbedAngle(0);
            }
        }
    }

    void stop(){
        for (Car car : cars){
            car.stopEngine();
        }
    }

    void start(){
        for (Car car : cars){
            car.startEngine();
        }
    }

}
