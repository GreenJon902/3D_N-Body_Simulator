package com.greenjon902.cr_squared.threeD_nBody_simulator.structs;

public class Coordinates {
    private final float x;
    private final float y;
    private final float z;

    public Coordinates(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getR() {
        return x;
    }

    public float getG() {
        return y;
    }

    public float getB() {
        return z;
    }
}
