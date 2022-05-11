package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

public class Camera {
    private final Coordinate coordinate;
    private final float pitch;
    private final float yaw;

    public Camera(Coordinate coordinate, float pitch, float yaw) {
        this.coordinate = coordinate;
        this.pitch = pitch;
        this.yaw = yaw;
    }
}
