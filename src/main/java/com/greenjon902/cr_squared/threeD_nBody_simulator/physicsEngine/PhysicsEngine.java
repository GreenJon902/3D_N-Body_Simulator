package com.greenjon902.cr_squared.threeD_nBody_simulator.physicsEngine;

import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;

public class PhysicsEngine {
    private final ParticleWorld world;

    public PhysicsEngine(ParticleWorld world) {
        this.world = world;
    }

    public ParticleWorld tick() {
        return new ParticleWorld();
    }
}
