package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

public class Camera {
    private final Coordinate coordinate;
    private final double pitch;
    private final double yaw;

    public Camera(Coordinate coordinate, double pitch, double yaw) {
        this.coordinate = coordinate;
        this.pitch = pitch;
        this.yaw = yaw;
    }


    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getPitch() {
        return pitch;
    }

    public double getYaw() {
        return yaw;
    }
}
