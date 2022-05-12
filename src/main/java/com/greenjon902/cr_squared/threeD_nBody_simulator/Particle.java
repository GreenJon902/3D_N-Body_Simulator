package com.greenjon902.cr_squared.threeD_nBody_simulator;

import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Color;
import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

import java.util.Comparator;

public class Particle {
    private final Coordinate coordinates;
    private final double mass;
    private final double radius;
    private final double velocity;
    private final double pitch;
    private final double yaw;
    private final String name;
    private final Color color;

    public Particle(Coordinate coordinates, double mass, double radius, double velocity, double pitch, double yaw) {
        this(coordinates, mass, radius, velocity, pitch, yaw, null, null);
    }

    public Particle(Coordinate coordinates, double mass, double radius, double velocity, double pitch, double yaw, String name) {
        this(coordinates, mass, radius, velocity, pitch, yaw, name, null);
    }

    public Particle(Coordinate coordinates, double mass, double radius, double velocity, double pitch, double yaw, Color color) {
        this(coordinates, mass, radius, velocity, pitch, yaw, null, color);
    }

    public Particle(Coordinate coordinate, double mass, double radius, double velocity, double pitch, double yaw, String name, Color color) {
        this.coordinates = coordinate;
        this.mass = mass;
        this.radius = radius;
        this.velocity = velocity;
        this.pitch = pitch;
        this.yaw = yaw;
        this.name = name;
        this.color = color;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getPitch() {
        return pitch;
    }

    public double getYaw() {
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

    @Override
    public String toString() {
        String string = "Particle(coordinate=" + coordinates + ", mass=" + mass + ", radius=" + radius + ", velocity=" + velocity + ", pitch=" + pitch;
        if (name != null) {
            string += ", name=" + name;
        } else if (color != null) {
            string += ", color=" + color;
        }
        string += ")";
        return string;
    }
}
