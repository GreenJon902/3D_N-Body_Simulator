package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.Particle;
import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

import java.util.ArrayList;

public class Utils {
    public static double getDistance(Coordinate coordinate1, Coordinate coordinate2) {
        double a1 = coordinate2.getX() - coordinate1.getX();
        double b1 = coordinate2.getY() - coordinate1.getY();
        double c1 = Math.sqrt(Math.pow(a1, 2) + Math.pow(b1, 2));

        double a2 = c1;
        double b2 = coordinate2.getZ() - coordinate1.getZ();
        double c2 = Math.sqrt(Math.pow(a2, 2) + Math.pow(b2, 2));

       return c2;
    }

    public static Particle[] sortParticlesOnDistanceFromCoordinate(Particle[] particles, Coordinate coordinate) {
        ArrayList<Particle> sorted = new ArrayList<>();
        for (Particle particle : particles) {
            int i = 0;
            if (sorted.isEmpty()) {
                sorted.add(particle);
            } else {
                for (Particle other : sorted) {
                    if (getDistance(other.getCoordinates(), coordinate) >= getDistance(particle.getCoordinates(), coordinate)) {
                        sorted.add(i, particle);
                        break;
                    }
                    i += 1;
                }
            }
        }

        Particle[] flipped = new Particle[sorted.size()];
        for (int i = 0; i < sorted.size(); i++) {
            flipped[i] = sorted.get(sorted.size() - 1 - i);
        }

        return flipped;
    }
}
