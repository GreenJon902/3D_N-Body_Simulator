package com.greenjon902.cr_squared.threeD_nBody_simulator.physicsEngine;

import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;

public class PhysicsEngine {

    private final ParticleWorld world;
    public double G = 6.67428e-11; // newton be like
    public double AU = 149.6e6; // in km

    private int step = 1; // may or may not be needed
    private double scale = 250 / AU; // 1 AU = 250 pixels

    public float x;
    public float y;
    public float z;

    private float xv;
    private float yv;
    private float zv;

    //forces

    public float force_x;
    public float force_y;
    public float force_z;


    public double mass;
    private Object obj;


    public PhysicsEngine(ParticleWorld world) {
        this.world = world;
    }

    public ParticleWorld tick() {
        return new ParticleWorld();
    }

    public void Nbody(double G, double AU, float x, float y, float z, double mass, float xv, float yv, float zv) {
        this.G = G;
        this.AU = AU; // do i need since they are both already public?

        //cords obv
        this.x = x;
        this.y = y;
        this.z = z;

        this.mass = mass;

        //velocitiys

        this.xv = xv;
        this.yv = yv;
        this.zv = zv;
    }
}
