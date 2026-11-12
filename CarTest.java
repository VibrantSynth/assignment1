import java.awt.*;

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
        String result = northSaab.direction;
        IO.println("Car facing: "+result);
    }

    private static void checkPosition() {
        Volvo240 movingCar = new Volvo240();
        movingCar.gas(1);
        movingCar.move(); // i'm on the move
        movingCar.move();
        movingCar.move();
        movingCar.move();
        movingCar.brake(1);
        movingCar.turnLeft(); // i'm on the turn
        movingCar.gas(0.5);
        movingCar.move();
        movingCar.move();
        movingCar.move();
        movingCar.move();
        movingCar.move();
        movingCar.move();
        movingCar.move();
        movingCar.move();
        movingCar.move();
        movingCar.move();
        movingCar.move();
        movingCar.move();
        IO.println("Car position: ("+movingCar.x_coordinate+", "+movingCar.y_coordinate+")");
    }

    static void main() {
        testTurbo();
        checkDirection();
        checkPosition();
        //TODO: add and run more tests
    }
}
