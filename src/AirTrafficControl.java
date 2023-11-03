import java.util.ArrayList;
import java.util.Random;

public class AirTrafficControl {
    private final ArrayList<FlyingPlane> planesInAir;
    private final ArrayList<Airport> airports;
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

    public void addPlane(FlyingPlane newPlane) {
        planesInAir.add(newPlane);
    }

    public void landPlane(FlyingPlane plane, Airport airport) {
        ParkedPlane landedPlane = new ParkedPlane(this.currentTime+10, plane);
        landedPlane.setPosition(airport.getPosition());
        airport.addPlane(landedPlane);
    }

    public void incrementTime(double increment) {
        currentTime += increment;

        // Move flying planes
        for (FlyingPlane p: planesInAir) {
            if (p.ETA(p.getDestination().getPosition()) < increment) {
                landPlane(p, p.getDestination());
            }
            else {
                p.setPosition(p.futurePosition(increment));
            }
        }

        // Work out which planes are taking off
        for (Airport a: airports) {
            ArrayList<ParkedPlane> departures = a.checkDepartures(currentTime);

            // Randomise destinations of planes
            for (ParkedPlane p: departures) {
                planesInAir.add(new FlyingPlane(
                        p,
                        randomAirport()
                ));
            }
        }
    }

    private Airport randomAirport() {
        return airports.get(random.nextInt(airports.size()));
    }

    public String toString() {
      StringBuilder output = new StringBuilder();

      output.append("========= Air Traffic Control =========\n");
      output.append("Time ").append(this.currentTime);
      
      output.append("*-------- Airports --------*");
      for (Airport a: airports) {
        output.append(a.toString());
      }

      output.append("*-------- Planes in air --------*");
      for (FlyingPlane p: this.planesInAir) {
        output.append(p.toString());
      }

      return output.toString();
    }
}
