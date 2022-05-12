package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

public class AngleFixer {
    public static Double fix(double angle) {
        while (!(-180 <= angle && angle <= 180)) {
            if (angle < -180) {
                angle = 180 + (angle + 180);
            } else {
                angle = -180 + (angle - 180);
            }
        }
        return angle;
    }
}
