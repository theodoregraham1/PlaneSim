import static java.lang.Math.*;

public class FlyingPlane extends Plane {

    // Velocity in m/s
    private double speed;

    // Angle from North in degrees
    private double direction;
    private Airport destination;

    // Constructors
    public FlyingPlane(ParkedPlane parkedPlane, Airport destination) {
        super(parkedPlane);
        this.destination = destination;
    }
    public FlyingPlane(Plane plane, Airport destination) {
        super(plane.getX(), plane.getY(), plane.getModel(), plane.getRegistration());
        this.destination = destination;
    }
    public FlyingPlane(double x,
                       double y,
                       String model,
                       String reg,
                       Airport destination) {
        super(x, y, model, reg);
        this.destination = destination;
    }

    public Coordinate futurePosition(double time) {
        double velocityX = this.speed * sin(toRadians(this.direction));
        double velocityY = this.speed * cos(toRadians(this.direction));

        return new Coordinate(
                this.getX() + (velocityX * time),
                this.getY() + (velocityY * time));
    }

    public double ETA(Coordinate pos) {
        // Returns the time when the plane will reach pos, if it will never reach pos it will be -1

        double velocityX = this.speed * sin(toRadians(this.direction));
        double velocityY = this.speed * cos(toRadians(this.direction));

        double displacementX = this.getX() - pos.x;
        double displacementY = this.getX() - pos.y;

        double timeX = displacementX / velocityX;
        double timeY = displacementY/ velocityY;

        if (timeX == timeY) {
            return timeX;
        }
        return timeY;
    }

    // Getters
    public double getSpeed() {
        return this.speed;
    }
    public double getDirection() {
        return this.direction;
    }
    public Airport getDestination() {
        return this.destination;
    }

    // Setters
    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
    public void setDirection(int newDirection) {
        this.direction = newDirection;
    }
}


