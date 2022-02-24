package com.greenjon902.cr_squared.threeD_nBody_simulator;

import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Color;
import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

public class Particle {
    private final Coordinate coordinates;
    private final float mass;
    private final float radius;
    private final float velocity;
    private final float pitch;
    private final float yaw;
    private final String name;
    private final Color color;

    public Particle(Coordinate coordinates, float mass, float radius, float velocity, float pitch, float yaw) {
        this(coordinates, mass, radius, velocity, pitch, yaw, null, null);
    }

    public Particle(Coordinate coordinates, float mass, float radius, float velocity, float pitch, float yaw, String name) {
        this(coordinates, mass, radius, velocity, pitch, yaw, name, null);
    }

    public Particle(Coordinate coordinates, float mass, float radius, float velocity, float pitch, float yaw, Color color) {
        this(coordinates, mass, radius, velocity, pitch, yaw, null, color);
    }

    public Particle(Coordinate coordinate, float mass, float radius, float velocity, float pitch, float yaw, String name, Color color) {
        this.coordinates = coordinate;
        this.mass = mass;
        this.radius = radius;
        this.velocity = velocity;
        this.pitch = pitch;
        this.yaw = yaw;
        this.name = name;
        this.color = color;
    }

    public float getMass() {
        return mass;
    }

    public float getRadius() {
        return radius;
    }

    public float getVelocity() {
        return velocity;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }
}
