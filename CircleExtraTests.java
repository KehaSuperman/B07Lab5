import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircleExtraTests {

    @Test
    void circleConstructorShouldRetainInputs() {
        Point origin = new Point(5, -3);
        Circle c = new Circle(origin, 10.5);
        assertEquals(origin, c.centre, "Expected Circle to remember the exact Point object passed.");
        assertEquals(10.5, c.radius, 1e-9, "Radius value stored incorrectly.");
    }

    @Test
    void circumferenceShouldBeZeroWhenRadiusIsZero() {
        Circle flat = new Circle(new Point(0, 0), 0);
        assertEquals(0.0, flat.circumference(), 1e-9, "A radius of zero should yield a circumference of zero!");
    }

    @Test
    void areaShouldVanishWhenRadiusIsZero() {
        Circle dot = new Circle(new Point(0, 0), 0);
        assertEquals(0.0, dot.area(), 1e-9, "A zero-radius circle has no area!");
    }

    @Test
    void circumferenceWithDecimalRadiusShouldBeAccurate() {
        Circle c = new Circle(new Point(0, 0), 1.23456789);
        double expected = 2 * Math.PI * 1.23456789;
        assertEquals(expected, c.circumference(), 1e-9, "Circumference() lost precision for non-integer radius.");
    }

    @Test
    void areaWithDecimalRadiusShouldStayMathematicallyConsistent() {
        Circle c = new Circle(new Point(0, 0), 1.23456789);
        double expected = Math.PI * Math.pow(1.23456789, 2);
        assertEquals(expected, c.area(), 1e-9, "Area formula slightly off when using a floating-point radius.");
    }

    @Test
    void isOnCircleShouldFailDueToTinyFloatingError() {
        Circle c = new Circle(new Point(0, 0), 5);
        Point p = new Point(5.0000000001, 0);
        assertFalse(c.isOnCircle(p), "The equality check is too strict — floating-point rounding causes this to fail.");
    }

    @Test
    void isOnCircleShouldBeTrueForPerfectMatch() {
        Circle c = new Circle(new Point(2, 3), 5);
        Point p = new Point(7, 3); // exactly 5 units away
        assertTrue(c.isOnCircle(p), "A point exactly radius-distance away should be recognized as lying on the circle.");
    }

    @Test
    void pointInsideCircleShouldNotBeOnCircle() {
        Circle c = new Circle(new Point(0, 0), 5);
        Point inner = new Point(3, 0);
        assertFalse(c.isOnCircle(inner), "A point well inside the circle shouldn't be treated as being on the boundary.");
    }

    @Test
    void pointOutsideCircleShouldNotFoolTheCheck() {
        Circle c = new Circle(new Point(0, 0), 5);
        Point outer = new Point(6, 0);
        assertFalse(c.isOnCircle(outer), "Point lies outside — should return false for being 'on' the circle.");
    }

    @Test
    void negativeRadiusShouldBehaveMathematicallyEvenIfIllogical() {
        Circle c = new Circle(new Point(0, 0), -5);
        assertEquals(-5, c.radius, "The Circle class doesn’t block negative radii, so should store it as-is.");
        assertEquals(-10 * Math.PI, c.circumference(), 1e-9, "Negative radius produces a negative circumference mathematically, though not physically meaningful.");
    }

    @Test
    void circlesWithSameRadiusDifferentCentersShouldNotBeConsideredIdentical() {
        Circle c1 = new Circle(new Point(0, 0), 3);
        Circle c2 = new Circle(new Point(1, 1), 3);
        assertNotEquals(c1.centre, c2.centre, "Centers differ, so these circles occupy different positions in space.");
        assertEquals(c1.radius, c2.radius, "Radii are identical — both have equal size.");
    }

    @Test
    void massiveRadiusShouldStillComputeWithoutOverflow() {
        Circle huge = new Circle(new Point(0, 0), 1_000_000);
        double expectedCirc = 2 * Math.PI * 1_000_000;
        double expectedArea = Math.PI * Math.pow(1_000_000, 2);
        assertEquals(expectedCirc, huge.circumference(), 1e-5, "Circumference fails on large circle.");
        assertEquals(expectedArea, huge.area(), 1e-5, "Area should still calculate correctly for very large radii.");
    }
}
