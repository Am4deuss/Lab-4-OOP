import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;


public class CarModel {

    public VehicleData data = new VehicleData();

    TimerListener listener;

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
            for(Subscriber subscriber : subscriberList){
                subscriber.addToCarAndPoint(vehicle, new Point((int)vehicle.getX(), (int)vehicle.getY()));
            }
        }
        listener = new TimerListener();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : data.vehicles) {
            ((Car) vehicle).gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : data.vehicles){
            ((Car) vehicle).brake(brake);
        }
    }

    void turboOn() {
        for (Vehicle vehicle : data.vehicles){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle vehicle : data.vehicles){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void liftBed(){
        for (Vehicle vehicle : data.vehicles){
            if (vehicle instanceof Scania){
                ((Scania) vehicle).setFlatbedAngle(70);
            }
        }
    }

    void lowerBed(){
        for (Vehicle vehicle : data.vehicles){
            if (vehicle instanceof Scania){
                ((Scania) vehicle).setFlatbedAngle(0);
            }
        }
    }

    void stop(){
        for (Vehicle vehicle : data.vehicles){
            ((Car) vehicle).stopEngine();
        }
    }

    void start(){
        for (Vehicle vehicle : data.vehicles){
            ((Car) vehicle).startEngine();
        }
    }

}
