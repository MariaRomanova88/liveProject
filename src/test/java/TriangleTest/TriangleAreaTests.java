package TriangleTest;

import TrianglePage.TriangleArea;
import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleAreaTests {

    @Test
    void rightTriangle() {
        double area = TriangleArea.calculate(3D, 4D, 5D);
        assertEquals(6D, area);
    }

    @Test
    void isoscelesTriangle() {
        double area = TriangleArea.calculate(2D, 2D, 2D);
        // площадь равностороннего треугольника со стороной 2 равна 3 ^ (1 / 2)
        assertEquals(sqrt(3D), area);
    }

}