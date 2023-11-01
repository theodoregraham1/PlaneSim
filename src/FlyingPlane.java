import java.lang.reflect.Parameter;

import static java.lang.Math.*;
import static java.lang.Math.toRadians;

public class FlyingPlane extends Plane {

    // Velocity in m/s
    private int speed;

    // Angle from North in degrees
    private int direction;

    public FlyingPlane(ParkedPlane) {
        super(ParkedPlane);
    }

    public Coordinate futurePosition(int time) {
        double velocityX = this.speed * sin(toRadians(this.direction));
        double velocityY = this.speed * cos(toRadians(this.direction));

        Coordinate newPos = this.position = new Coordinate(
                this.getX() * velocityX,
                this.getY() * velocityY);

        return newPos;
    }

    // Getters
    public int getSpeed() {
        return this.speed;
    }
    public int getDirection() {
        return this.direction;
    }

    // Setters
    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
    public void setDirection(int newDirection) {
        this.direction = newDirection;
    }
}


