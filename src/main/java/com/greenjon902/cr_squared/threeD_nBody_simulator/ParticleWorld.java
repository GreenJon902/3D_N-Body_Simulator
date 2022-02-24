package com.greenjon902.cr_squared.threeD_nBody_simulator;

import java.util.ArrayList;

public class ParticleWorld {
    private final ArrayList<Particle> particles;

    public ParticleWorld() {
        particles = new ArrayList<Particle>();
    }

    public Particle[] getParticles() {
        return particles.toArray(new Particle[0]);
    }

    public Particle getParticle(int id) {
        return particles.get(id);
    }

    public void addParticle(Particle particle) {
        particles.add(particle);
    }
}
