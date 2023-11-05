public class Plane {
		private Coordinate position;
		private final String model;
		private final String registration;

		// Constructors
		public Plane(double x, double y, String model, String reg) {
				this.position = new Coordinate(x, y);

				this.model = model;
				this.registration = reg;
		}
		public Plane(Coordinate pos, String m, String reg) {
				this(pos.x, pos.y, m, reg);
		}
		public Plane(ParkedPlane parkedPlane) {
				this(parkedPlane.getX(), parkedPlane.getY(), parkedPlane.getModel(), parkedPlane.getRegistration());
		}
		public Plane(FlyingPlane flyingPlane) {
				this(flyingPlane.getX(), flyingPlane.getY(), flyingPlane.getModel(), flyingPlane.getRegistration());
		}
	
		// Getters
		public Coordinate getPosition() {
				return this.position;
		}
		public double getX() {return this.position.x;}
		public double getY() {return this.position.y;}
		public String getModel() {
				return this.model;
		}
		public String getRegistration() {
				return this.registration;
		}

		// Setters
		public void setPosition(Coordinate newPos) {
				this.position = newPos;
		}
		public void setX(int newX) {this.position.x = newX;}
		public void setY(int newY) {this.position.y = newY;}

		public String toString() {
				return "Plane: " + registration
								+ " of model " + model
								+ " at position " + position.toString();
		}
}
