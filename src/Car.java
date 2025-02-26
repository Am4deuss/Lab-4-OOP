import java.awt.*;

public abstract class Car extends Vehicle {

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected String modelName; // The car model name

    public Car(){
       super();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public String getCarModel() {
        return modelName;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected double speedFactor(){
        return enginePower * 0.01;
    }

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0.1);
    }

    public boolean gas(double amount){
        boolean correctRange = true;
        if(amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        } else{
            correctRange = false;
        }
        return correctRange;
    }

    public boolean brake(double amount){
        boolean correctRange = true;
        if(amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        } else{
            correctRange = false;
        }
        return correctRange;
    }
}