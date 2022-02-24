package com.greenjon902.cr_squared.threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.Particle;
import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;

import javax.swing.*;
import java.awt.*;

public class Renderer {
    private ParticleWorld particleWorld;
    private final Window window;
    private final Canvas canvas;

    public Renderer(ParticleWorld particleWorld) {
        this(particleWorld, new Window() {{
            setSize(500, 500);
        }});

    }

    public Renderer(ParticleWorld particleWorld, Window window) {
        this.particleWorld = particleWorld;

        this.window = window;
        this.canvas = new Canvas(particleWorld);
        this.window.add(this.canvas);
        this.window.setVisible(true);
    }

    public void mainloop() {
        while (true) {
            canvas.setParticleWorld(particleWorld);
            window.repaint();
        }
    }
}

class Canvas extends JPanel {
    private ParticleWorld particleWorld;

    public Canvas(ParticleWorld particleWorld) {
        this.particleWorld = particleWorld;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Particle particle : particleWorld.getParticles()) {

        }
    }

    public void setParticleWorld(ParticleWorld particleWorld) {
        this.particleWorld = particleWorld;
    }
}