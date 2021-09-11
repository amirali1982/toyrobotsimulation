import ai.ToyRobotAi;
import entity.Command;
import entity.Surface;
import entity.ToyRobot;

import java.util.Scanner;

public class ToyRobotSimulation {

    public static void main(String[] args) {

        Surface table = setupSurface();
        ToyRobot toyRobot = new ToyRobot();

        Scanner scanner = new Scanner(System.in);

        introduction(table);

        while (true) {
            try {
                System.out.println("Command> ");
                String commandWithParameters = scanner.nextLine();
                String[] commandWithParametersParts = commandWithParameters.split(" ");
                String command = commandWithParametersParts[0];

                if (!table.hasObject() && !(Command.PLACE.name().equalsIgnoreCase(command) || Command.EXIT.name().equalsIgnoreCase(command))) {
                    System.out.println("You must first use the PLACE command.");
                    continue;
                }

                if (Command.PLACE.name().equalsIgnoreCase(command)) {
                    ToyRobotAi.place(table, toyRobot, commandWithParametersParts[1]);
                    System.out.println(toyRobot.getReport());
                } else if (Command.MOVE.name().equalsIgnoreCase(command)) {
                    ToyRobotAi.move(table, toyRobot);
                    System.out.println(toyRobot.getReport());
                } else if (Command.LEFT.name().equalsIgnoreCase(command)) {
                    ToyRobotAi.turnLeft(toyRobot);
                    System.out.println(toyRobot.getReport());
                } else if (Command.RIGHT.name().equalsIgnoreCase(command)) {
                    ToyRobotAi.turnRight(toyRobot);
                    System.out.println(toyRobot.getReport());
                } else if (Command.REPORT.name().equalsIgnoreCase(command)) {
                    System.out.println(toyRobot.getReport());
                } else if (Command.EXIT.name().equalsIgnoreCase(command)) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Unable to understand the command.");
            }
        }
    }

    private static void introduction(Surface table) {
        System.out.println("* * * Toy Robot Simulator * * *");
        System.out.println((table.getMaxX() + 1) + " X " + (table.getMaxY() + 1) + " " + table.getName() + " has been setup.");
        System.out.println("Valid coordinate range is from (0,0) to (" + (table.getMaxX() - 1) + "," + (table.getMaxY() - 1) + ")");
        System.out.println("The following are valid commands:");
        System.out.println("" +
                "PLACE X,Y,NORTH|SOUTH|EAST|WEST eg; PLACE 1,3,SOUTH \n" +
                "MOVE\n" +
                "LEFT\n" +
                "RIGHT\n" +
                "REPORT\n" +
                "EXIT"
        );
        System.out.println("You must start with a PLACE command.");
    }

    private static Surface setupSurface() {
        Surface table = new Surface();
        table.setName("Table");
        table.setMaxX(4);
        table.setMaxY(4);
        table.initializeSpace();
        return table;
    }

}
