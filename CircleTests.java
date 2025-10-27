import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircleTests{

	@Test
	void testCircumference() {
	Point centre = new Point(0,0);
	Circle c = new Circle(centre, 2);
	assertEquals(c.circumference(), 4 * Math.PI);
	}
	
	@Test
	void testArea() {
	Point centre = new Point(0,0);
	Circle c = new Circle(centre, 2);
	assertEquals(c.area(), 4 * Math.PI);
	}
	
	@Test
	void testOnCircleTrue(){
	Point centre= new Point(1,0);
	Point p = new Point(3,0);
	Circle c = new Circle(centre, 2);
	assertTrue(c.isOnCircle(p));
	}

	@Test
	void testOnCircleFalse(){
	Point centre = new Point(1,0);
	Point p = new Point(3,0);
	Circle c = new Circle(centre, 3);
	assertFalse(c.isOnCircle(p));
	}


}
