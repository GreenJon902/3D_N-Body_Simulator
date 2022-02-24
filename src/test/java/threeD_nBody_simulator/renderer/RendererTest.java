package threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.Particle;
import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;
import com.greenjon902.cr_squared.threeD_nBody_simulator.renderer.Renderer;
import org.junit.jupiter.api.Test;

public class RendererTest {
    @Test
    public void basicRenderer() {
        ParticleWorld particleWorld = new ParticleWorld();
        particleWorld.addParticle(new Particle(-20, 0, 0, -1, 10, 0, 0, 0));

        Renderer renderer = new Renderer(particleWorld);
        renderer.renderLoop();
    }
}