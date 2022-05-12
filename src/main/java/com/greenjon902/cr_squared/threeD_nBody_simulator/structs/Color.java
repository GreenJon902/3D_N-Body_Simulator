package com.greenjon902.cr_squared.threeD_nBody_simulator.structs;

public class Color {
    private final double r;
    private final double g;
    private final double b;

    public Color(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public double getR() {
        return r;
    }

    public double getG() {
        return g;
    }

    public double getB() {
        return b;
    }

    public java.awt.Color toAwtColor() {
        return new java.awt.Color((int) r, (int) g, (int) b);
    }
}
