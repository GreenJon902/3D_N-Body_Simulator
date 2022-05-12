package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileWriter;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MovementListener implements MouseListener, MouseMotionListener {
    private MouseDragCallback mouseMoveCallback;
    private Integer lastX = null;
    private Integer lastY = null;

    public MovementListener(MouseDragCallback mouseMoveCallback) {
        this.mouseMoveCallback = mouseMoveCallback;
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
}

interface MouseDragCallback {
    void run(int x, int y);
}