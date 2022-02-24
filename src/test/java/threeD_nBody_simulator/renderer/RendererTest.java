package threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.Particle;
import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;
import com.greenjon902.cr_squared.threeD_nBody_simulator.renderer.Renderer;
import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinates;
import org.junit.jupiter.api.Test;

public class RendererTest {
    @Test
    public void basicRenderer() {
        ParticleWorld particleWorld = new ParticleWorld();
        particleWorld.addParticle(new Particle(new Coordinates(-20, 0, 0), 0, 10, 0, 0, 0));

        Renderer renderer = new Renderer(particleWorld);
        renderer.mainloop();
    }
}
