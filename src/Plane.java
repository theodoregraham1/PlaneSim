public class Plane {
    private int[] position;

    // Velocity in m/s
    private int speed;

    // Angle from North in degrees
    private int direction;

    private String model;

    public Plane(int x, int y, int v, int theta, String m) {
        this.position = new int[2];
        this.position[0] = x;
        this.position[1] = y;

        this.speed = v;
        this.direction = theta;
        this.model = m;
    }
    
    public Plane(int[] pos, int v, int theta, String m) {
        this(pos[0], pos[1], v, theta, String m);
    }

    // Getters
    public int[] getPosition() {
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
    public void setPosition(int[] newPos) {
        this.position = newPos;
    }
    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
    public void setDirection(int newDirection) {
        this.direction = newDirection;
    }
}
