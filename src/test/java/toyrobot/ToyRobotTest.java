package toyrobot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import surface.Surface;
import surface.SurfaceUtil;

import static org.junit.jupiter.api.Assertions.*;

class ToyRobotTest {

    Surface surface;
    ToyRobot toyRobot;

    @BeforeEach
    public void initialize() {
        surface = new Surface();
        SurfaceUtil.initializeSpace(surface, 5, 5);

        toyRobot = new ToyRobot();
    }

    @Test
    public void testToyRobotUtil() {

        assertFalse(SurfaceUtil.hasObject(surface));

        toyRobot.place(surface, "3,3,NORTH");

        assertTrue(SurfaceUtil.hasObject(surface));
        assertEquals(ToyRobot.class, surface.getSpace()[3][3].getClass());
        assertEquals(CardinalDirection.NORTH, ((ToyRobot) surface.getSpace()[3][3]).getDirection());

        toyRobot.turnLeft();
        assertEquals(CardinalDirection.WEST, ((ToyRobot) surface.getSpace()[3][3]).getDirection());

        toyRobot.turnRight();
        assertEquals(CardinalDirection.NORTH, ((ToyRobot) surface.getSpace()[3][3]).getDirection());

        toyRobot.move(surface);
        assertEquals(ToyRobot.class, surface.getSpace()[3][4].getClass());
        assertNull(surface.getSpace()[3][3]);
        assertEquals(CardinalDirection.NORTH, ((ToyRobot) surface.getSpace()[3][4]).getDirection());

        //Robot should not fall off the surface and stay at the same place
        toyRobot.move(surface);
        assertEquals(ToyRobot.class, surface.getSpace()[3][4].getClass());

    }
}