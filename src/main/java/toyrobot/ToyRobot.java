package toyrobot;

import surface.Surface;
import surface.SurfaceUtil;

public class ToyRobot {

    private int x;
    private int y;
    private CardinalDirection direction;
    public static final String REPORT_FORMAT = "I'm currently at %d,%d,%s";

    public void place(Surface table, String parameters) {
        String[] placeParameters = parameters.split(",");
        if (SurfaceUtil.isValidCoordinates(table, Integer.parseInt(placeParameters[0]), Integer.parseInt(placeParameters[1]))) {
            SurfaceUtil.initializeSpace(table, table.getSpace().length, table.getSpace()[0].length);
            x = Integer.parseInt(placeParameters[0]);
            y = Integer.parseInt(placeParameters[1]);
            SurfaceUtil.placeObject(table, x, y, this);
            direction = CardinalDirection.valueOf(placeParameters[2].toUpperCase());

        } else {
            System.out.println("If I listen to you then I'll fall.");
        }
    }

    public void move(Surface table) {
        int newX = x;
        int newY = y;

        if (direction == CardinalDirection.NORTH) {
            newY++;
        } else if (direction == CardinalDirection.SOUTH) {
            newY--;
        } else if (direction == CardinalDirection.EAST) {
            newX++;
        } else if (direction == CardinalDirection.WEST) {
            newX--;
        }

        if (SurfaceUtil.isValidCoordinates(table, newX, newY)) {
            SurfaceUtil.placeObject(table, x, y, null);
            SurfaceUtil.placeObject(table, newX, newY, this);
            x = newX;
            y = newY;
        } else {
            System.out.println("If I move then I'll fall.");
        }
    }

    public void turnLeft() {
        if (direction == CardinalDirection.NORTH) {
            direction = CardinalDirection.WEST;
        } else if (direction == CardinalDirection.WEST) {
            direction = CardinalDirection.SOUTH;
        } else if (direction == CardinalDirection.SOUTH) {
            direction = CardinalDirection.EAST;
        } else if (direction == CardinalDirection.EAST) {
            direction = CardinalDirection.NORTH;
        }
    }

    public void turnRight() {
        if (direction == CardinalDirection.NORTH) {
            direction = CardinalDirection.EAST;
        } else if (direction == CardinalDirection.EAST) {
            direction = CardinalDirection.SOUTH;
        } else if (direction == CardinalDirection.SOUTH) {
            direction = CardinalDirection.WEST;
        } else if (direction == CardinalDirection.WEST) {
            direction = CardinalDirection.NORTH;
        }
    }

    public void getReport() {
        if (direction != null) {
            System.out.printf((REPORT_FORMAT) + "%n", x, y, direction);
        }
    }

    public CardinalDirection getDirection() {
        return direction;
    }

}
