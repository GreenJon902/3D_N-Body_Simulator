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

    private boolean mainloop = true;

    public Window(ParticleWorld particleWorld, Camera camera, int width, int height) {
        this.particleWorld = particleWorld;
        this.camera = camera;

        this.setSize(width, height);
        this.canvas = new Renderer(particleWorld, camera);
        this.add(this.canvas);

        this.addWindowListener(this);

        this.setVisible(true);
    }

    public Window(ParticleWorld particleWorld, Camera camera) {
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
