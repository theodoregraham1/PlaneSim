import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Simulator {
    public static final String PLANES_FILE = "./src/data/planes.csv";
    public static final String AIRPORTS_FILE = "./src/data/airports.csv";
	public static final String COMMA = ",";

	public static final double TIME_INCREMENT = 0.5;
    AirTrafficControl atc;
    double currentTime;

    public Simulator() {
        currentTime = 0;
        atc = new AirTrafficControl(currentTime);
        this.readCSVsIn(atc);
    }

    public void readCSVsIn(AirTrafficControl atc) {
        // Read in airports
        try (BufferedReader reader = new BufferedReader(new FileReader(AIRPORTS_FILE))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(COMMA);

                atc.addAirport(new Airport(
                        Integer.parseInt(values[0]),
                        new Coordinate(Double.parseDouble(values[1]), Double.parseDouble(values[2])),
                        values[3],
                        values[4]
                ));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

		// Read in planes
		try (BufferedReader reader = new BufferedReader(new FileReader(PLANES_FILE))) {
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(COMMA);

				atc.addPlane(new FlyingPlane(
                        values[0],
                        values[1],
                        Double.parseDouble(values[2]),
                        Double.parseDouble(values[3]),
                        atc.randomAirport()
                ));
			}
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void advanceTime(double increment) {
        atc.incrementTime(increment);
    }

    public void simulate() {
        while (currentTime < 30) {
            advanceTime(TIME_INCREMENT);
            currentTime += TIME_INCREMENT;
        }
    }
}
