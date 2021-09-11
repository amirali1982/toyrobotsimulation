package ai;

import entity.CardinalDirection;
import entity.Surface;
import entity.ToyRobot;

public class ToyRobotAi {

    public static void place(Surface table, ToyRobot toyRobot, String parameters) {
        String[] placeParameters = parameters.split(",");
        if (table.isValidCoordinates(Integer.parseInt(placeParameters[0]), Integer.parseInt(placeParameters[1]))) {
            table.initializeSpace();
            toyRobot.setX(Integer.parseInt(placeParameters[0]));
            toyRobot.setY(Integer.parseInt(placeParameters[1]));
            table.placeObject(toyRobot.getX(), toyRobot.getY(), toyRobot);
            toyRobot.setDirection(CardinalDirection.valueOf(placeParameters[2].toUpperCase()));

        } else {
            System.out.println("If I listen to you then I'll fall.");
        }
    }

    public static void move(Surface table, ToyRobot toyRobot) {
        int newX = toyRobot.getX();
        int newY = toyRobot.getY();

        if (toyRobot.getDirection() == CardinalDirection.NORTH) {
            newY++;
        } else if (toyRobot.getDirection() == CardinalDirection.SOUTH) {
            newY--;
        } else if (toyRobot.getDirection() == CardinalDirection.EAST) {
            newX++;
        } else if (toyRobot.getDirection() == CardinalDirection.WEST) {
            newX--;
        }

        if (table.isValidCoordinates(newX, newY)) {
            table.placeObject(toyRobot.getX(), toyRobot.getY(), null);
            table.placeObject(newX, newY, toyRobot);
            toyRobot.setX(newX);
            toyRobot.setY(newY);
        } else {
            System.out.println("If I move then I'll fall.");
        }
    }

    public static void turnLeft(ToyRobot toyRobot) {
        if (toyRobot.getDirection() == CardinalDirection.NORTH) {
            toyRobot.setDirection(CardinalDirection.WEST);
        } else if (toyRobot.getDirection() == CardinalDirection.WEST) {
            toyRobot.setDirection(CardinalDirection.SOUTH);
        } else if (toyRobot.getDirection() == CardinalDirection.SOUTH) {
            toyRobot.setDirection(CardinalDirection.EAST);
        } else if (toyRobot.getDirection() == CardinalDirection.EAST) {
            toyRobot.setDirection(CardinalDirection.NORTH);
        }
    }

    public static void turnRight(ToyRobot toyRobot) {
        if (toyRobot.getDirection() == CardinalDirection.NORTH) {
            toyRobot.setDirection(CardinalDirection.EAST);
        } else if (toyRobot.getDirection() == CardinalDirection.EAST) {
            toyRobot.setDirection(CardinalDirection.SOUTH);
        } else if (toyRobot.getDirection() == CardinalDirection.SOUTH) {
            toyRobot.setDirection(CardinalDirection.WEST);
        } else if (toyRobot.getDirection() == CardinalDirection.WEST) {
            toyRobot.setDirection(CardinalDirection.NORTH);
        }
    }
}
