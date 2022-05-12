package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.Particle;
import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;
import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Renderer extends JPanel {
    private final ParticleWorld particleWorld;
    private final Camera camera;

    public Renderer(ParticleWorld particleWorld, Camera camera) {
        this.particleWorld = particleWorld;
        this.camera = camera;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Particle[] particles = particleWorld.getParticles();
        particles = ThreeD_Utils.sortParticlesOnDistanceFromCoordinate(particles, camera.getCoordinate());

        for (Particle particle : particles) {
            // get xy plane angle
            double rx = particle.getCoordinates().getX() - camera.getCoordinate().getX();
            double ry = particle.getCoordinates().getY() - camera.getCoordinate().getY();
            double xy_angle = Math.toDegrees(Math.atan(ry/rx)) - camera.getYaw();
            int screen_x = (int) ((xy_angle + camera.getFov() / 2) / camera.getFov() * getWidth());

            // get xz plane angle
            rx = particle.getCoordinates().getX() - camera.getCoordinate().getX();
            double rz = particle.getCoordinates().getZ() - camera.getCoordinate().getZ();
            double xz_angle = Math.toDegrees(Math.atan(rz/rx)) - camera.getPitch();
            int screen_y = (int) ((xz_angle + camera.getFov() / 2) / camera.getFov() * getHeight());

            g.drawOval( screen_x, screen_y, 10, 10);
        }
    }
}