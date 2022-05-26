package threeD_nBody_simulator.physicsEngine;

import org.junit.jupiter.api.Test;

public class PhysicsEngineTest {
    public double G = 6.67428e-11; // newton be like
    public double AU = 149.6e6; // in km

    private int step = 1; // may or may not be needed
    private double scale = 250 / AU; // 1 AU = 250 pixels

    @Test
    public void Nbody(double G, double AU, float x, float y, float z, double mass){
        this.G = G;
        this.AU = AU; // do i need since they are both already public?

        this.x = x;
        this.y = y;
        this.z = z;







    }
}
