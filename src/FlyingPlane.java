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

        this.setFlightDetails(destination);
    }
    public FlyingPlane(String model, String reg, double x, double y, Airport destination) {
      super(x, y, model, reg);

      this.setFlightDetails(destination);
    }
  
    public void setFlightDetails(Airport destination) {
          this.destination = destination;
          this.speed = DEFAULT_SPEED;

          this.direction = findBearing(destination.getPosition());
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
        if (Double.compare(pos.x, this.getX()) == 0
                && Double.compare(pos.y, this.getY() )== 0) {
            return 0;
        }

        double velocityX = this.speed * sin(toRadians(this.direction));
        double velocityY = this.speed * cos(toRadians(this.direction));

        double displacementX = abs(this.getX() - pos.x);
        double displacementY = abs(this.getY() - pos.y);

        double timeX = displacementX / velocityX;
        double timeY = displacementY / velocityY;

        if (timeX == timeY) {
            return timeX;
        }
        if (Double.isNaN(timeX)) {
            if (timeY == Double.NaN) {
                return 0;
            }
            return timeY;
        }
        if (timeY == Double.NaN) {
            return timeX;
        }
        return -1;
    }

    public double findBearing(Coordinate coordinate) {
        // Find displacement
        double displacementX = coordinate.x - this.getX();
        double displacementY = coordinate.y - this.getY();

        // Find the angle to the vertical
        double ratio = displacementX / displacementY;
        double angle = toDegrees(atan(ratio));

        // Determine which quadrant the bearing is in and change it accordingly
        if (displacementX < 0) {
            if (displacementY > 0) {
                return angle + 270; // Move into the second quadrant
            }
            return angle + 180; // Move into the last quadrant

        } else if (displacementY < 0) {
            return angle + 90;
        }
        return angle;
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
        return super.toBasicString()
                + ", with velocity of " + this.speed
                + " with bearing " + this.direction
                + " with destination " + this.destination.getName();
    }
}


