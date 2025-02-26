import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarModel {

    public VehicleData data = new VehicleData();

    private final ArrayList<Subscriber> subscriberList = new ArrayList<>();

    public void addObserver(Subscriber subscriber){
        subscriberList.add(subscriber);
    }

    // setup-method
    void setup(){
        for(Vehicle vehicle : data.vehicles){
            vehicle.updatePos(0, data.currentY);
            data.currentY += 100;
            // sending to subscribers (hi youtube)
            Subscriber subscriber.addToCarAndPoint(vehicle, new Point((int)vehicle.getX(), (int)vehicle.getY()));
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
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
