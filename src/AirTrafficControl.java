import java.util.ArrayList;

public class AirTrafficControl {
    private ArrayList<FlyingPlane> planes;
    private ArrayList<Airport> airports;

    public AirTrafficControl() {
        planes = new ArrayList<>();
    }

    public void addPlane(FlyingPlane newPlane) {
        planes.add(newPlane);
    }

    public void addPlane(int x, int y, int v, String model, String reg) {
        planes.add(new FlyingPlane(x, y, model, reg));
    }
}
