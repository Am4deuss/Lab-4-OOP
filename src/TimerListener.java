import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

class TimerListener implements ActionListener {
    // Ovverride ska tas bort sen men jajajaja
    public void actionPerformed(ActionEvent e, ArrayList<Vehicle> cars, Garage garage) {
        for (Vehicle car : cars) {
            car.move();
            int x = (int) Math.round(car.getX());
            int y = (int) Math.round(car.getY());

            // About to hit a wall?  => stop + switch direction + starta motor
            if ((x < 0 || x > 800) || (y < 0 || y > 800)) {
                //car.stopEngine();
                car.turnLeft();
                car.turnLeft();
                //car.startEngine();
            }

            //Send to subscribers
            frame.drawPanel.moveit(car, x, y);

            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();

            if (car instanceof Volvo240){
                if(Math.abs(car.getY() - garage.getY()) <= 50){
                    if(garage.getVehiclesStored().contains(car)) {
                        System.out.println("Successfully loaded VOLVO <3");
                    }
                    garage.addVehicle((Volvo240) car);
                    vehicle.stopEngine();

                }
            }

        }
    }
}