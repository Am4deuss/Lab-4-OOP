import java.util.ArrayList;

public class Garage<T extends Vehicle> {
    private ArrayList<T> vehiclesStored;
    private int maxVehicles;
    private Class<?>[] vehicleTypes;

    private double x;
    private double y;

    public Garage(int maxVehicles, double x, double y, Class<? extends T>... vehicleModels){
        this.x = x;
        this.y = y;
        vehiclesStored = new ArrayList<>();
        this.maxVehicles = maxVehicles;
        vehicleTypes = vehicleModels;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public ArrayList<T> getVehiclesStored() {
        return vehiclesStored;
    }

    public Class<?>[] getVehicleTypes() {
        return vehicleTypes;
    }

    public void addVehicle(T vehicle) {
        // check if instance of the right type with accepted Vehicle()
        if(!vehiclesStored.contains(vehicle)) {
            if (isAccepted(vehicle)) {
                vehiclesStored.add(vehicle);
            } else {
                System.out.println(vehicle.getvehicleModel());
                throw new IllegalArgumentException("Wrong vehicle type :P");
            }
        }
    }

    public Vehicle removeVehicle(int vehicleIndex) {
       Vehicle removedVehicle = null;
       if(vehicleIndex != 0 && vehicleIndex < vehiclesStored.size()) {
           removedVehicle = vehiclesStored.get(vehicleIndex);
           vehiclesStored.remove(vehicleIndex);
       }
       return removedVehicle;
    }

    private boolean isAccepted(T vehicle) {
        boolean check = false;
        if (vehiclesStored.size() == this.maxVehicles) {
            return false;
        } else {
            for (Class<?> model : vehicleTypes) {
                if (model.isInstance(vehicle)) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }
}