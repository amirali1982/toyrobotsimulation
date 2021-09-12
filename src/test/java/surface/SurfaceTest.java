package surface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurfaceTest {

    Surface surface;

    @BeforeEach
    public void initialize() {
        surface = new Surface();
        SurfaceUtil.initializeSpace(surface, 5, 5);
    }

    @Test
    public void testInitializeSpace() {

        Object[][] initializedSpace = surface.getSpace();
        assertNotNull(initializedSpace);

        assertEquals(5, initializedSpace.length);
        assertEquals(5, initializedSpace[0].length);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> initializedSpace[initializedSpace.length][initializedSpace.length] = 1);
    }


}