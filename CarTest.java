import java.awt.*;
import java.util.Objects;

public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab95 with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    private static void checkDirection() {
        Saab95 northSaab = new Saab95();
        northSaab.turnRight();
        northSaab.turnRight();
        northSaab.turnLeft();
        northSaab.turnRight(); // expected output: "South"
//        String result = northSaab.direction;
//        IO.println("SUCCESS: Car facing: "+result);
        boolean result = Objects.equals(northSaab.direction, "South");
        reportResult("Car is facing "+northSaab.direction, result);
    }

    private static void checkPosition() {
        Volvo240 movingCar = new Volvo240();
        movingCar.gas(1);
        movingCar.move(); // i'm on the move
        movingCar.brake(1);
        movingCar.turnLeft(); // i'm on the turn
        movingCar.gas(0.5);
        movingCar.move();

        boolean result = Objects.equals(movingCar.x_coordinate,-0.625) && Objects.equals(movingCar.y_coordinate,1.25) ;
        reportResult("Car position: ("+movingCar.x_coordinate+", "+movingCar.y_coordinate+")", result);
//        IO.println("SUCCESS: Car position: ("+movingCar.x_coordinate+", "+movingCar.y_coordinate+")");
    }

    private static void testGas() {
        Saab95 gassingCar = new Saab95();
        gassingCar.gas(-10);
    }

    private static void testBrake() {
        Saab95 brakingCar = new Saab95();
        brakingCar.brake(-10);

    }

    static void main() {
        testTurbo();
        checkDirection();
        checkPosition();
        testGas();
        testBrake();
    }
}
