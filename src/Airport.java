import java.util.ArrayList;

public class Airport {
    private final String name;
    private final String IATACode;

    private final ParkedPlane[] planes;
    private final Coordinate position;

    public Airport(int numberOfStands, Coordinate position, String name, String IATACode) {
        this.planes = new ParkedPlane[numberOfStands];
        this.position = position;

        this.name = name;
        this.IATACode = IATACode;
    }

    public ParkedPlane launchPlane(int standNumber) {
        // Make new plane
        ParkedPlane departure = planes[standNumber];

        // Remove old one
        planes[standNumber] = null;

        return departure;
    }

    public ArrayList<ParkedPlane> checkDepartures(double currentTime) {
        ArrayList<ParkedPlane> departures = new ArrayList<>();

        for (int i=0; i<planes.length; i++) {
            if (planes[i].getDepartureTime() >= currentTime) {
                departures.add(launchPlane(i));
            }
        }

        return departures;
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
    public Coordinate getPosition() {
        return this.position;
    }

    // Setters
    public void addPlane(ParkedPlane newPlane) {
        // Find an 'empty stand' for the plane to go in
        int i=0;
        while (planes[i] != null && i < planes.length) {
            i++;
        }

        // Add plane
        planes[i] = newPlane;
    }

    public String toString() {
        StringBuilder output = new StringBuilder;

        output.append("Airport: ").append(this.name);
        output.append(" ").append(this.IATACode);
        output.append("\n Planes: \n")
        
        for (ParkedPlane p: this.planes) {
            StringBuilder.append(p.toString()).append("\n");
        }
        return output;
    }
}
