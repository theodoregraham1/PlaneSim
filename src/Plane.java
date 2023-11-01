import static java.lang.Math.*;

public class Plane {
    private Coordinate position;
    private String model;
    private String registration;

    public Plane(double x, double y, String model, String reg) {
        this.position = new Coordinate(x, y);

        this.model = model;
        this.registration = reg;
    }
    
    public Plane(Coordinate pos, String m, String reg) {
        this(pos.x, pos.y, m, reg);
    }

    public Plane(ParkedPlane parkedPlane) {
        this(parkedPlane.getPosition(), parkedPlane.getModel(), parkedPlane.getRegistration());
    }

    // Getters
    public Coordinate getPosition() {
        return this.position;
    }
    public double getX() {return this.position.x;}
    public double getY() {return this.position.y;}
    public String getModel() {
        return this.model;
    }
    public String getRegistration() {
        return this.registration;
    }



    // Setters
    public void setPosition(Coordinate newPos) {
        this.position = newPos;
    }
    public void setX(int newX) {this.position.x = newX;}
    public void setY(int newY) {this.position.y = newY;}

}
