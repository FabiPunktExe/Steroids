package de.fabiexe.steroids.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VectorTest {
    @Test
    public void testAdd() {
        Vector vector = new Vector(1, 2, 3);
        Vector other = new Vector(4, 5, 6);
        Vector result = vector.add(other);

        Assertions.assertEquals(5, result.x());
        Assertions.assertEquals(7, result.y());
        Assertions.assertEquals(9, result.z());
    }

    @Test
    public void testSubtract() {
        Vector vector = new Vector(1, 2, 3);
        Vector other = new Vector(4, 5, 6);
        Vector result = vector.subtract(other);

        Assertions.assertEquals(-3, result.x());
        Assertions.assertEquals(-3, result.y());
        Assertions.assertEquals(-3, result.z());
    }

    @Test
    public void testMultiply() {
        Vector vector = new Vector(1, 2, 3);
        Vector result = vector.multiply(2);

        Assertions.assertEquals(2, result.x());
        Assertions.assertEquals(4, result.y());
        Assertions.assertEquals(6, result.z());
    }

    @Test
    public void testDivide() {
        Vector vector = new Vector(1, 2, 3);
        Vector result = vector.divide(2);

        Assertions.assertEquals(0.5, result.x());
        Assertions.assertEquals(1, result.y());
        Assertions.assertEquals(1.5, result.z());
    }

    @Test
    public void testClone() {
        Vector vector = new Vector(1, 2, 3);
        Vector clone = vector.clone();

        Assertions.assertEquals(vector.x(), clone.x());
        Assertions.assertEquals(vector.y(), clone.y());
        Assertions.assertEquals(vector.z(), clone.z());
    }
}
