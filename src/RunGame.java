import javax.swing.*;
import java.util.ArrayList;

public class RunGame {

    private Controller controller;

    public RunGame(){

        this.controller = new Controller("CarSim 1.0");

        // Creating 3 standard vehicles
        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        Scania scania = new Scania();
        this.controller.carM.data.vehicles.add(volvo);
        this.controller.carM.data.vehicles.add(saab95);
        this.controller.carM.data.vehicles.add(scania);

        this.controller.carM.setup();

        this.controller.startTimer();

        // Creating one workshop
        Garage<Volvo240>  volvoGarage = new Garage<>(5, 0, 300, Volvo240.class);


    }

}
