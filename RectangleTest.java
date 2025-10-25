
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTest {

	@Test
	void testPerimeter() {
		Point a = new Point(0,0);
		Point b = new Point(5,0);
		Point c = new Point(0,2);
		Point d = new Point(5,2);
		try {
		Rectangle r = new Rectangle(a,b,c,d);
		assertEquals(r.perimeter(),14);
		}catch(Lab5Exception msg)
		{
			assertEquals(msg.message,"Given points do not form an rectangle");
		}
	}
	
	@Test
	void testArea() {
		Point a = new Point(0,0);
		Point b = new Point(5,0);
		Point c = new Point(0,2);
		Point d = new Point(5,2);
		try {
		Rectangle r = new Rectangle(a,b,c,d);
		assertEquals(r.area(),10);
		}catch(Lab5Exception msg)
		{
			assertEquals(msg.message,"Given points do not form an rectangle");
		}
	}
	
	@Test
	void testIsNotSquare() {
		Point a = new Point(0,0);
		Point b = new Point(5,0);
		Point c = new Point(0,2);
		Point d = new Point(5,2);
		try
		{
			Rectangle r = new Rectangle(a,b,c,d);
			assertFalse(r.is_square());
		}catch(Lab5Exception msg)
		{
			assertEquals(msg.message,"Given points do not form an rectangle");
		}
		
	}
	@Test
	void testIsSquare() {
		Point a = new Point(0,0);
		Point b = new Point(5,0);
		Point c = new Point(0,5);
		Point d = new Point(5,5);
		try {
		Rectangle r = new Rectangle(a,b,c,d);
		assertTrue(r.is_square());
		}catch(Lab5Exception msg)
		{
			assertEquals(msg.message,"Given points do not form an rectangle");
		}
	}
	@Test
	void testNotRectangle() {
		Point a = new Point(0,0);
		Point b = new Point(5,0);
		Point c = new Point(0,2);
		Point d = new Point(7,8);
		try{
			Rectangle r = new Rectangle(a,b,c,d);
		}
		catch(Lab5Exception msg)
		{
			assertEquals(msg.message,"Given points do not form an rectangle");
		}
	}
}
