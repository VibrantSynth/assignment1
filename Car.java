import java.awt.*;
import java.util.Objects;

public abstract class Car implements Movable{
    public String direction = "North";
    public double x_coordinate = 0;
    public double y_coordinate = 0;
    public int nrDoors;
    public double enginePower;
    public double currentSpeed;
    public Color color;
    public String modelName;

    public Car(int nrDoors, int enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }


    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    public void incrementSpeed(double amount) { currentSpeed = getCurrentSpeed() + speedFactor() * amount;}

    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    @Override
    public void move(){
        if(Objects.equals(direction, "North")){y_coordinate += currentSpeed;}
        else if(Objects.equals(direction, "East")){x_coordinate += currentSpeed;}
        else if(Objects.equals(direction, "South")){y_coordinate -= currentSpeed;}
        else if(Objects.equals(direction, "West")){x_coordinate -= currentSpeed;}
    }

    @Override
    public void turnLeft() {
        if(Objects.equals(direction, "North")){direction = "West";}
        else if(Objects.equals(direction, "East")){direction = "North";}
        else if(Objects.equals(direction, "South")){direction = "East";}
        else if(Objects.equals(direction, "West")){direction = "South";}
    }
    @Override
    public void turnRight() {
        if(Objects.equals(direction, "North")){direction = "East";}
        else if(Objects.equals(direction, "East")){direction = "South";}
        else if(Objects.equals(direction, "South")){direction = "West";}
        else if(Objects.equals(direction, "West")){direction = "North";}
    }
}


