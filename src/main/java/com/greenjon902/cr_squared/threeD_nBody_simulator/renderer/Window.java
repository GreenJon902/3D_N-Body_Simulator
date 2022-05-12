package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Window extends JFrame implements WindowListener {
    private final ParticleWorld particleWorld;
    private final Camera camera;

    private final Renderer canvas;

    private final MovementListener movementListener = new MovementListener(this::moveView);

    private boolean mainloop = true;

    public Window(ParticleWorld particleWorld, Camera camera, int width, int height) {
        this.particleWorld = particleWorld;
        this.camera = camera;

        this.setSize(width, height);
        this.canvas = new Renderer(particleWorld, camera);
        this.add(this.canvas);

        this.addWindowListener(this);
        this.addMouseListener(movementListener);
        this.addMouseMotionListener(movementListener);

        this.setVisible(true);
    }

    public Window(ParticleWorld particleWorld, Camera camera) {
        this(particleWorld, camera, 500, 500);
    }

    public void mainloop() {
        while (mainloop) {
            this.repaint();
        }
    }

    private void moveView(double dx, double dy) {
        camera.setYaw(camera.getYaw() - dx / getWidth() * camera.getFov());
        camera.setPitch(camera.getPitch() - dy / getHeight() * camera.getFov());
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
