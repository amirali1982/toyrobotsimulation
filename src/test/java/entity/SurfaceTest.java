package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurfaceTest {

    Surface surface;

    @BeforeEach
    public void initialize() {
        surface = new Surface();
        surface.setMaxX(4);
        surface.setMaxY(4);
        surface.initializeSpace();
    }

    @Test
    public void testInitializeSpace() {

        Object[][] initializedSpace = surface.getSpace();
        assertNotNull(initializedSpace);

        assertEquals(4, surface.getMaxX());
        assertEquals(4, surface.getMaxY());

        assertEquals(5, initializedSpace.length);
        assertEquals(5, initializedSpace[0].length);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            initializedSpace[initializedSpace.length][initializedSpace.length] = 1;
        });
    }

    @Test
    void testIsValidCoordinates() {
        assertTrue(surface.isValidCoordinates(0, 0));
        assertTrue(surface.isValidCoordinates(0, 4));
        assertTrue(surface.isValidCoordinates(4, 0));
        assertTrue(surface.isValidCoordinates(4, 4));

        assertFalse(surface.isValidCoordinates(-1, -1));
        assertFalse(surface.isValidCoordinates(5, 5));
        assertFalse(surface.isValidCoordinates(0, 5));
        assertFalse(surface.isValidCoordinates(5, 0));
    }

    @Test
    void testPlaceAndHasObject() {

        assertFalse(surface.hasObject());

        surface.placeObject(1, 1, "test");
        Object[][] space = surface.getSpace();

        assertEquals("test", space[1][1]);
        assertTrue(surface.hasObject());
    }

}