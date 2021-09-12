package surface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurfaceUtilTest {

    Surface surface;

    @BeforeEach
    public void initialize() {
        surface = new Surface();
        SurfaceUtil.initializeSpace(surface, 5, 5);
    }

    @Test
    void testPlaceAndHasObject() {

        assertFalse(SurfaceUtil.hasObject(surface));

        SurfaceUtil.placeObject(surface, 1, 1, "test");
        Object[][] space = surface.getSpace();

        assertEquals("test", space[1][1]);
        assertTrue(SurfaceUtil.hasObject(surface));
    }

    @Test
    void testIsValidCoordinates() {
        assertTrue(SurfaceUtil.isValidCoordinates(surface, 0, 0));
        assertTrue(SurfaceUtil.isValidCoordinates(surface, 0, 4));
        assertTrue(SurfaceUtil.isValidCoordinates(surface, 4, 0));
        assertTrue(SurfaceUtil.isValidCoordinates(surface, 4, 4));

        assertFalse(SurfaceUtil.isValidCoordinates(surface, -1, -1));
        assertFalse(SurfaceUtil.isValidCoordinates(surface, 5, 5));
        assertFalse(SurfaceUtil.isValidCoordinates(surface, 0, 5));
        assertFalse(SurfaceUtil.isValidCoordinates(surface, 5, 0));
    }
}