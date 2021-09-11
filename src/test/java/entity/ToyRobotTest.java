package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToyRobotTest {
    ToyRobot toyRobot;

    @BeforeEach
    public void initialize() {
        toyRobot = new ToyRobot();
    }

    @Test
    public void testGetReport() {
        assertEquals("", toyRobot.getReport());

        toyRobot.setX(3);
        toyRobot.setY(4);
        toyRobot.setDirection(CardinalDirection.NORTH);

        assertEquals("I'm currently at 3,4,NORTH", toyRobot.getReport());
    }

}