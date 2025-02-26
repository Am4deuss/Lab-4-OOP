import java.awt.*;

public abstract class Vehicle implements Movable {
    protected double currentSpeed; // The current speed of the vehicle
    protected Color color; // Color of the vehicle
    protected double x; // X-coordinate
    protected double y; // Y-coordinate

    protected enum Directions{
        N,
        E,
        S,
        W
    } // Directions (to be used by switch)

    protected Directions current_dir;

    public Vehicle(){
        // in meters
        x = 0;
        y = 0;
        current_dir = Directions.N;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    protected void updatePos(double xVehicle, double yVehicle) {
        this.x = xVehicle;
        this.y = yVehicle;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    @Override
    public void move() {
        switch(current_dir){
            case N: y += currentSpeed; break;
            case E: x += currentSpeed; break;
            case S: y -= currentSpeed; break;
            case W: x -= currentSpeed; break;
        }
    }

    @Override
    public void turnLeft() {
        switch(current_dir){
            case N: current_dir = Vehicle.Directions.W; break;
            case E: current_dir = Vehicle.Directions.N; break;
            case S: current_dir = Vehicle.Directions.E; break;
            case W: current_dir = Vehicle.Directions.S; break;
        }
    }

    @Override
    public void turnRight() {
        switch(current_dir){
            case N: current_dir = Vehicle.Directions.E; break;
            case E: current_dir = Vehicle.Directions.S; break;
            case S: current_dir = Vehicle.Directions.W; break;
            case W: current_dir = Vehicle.Directions.N; break;
        }
    }
}

