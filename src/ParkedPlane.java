import java.time.LocalDateTime;

public class ParkedPlane extends Plane{
    private double departureTime;

    public ParkedPlane(double departureTime, FlyingPlane plane) {
        super(plane);

        this.departureTime = departureTime;
    }

    // Getters
    public double getDepartureTime() {
        return departureTime;
    }

    public String toString() {
        return super.toString()
                + ". Will depart at " + departureTime;
    }
}