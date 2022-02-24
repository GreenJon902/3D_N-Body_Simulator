package com.greenjon902.cr_squared.threeD_nBody_simulator;

import java.util.ArrayList;

public class ParticleWorld {
    private static final ArrayList<Particle> particles = new ArrayList<Particle>();

    public static Particle[] getParticles() {
        return particles.toArray(new Particle[0]);
    }

    public static Particle getParticle(int id) {
        return particles.get(id);
    }

    public static void addParticle(Particle particle) {
        particles.add(particle);
    }
}
