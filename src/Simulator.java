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

    }
}
