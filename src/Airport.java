import java.time.LocalDateTime;

public class Airport {
    private ParkedPlane[] planes;

    public Airport(int numberOfStands) {
        planes = new ParkedPlane[numberOfStands];
    }

    // Getters
    public Plane getPlane(int index) {
        if (index < planes.length)
            return planes[index];
        return null;
    }
    public Plane[] getPlanes() {
        return planes;
    }

    // Setters
    public void addPlane(ParkedPlane newPlane) {
        int i=0;
        while (planes[i] != null && i < planes.length) {
            i++;
        }
        planes[i] = newPlane;
    }
}
