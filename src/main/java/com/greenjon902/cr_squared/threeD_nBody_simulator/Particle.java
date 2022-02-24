package com.greenjon902.cr_squared.threeD_nBody_simulator;

import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Color;

public class Particle {
    private final float mass;
    private final float radius;
    private final float velocity;
    private final float pitch;
    private final float yaw;
    private final String name;
    private final Color color;

    public Particle(float mass, float radius, float velocity, float pitch, float yaw) {
        this(mass, radius, velocity, pitch, yaw, null, null);
    }

    public Particle(float mass, float radius, float velocity, float pitch, float yaw, String name) {
        this(mass, radius, velocity, pitch, yaw, name, null);
    }

    public Particle(float mass, float radius, float velocity, float pitch, float yaw, Color color) {
        this(mass, radius, velocity, pitch, yaw, null, color);
    }

    public Particle(float mass, float radius, float velocity, float pitch, float yaw, String name, Color color) {
        this.mass = mass;
        this.radius = radius;
        this.velocity = velocity;
        this.pitch = pitch;
        this.yaw = yaw;
        this.name = name;
        this.color = color;
    }
}
