public class Circle {
	Point centre;
	double radius;
	
	public Circle(Point centre, double radius) {
		this.centre = centre;
		this.radius = radius;
	}
	
	public double circumference() {
		return 2 * this.radius * Math.PI;
	}

	public double area() {
		return Math.PI * (Math.pow(this.radius, 2));
	}

	public boolean isOnCircle(Point P) {
		return radius == centre.distance(P);
	}
}