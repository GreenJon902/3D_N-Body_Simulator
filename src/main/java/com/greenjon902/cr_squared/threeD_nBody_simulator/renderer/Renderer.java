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
        while (true) {
            window.repaint();
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

        HashMap<Float, Particle> particleDistances = new HashMap<>();

        for (Particle particle : particleWorld.getParticles()) {
            particleDistances.put(ThreeD_Utils.getDistance(particle.getCoordinates(), new Coordinate(0, 0, 0)), particle);
        }

        Float[] distances = particleDistances.keySet().toArray(new Float[0]);
        Arrays.sort(distances);

        for (Float distance : distances) {
            Particle particle = particleDistances.get(distance);

            // get xy plane angle
            float rx = particle.getCoordinates().getX() - camera.getCoordinate().getX();
            float ry = particle.getCoordinates().getY() - camera.getCoordinate().getY();
            double xy_angle = Math.atan(ry/rx);
        }
    }
}