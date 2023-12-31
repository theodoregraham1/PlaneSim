import java.util.ArrayList;
import java.util.Random;

public class AirTrafficControl {
    private ArrayList<FlyingPlane> planesInAir;
    private ArrayList<Airport> airports;
    double currentTime;
    Random random;

    public AirTrafficControl(
            ArrayList<FlyingPlane> planesInAir,
            ArrayList<Airport> airports,
            double currentTime
    ) {
        this.currentTime = currentTime;
        this.planesInAir = planesInAir;
        this.airports = airports;
        this.random = new Random();
    }

    public AirTrafficControl(double currentTime) {
        this(
                new ArrayList<>(),
                new ArrayList<>(),
                currentTime
        );
    }

    public void addAirport(Airport airport) {
        airports.add(airport);
        System.out.println("Added " + airport.toString());
    }

    public void addPlane(FlyingPlane newPlane) {
        planesInAir.add(newPlane);
        System.out.println("Added " + newPlane.toString());
    }

    public void landPlane(FlyingPlane plane, Airport airport) {
        planesInAir.remove(plane);

        ParkedPlane landedPlane = new ParkedPlane(this.currentTime+10, plane);
        landedPlane.setPosition(airport.getPosition());
        airport.addPlane(landedPlane);

        System.out.println(plane.getRegistration() + " landed at " + airport.getName()
                + ". It will take off at " + landedPlane.getDepartureTime());
    }

    public void incrementTime(double increment) {
        System.out.println(this.toString());
        currentTime += increment;

        // Move flying planes
        for (int i=0; i<planesInAir.size(); i++) {
            FlyingPlane p = planesInAir.get(i);

            // Land planes that are close enough
            double eta = p.ETA(p.getDestination().getPosition());
            if (eta < increment && eta != -1) {
                landPlane(p, p.getDestination());
            }

            // Move all others
            else {
                p.setPosition(p.futurePosition(increment));
            }
        }

        // Work out which planes are taking off
        for (Airport a: airports) {
            ArrayList<ParkedPlane> departures = a.checkDepartures(currentTime);

            // Randomise destinations of planes
            for (ParkedPlane p: departures) {
                addPlane(new FlyingPlane(p, this.randomAirport()));
            }
        }
    }

    public Airport randomAirport() {
        return airports.get(random.nextInt(airports.size()));
    }

    public void sortPlanes() {
        // Sort planes by IATA code

        int i = 0, smallest_index;

        while (i < planesInAir.size()) {
            smallest_index = i;
            for (int j=i; j< planesInAir.size(); j++) {
                if (planesInAir.get(j).getRegistration().compareTo(
                        planesInAir.get(smallest_index).getRegistration()) < 0) {
                    smallest_index = j;
                }
            }
            if (smallest_index != i) {
                // Put the lowest registration plane into new position
                FlyingPlane placeHolder = planesInAir.get(smallest_index);
                planesInAir.set(smallest_index, planesInAir.get(i));
                planesInAir.set(i, placeHolder);
            }
            i++;
        }
    }

    public String toString() {
      StringBuilder output = new StringBuilder();

      output.append("\n========= Air Traffic Control =========\n");
      output.append("Time ").append(this.currentTime).append("\n");
      
      output.append("*-------- Airports --------*\n");
      for (Airport a: airports) {
        output.append(a.toString()).append("\n");
      }

      output.append("*-------- Planes in air --------*\n");
      for (FlyingPlane p: this.planesInAir) {
        output.append(p.toString()+"\n");
      }

      return output.toString();
    }
}
