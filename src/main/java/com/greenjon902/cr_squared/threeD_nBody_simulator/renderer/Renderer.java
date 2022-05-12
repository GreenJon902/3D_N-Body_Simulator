package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.Particle;
import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;
import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;
import java.util.HashMap;

public class Renderer extends JFrame implements WindowListener {
    private final ParticleWorld particleWorld;
    private final Camera camera;

    private final Canvas canvas;

    private boolean mainloop = true;

    public Renderer(ParticleWorld particleWorld, Camera camera, int width, int height) {
        this.particleWorld = particleWorld;
        this.camera = camera;

        this.setSize(width, height);
        this.canvas = new Canvas(particleWorld, camera);
        this.add(this.canvas);

        this.addWindowListener(this);

        this.setVisible(true);
    }

    public Renderer(ParticleWorld particleWorld, Camera camera) {
        this(particleWorld, camera, 500, 500);
    }

    public void mainloop() {
        double time = System.currentTimeMillis() / 1000d;
        while (mainloop) {
            double dt = time - System.currentTimeMillis() / 1000d;
            time = System.currentTimeMillis() / 1000d;
            this.repaint();
            camera.setYaw(camera.getYaw() + 100d * dt);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        mainloop = false;
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
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