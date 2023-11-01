import java.lang.reflect.Parameter;

import static java.lang.Math.*;
import static java.lang.Math.toRadians;

public class FlyingPlane extends Plane {

    // Velocity in m/s
    private int speed;

    // Angle from North in degrees
    private int direction;

    // Constructors
    public FlyingPlane(ParkedPlane parkedPlane) {
        super(parkedPlane);
    }
    public FlyingPlane(double x, double y, String model, String reg) {
        super(x, y, model, reg);
    }

    public Coordinate futurePosition(int time) {
        double velocityX = this.speed * sin(toRadians(this.direction));
        double velocityY = this.speed * cos(toRadians(this.direction));

        return new Coordinate(
                this.getX() * velocityX,
                this.getY() * velocityY);
    }

    public double ETA(Coordinate pos) {
        // Returns the time when the plane will reach pos, if it will never reach pos it will be -1

        double velocityX = this.speed * sin(toRadians(this.direction));
        double velocityY = this.speed * cos(toRadians(this.direction));

        double displacementX = this.getX() - pos.x;
        double displacementY = this.getX() - pos.y;


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


