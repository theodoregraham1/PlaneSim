import java.util.ArrayList;

public class AirTrafficControl {
    private ArrayList<Plane> planes;

    public AirTrafficControl() {
        planes = new ArrayList<>();
    }

    public void addPlane(Plane newPlane) {
        planes.add(newPlane);
    }

    public void addPlane(int x, int y, int v, int theta, String m) {
        planes.add(new Plane(x, y, v, theta, m));
    }

    public boolean willCollide(Plane plane1, Plane plane2) {
        /*

         */
    }
}
