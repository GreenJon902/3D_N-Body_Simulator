package com.greenjon902.cr_squared.threeD_nBody_simulator.structs;

public class Coordinate {
    private final float x;
    private final float y;
    private final float z;

    public Coordinate(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }
}
