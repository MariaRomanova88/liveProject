package TriangleSquareTest;

import TriangleSquarePage.TriangleArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static java.lang.Math.sqrt;

public class TriangleAreaTests {

    @Test
    void rightTriangle() {
        double area = TriangleArea.calculate(3D, 4D, 5D);
        Assertions.assertEquals(6D, area);
    }

    @Test
    void isoscelesTriangle() {
        double area = TriangleArea.calculate(2D, 2D, 2D);
        // площадь равностороннего треугольника со стороной 2 равна 3 ^ (1 / 2)
        Assertions.assertEquals(sqrt(3D), area);
    }

}