package ai;

import entity.CardinalDirection;
import entity.Surface;
import entity.ToyRobot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyRobotAiTest {

    Surface surface;
    ToyRobot toyRobot;

    @BeforeEach
    public void initialize() {
        surface = new Surface();
        surface.setMaxX(4);
        surface.setMaxY(4);
        surface.initializeSpace();

        toyRobot = new ToyRobot();
    }

    @Test
    public void testToyRobotAi() {

        assertFalse(surface.hasObject());

        ToyRobotAi.place(surface, toyRobot, "3,3,NORTH");

        assertTrue(surface.hasObject());
        assertEquals(ToyRobot.class, surface.getSpace()[3][3].getClass());
        assertEquals(CardinalDirection.NORTH, ((ToyRobot) surface.getSpace()[3][3]).getDirection());

        ToyRobotAi.turnLeft(toyRobot);
        assertEquals(CardinalDirection.WEST, ((ToyRobot) surface.getSpace()[3][3]).getDirection());

        ToyRobotAi.turnRight(toyRobot);
        assertEquals(CardinalDirection.NORTH, ((ToyRobot) surface.getSpace()[3][3]).getDirection());

        ToyRobotAi.move(surface, toyRobot);
        assertEquals(ToyRobot.class, surface.getSpace()[3][4].getClass());
        assertNull(surface.getSpace()[3][3]);
        assertEquals(CardinalDirection.NORTH, ((ToyRobot) surface.getSpace()[3][4]).getDirection());

        //Robot should not fall off the surface and stay at the same place
        ToyRobotAi.move(surface, toyRobot);
        assertEquals(ToyRobot.class, surface.getSpace()[3][4].getClass());

    }
}