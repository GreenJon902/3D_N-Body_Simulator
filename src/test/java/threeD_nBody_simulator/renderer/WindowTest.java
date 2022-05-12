package threeD_nBody_simulator.renderer;

import com.greenjon902.cr_squared.threeD_nBody_simulator.Particle;
import com.greenjon902.cr_squared.threeD_nBody_simulator.ParticleWorld;
import com.greenjon902.cr_squared.threeD_nBody_simulator.renderer.Camera;
import com.greenjon902.cr_squared.threeD_nBody_simulator.renderer.Window;
import com.greenjon902.cr_squared.threeD_nBody_simulator.structs.Coordinate;
import org.junit.jupiter.api.Test;

public class WindowTest {
    @Test
    public void basicRenderer() {
        ParticleWorld particleWorld = new ParticleWorld();
        particleWorld.addParticle(new Particle(new Coordinate(20, 0, 0), 0, 10, 0, 0, 0));

        Camera camera = new Camera(new Coordinate(0, 0, 0), 0, 0);

        Window window = new Window(particleWorld, camera);
        window.mainloop();
    }
}
