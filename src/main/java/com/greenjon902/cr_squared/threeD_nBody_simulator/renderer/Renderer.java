package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.Particle;
import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;
import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class Renderer {
    private final ParticleWorld particleWorld;
    private final Camera camera;

    private final Window window;
    private final Canvas canvas;

    public Renderer(ParticleWorld particleWorld, Camera camera) {
        this(particleWorld, camera, new Window() {{
            setSize(500, 500);
        }});

    }

    public Renderer(ParticleWorld particleWorld, Camera camera, Window window) {
        this.particleWorld = particleWorld;
        this.camera = camera;

        this.window = window;
        this.canvas = new Canvas(particleWorld, camera);
        this.window.add(this.canvas);
        this.window.setVisible(true);
    }

    public void mainloop() {
        double time = System.currentTimeMillis() / 1000d;
        while (true) {
            double dt = time - System.currentTimeMillis() / 1000d;
            time = System.currentTimeMillis() / 1000d;
            window.repaint();
            camera.setYaw(camera.getYaw() + 100d * dt);
        }
    }
}

class Canvas extends JPanel {
    private final ParticleWorld particleWorld;
    private final Camera camera;

    public Canvas(ParticleWorld particleWorld, Camera camera) {
        this.particleWorld = particleWorld;
        this.camera = camera;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        HashMap<Double, Particle> particleDistances = new HashMap<>();

        for (Particle particle : particleWorld.getParticles()) {
            particleDistances.put(ThreeD_Utils.getDistance(particle.getCoordinates(), new Coordinate(0, 0, 0)), particle);
        }

        Double[] distances = particleDistances.keySet().toArray(new Double[0]);
        Arrays.sort(distances);

        for (Double distance : distances) {
            Particle particle = particleDistances.get(distance);

            // get xy plane angle
            double rx = particle.getCoordinates().getX() - camera.getCoordinate().getX();
            double ry = particle.getCoordinates().getY() - camera.getCoordinate().getY();
            double xy_angle = Math.toDegrees(Math.atan(ry/rx)) - camera.getYaw();
            System.out.println(xy_angle);
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