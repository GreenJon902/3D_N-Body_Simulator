package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;

import javax.swing.*;
import java.awt.*;

public class Renderer {
    private final ParticleWorld world;
    private final Window window;
    private final Canvas canvas;

    public Renderer(ParticleWorld world) {
        this(world, new Window() {{
            setSize(500, 500);
        }});

    }

    public Renderer(ParticleWorld world, Window window) {
        this.world = world;

        this.window = window;
        this.window.setVisible(true);

        this.canvas = new Canvas();
        this.window.add(this.canvas);
    }

    public void mainloop() {
        while (true) {

        }
    }
}

class Canvas extends JPanel {
    @Override
    protected void printComponent(Graphics g) {
        super.printComponent(g);
    }
}