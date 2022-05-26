package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import java.awt.event.*;

public class MovementListener implements MouseListener, MouseMotionListener, KeyListener {
    private MouseDragCallback mouseMoveCallback;
    private KeyCallback keyCallback;
    private Integer lastX = null;
    private Integer lastY = null;

    public MovementListener(MouseDragCallback mouseMoveCallback, KeyCallback keyCallback) {
        this.mouseMoveCallback = mouseMoveCallback;
        this.keyCallback = keyCallback;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        lastX = null;
        lastY = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        if (lastX == null) {
            lastX = e.getX();
        }
        if (lastY == null) {
            lastY = e.getY();
        }

        mouseMoveCallback.run(e.getX() - lastX, e.getY() - lastY);
        lastX = e.getX();
        lastY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        keyCallback.run(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyCallback.run(e.getKeyCode(), false);
    }
}

interface MouseDragCallback {
    void run(int x, int y);
}

interface KeyCallback {
    void run(int keyCode, boolean down);
}