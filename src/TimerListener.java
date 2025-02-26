import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

private class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        for (Car car : cars) {
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

            frame.drawPanel.moveit(car, x, y);

            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();

            if (car instanceof Volvo240){
                if(Math.abs(car.getY() - volvoGarage.getY()) <= 50){
                    if(!volvoGarage.getVehiclesStored().contains(car)) {
                        System.out.println("Successfully loaded VOLVO <3");
                    }
                    volvoGarage.addVehicle((Volvo240) car);
                    car.stopEngine();

                }
            }

        }
    }
}