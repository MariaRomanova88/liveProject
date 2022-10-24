package TrianglePage;

public class TriangleArea {

    public static double calculate(int a, int b, int c) {
        double pp = (a + b + c) / 2.0;  // полупериметр
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c)); // формулa Герона

    }

}