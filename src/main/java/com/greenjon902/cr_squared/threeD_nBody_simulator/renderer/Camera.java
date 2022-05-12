package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

public class Camera {
    private Coordinate coordinate;
    private double pitch;
    private double yaw;
    private double fov;

    public Camera(Coordinate coordinate, double pitch, double yaw, double fov) {
        this.coordinate = coordinate;
        this.pitch = AngleFixer.fix(pitch);
        this.yaw = AngleFixer.fix(yaw);
        this.fov = fov;
    }

    public Camera(Coordinate coordinate, double pitch, double yaw) {
        this(coordinate, pitch, yaw, 90);
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

    public double getFov() {
        return fov;
    }

    public void setYaw(double yaw) {
        this.yaw = AngleFixer.fix(yaw);
    }

    public void setPitch(double pitch) {
        this.pitch = AngleFixer.fix(pitch);
    }
}
