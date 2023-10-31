import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

public class Plane {
    private Coordinate position;

    // Velocity in m/s
    private int speed;

    // Angle from North in degrees
    private int direction;

    private String model;

    public Plane(int x, int y, int v, int theta, String m) {
        this.position = new Coordinate(x, y);

        this.speed = v;
        this.direction = theta;
        this.model = m;
    }
    
    public Plane(int[] pos, int v, int theta, String m) {
        this(pos[0], pos[1], v, theta, String m);
    }

    public Coordinate futurePosition(int time) {
        double velocityH = this.speed * sin(toRadians(direction));
    }

    // Getters
    public Coordinate getPosition() {
        return this.position;
    }
    public int getSpeed() {
        return this.speed;
    }
    public int getDirection() {
        return this.direction;
    }
    public String getModel() {
        return this.model;
    }


    // Setters
    public void setPosition(Coordinate newPos) {
        this.position = newPos;
    }
    public void setX(int newX) {this.position.x = newX;}
    public void setY(int newY) {this.position.y = newY;}
    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
    public void setDirection(int newDirection) {
        this.direction = newDirection;
    }
}
