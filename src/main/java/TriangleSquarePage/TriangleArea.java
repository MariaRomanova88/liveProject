package TriangleSquarePage;

public class TriangleArea {

    public static double calculate(double a, double b, double c) {
        double pp = (a + b + c) / 2D;  // полупериметр
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c)); // формулa Герона

    }

}