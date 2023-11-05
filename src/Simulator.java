public class Simulator {
		AirTrafficControl atc;
		double currentTime;

		public Simulator() {
				currentTime = 0;
				atc = new AirTrafficControl(currentTime);
		}

		public void advanceTime(double increment) {
				atc.incrementTime(increment);
		}

		public void simulate() {
				atc.addAirport(new Airport(10, new Coordinate(30, 30), "Heathrow", "LHR"));
				atc.addAirport(new Airport(5, new Coordinate(-5, -10), "Stansted", "STN"));

				atc.addPlane(new FlyingPlane(0, 0, "A380", "G-XLEA", atc.randomAirport()));
				atc.addPlane(new FlyingPlane(0, 0, "A380", "G-XLEB", atc.randomAirport()));


			while (currentTime < 100) {
						advanceTime(currentTime);

						currentTime += 0.5;
				}
		}
}
