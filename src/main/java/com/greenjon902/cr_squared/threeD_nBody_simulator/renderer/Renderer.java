package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.Particle;
import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;
import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

import javax.swing.*;
import java.awt.*;

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
        particles = Utils.sortParticlesOnDistanceFromCoordinate(particles, camera.getCoordinate());

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

            if (particle.getColor() != null) {
                g.setColor(particle.getColor().toAwtColor());
            } else {
                g.setColor(Color.black);
            }

            // get size by making a line that is at the edge of its radius
            double radius_calculator_x = 0;
            double radius_calculator_y = 0;
            double radius_calculator_z = particle.getRadius();
            radius_calculator_x = Math.cos(Math.toRadians(camera.getPitch())) * radius_calculator_z;
            radius_calculator_z = Math.sin(Math.toRadians(camera.getPitch())) * radius_calculator_z;

            radius_calculator_y = Math.sin(Math.toRadians(camera.getYaw())) * radius_calculator_x;
            radius_calculator_x = Math.cos(Math.toRadians(camera.getYaw())) * radius_calculator_x;
            int radiusDistance = (int) Utils.getDistance(camera.getCoordinate(), new Coordinate(radius_calculator_x, radius_calculator_y, radius_calculator_z));
            int particleDistance = (int) Utils.getDistance(camera.getCoordinate(), particle.getCoordinates());
            int radius = (int) Math.sqrt(radiusDistance * radiusDistance - particleDistance * particleDistance);

            g.fillOval(screen_x - radius, screen_y - radius, radius * 2, radius * 2);
            g.setColor(Color.black);
            g.drawLine(screen_x, screen_y, screen_x, screen_y + radius);
        }
    }
}