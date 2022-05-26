package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Window extends JFrame implements WindowListener {
    private final ParticleWorld particleWorld;
    private final Camera camera;

    private final Renderer canvas;

    private final MovementListener movementListener = new MovementListener(this::panView, this::moveView);

    private boolean mainloop = true;

    private static double moveSpeed = 5;
    private int fbMovement = 0; // Direction moving forward or backwards, (1 for forward, -1 for backwards, 0 for none)
    private int lrMovement = 0;// Direction moving left or right, (1 for right, -1 for left, 0 for none)
    private int udMovement = 0;// Direction moving up or down, (1 for up, -1 for down, 0 for none)

    public Window(ParticleWorld particleWorld, Camera camera, int width, int height) {
        this.particleWorld = particleWorld;
        this.camera = camera;

        this.setSize(width, height);
        this.canvas = new Renderer(particleWorld, camera);
        this.add(this.canvas);

        this.addWindowListener(this);
        this.addMouseListener(movementListener);
        this.addMouseMotionListener(movementListener);
        this.addKeyListener(movementListener);

        this.setVisible(true);
    }

    public Window(ParticleWorld particleWorld, Camera camera) {
        this(particleWorld, camera, 500, 500);
    }

    public void mainloop() {
        double time = System.currentTimeMillis() / 1000d;
        while (mainloop) {
            double dt = System.currentTimeMillis() / 1000d - time;
            time = System.currentTimeMillis() / 1000d;

            this.updateCameraPos(dt);
            this.repaint();
        }
    }

    private void updateCameraPos(double dt) {
        double x = this.camera.getCoordinate().getX();
        double y = this.camera.getCoordinate().getY();
        double z = this.camera.getCoordinate().getZ();
        double pitch = Math.toRadians(this.camera.getPitch());
        double yaw = Math.toRadians(this.camera.getYaw());

        if (fbMovement != 0) { // if its 0 then nothing will happen so don't calculate speed
            this.camera.getCoordinate().setZ(z + Math.sin(pitch) * (moveSpeed * dt) * fbMovement);
            double xy_hype = Math.cos(pitch) * moveSpeed;
            this.camera.getCoordinate().setX(x + Math.cos(yaw) * (xy_hype * dt) * fbMovement);
            this.camera.getCoordinate().setY(y + Math.sin(yaw) * (xy_hype * dt) * fbMovement);
        }

        if (lrMovement != 0) { // if its 0 then nothing will happen so don't calculate speed
            this.camera.getCoordinate().setX(x + Math.cos(yaw + 90) * (moveSpeed * dt) * lrMovement);
            this.camera.getCoordinate().setY(y + Math.sin(yaw + 90) * (moveSpeed * dt) * lrMovement);
        }

        if (udMovement != 0) { // if its 0 then nothing will happen so don't calculate speed
            this.camera.getCoordinate().setZ(z + Math.sin(pitch + 90) * (moveSpeed * dt) * udMovement);
            double xy_hype = Math.cos(pitch + 90) * moveSpeed;
            this.camera.getCoordinate().setX(x + Math.cos(yaw) * (xy_hype * dt) * udMovement);
            this.camera.getCoordinate().setY(y + Math.sin(yaw) * (xy_hype * dt) * udMovement);
        }
    }

    private void panView(double dx, double dy) {
        camera.setYaw(camera.getYaw() - dx / getWidth() * camera.getFov());
        camera.setPitch(camera.getPitch() - dy / getHeight() * camera.getFov());
    }

    private void moveView(int keyCode, boolean down) {
        int value = down ? 1 : 0; // is key down
        int inverter = 1; // is going opposite direction
        switch (keyCode) {
            case KeyEvent.VK_S:
                inverter = -1;
            case KeyEvent.VK_W:
                this.fbMovement = value * inverter;
                break;
            case KeyEvent.VK_A:
                inverter = -1;
            case KeyEvent.VK_D:
                this.lrMovement = value * inverter;
                break;
            case KeyEvent.VK_SPACE:
                inverter = -1;
            case KeyEvent.VK_SHIFT:
                this.udMovement = value * inverter;
                break;
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
