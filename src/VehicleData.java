import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class VehicleData {

    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    HashMap<Vehicle, Point> carAndPoint = new HashMap<Vehicle, Point>();

    Point VolvoWorkshopPoint;

    int currentY = 0;

    void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public Point getVehiclePoint(Vehicle vehicle){
        return carAndPoint.get(vehicle);
    }
}
