package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

public class ThreeD_Utils {
    public static double getDistance(Coordinate coordinate1, Coordinate coordinate2) {
        double a1 = coordinate2.getX() - coordinate1.getX();
        double b1 = coordinate2.getY() - coordinate1.getY();
        double c1 = Math.sqrt(Math.pow(a1, 2) + Math.pow(b1, 2));

        double a2 = c1;
        double b2 = coordinate2.getZ() - coordinate1.getZ();
        double c2 = Math.sqrt(Math.pow(a2, 2) + Math.pow(b2, 2));

       return c2;
    }
}
