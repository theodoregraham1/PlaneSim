import java.time.LocalDateTime;

public class ParkedPlane extends Plane{
    LocalDateTime departureTime;
    int standNumber;

    public ParkedPlane(LocalDateTime departureTime, int standNumber, FlyingPlane plane) {
        super(plane);

        this.departureTime = departureTime;
        this.standNumber = standNumber;
    }
}