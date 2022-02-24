package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

public class ThreeD_Utils {
    public static float getDistance(Coordinate coordinate1, Coordinate coordinate2) {
       float a1 = coordinate2.getX() - coordinate1.getX();
       float b1 = coordinate2.getY() - coordinate1.getY();
       float c1 = (float) Math.sqrt(Math.pow(a1, 2) + Math.pow(b1, 2));

       float a2 = c1;
       float b2 = coordinate2.getZ() - coordinate1.getZ();
       float c2 = (float) Math.sqrt(Math.pow(a2, 2) + Math.pow(b2, 2));

       return c2;
    }
}
