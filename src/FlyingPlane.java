import static java.lang.Math.*;

public class FlyingPlane extends Plane {
    // Velocity in m/s
    public static final double DEFAULT_SPEED = 10;
    private double speed;

    // Angle from North in degrees
    private double direction;

    private Airport destination;

    // Constructors
    public FlyingPlane(ParkedPlane parkedPlane, Airport destination) {
        super(parkedPlane);
        this.destination = destination;

        this.direction = findBearing(destination.getPosition());
        this.speed = DEFAULT_SPEED;
    }
    public FlyingPlane(double x, double y, String model, String reg, Airport destination) {
      super(x, y, model, reg)

      this.setFlightDetails(destination);
    }
  
    public void setFlightDetails() {
          
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

    public double findBearing(Coordinate coordinate) {
        double displacementX = this.getX() - coordinate.x;
        double displacementY = this.getX() - coordinate.y;

        return toDegrees(atan(displacementX / displacementY));
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

    public String toString() {
        return super.toString()
                + ", with velocity of " + this.speed
                + " with bearing " + this.direction;
    }
}


