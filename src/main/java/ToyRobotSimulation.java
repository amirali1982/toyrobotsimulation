import command.Command;
import command.CommandData;
import command.CommandExecutor;
import command.UnknownCommandException;
import surface.Surface;
import surface.SurfaceUtil;
import toyrobot.ToyRobot;

import java.util.Scanner;

public class ToyRobotSimulation {

    public static void main(String[] args) {

        Surface table = setupSurface();
        ToyRobot toyRobot = new ToyRobot();
        CommandData commandData = new CommandData(table, toyRobot);

        try (Scanner scanner = new Scanner(System.in)) {
            introduction(table);

            while (true) {
                try {
                    System.out.println("Command> ");
                    String commandWithParameters = scanner.nextLine();

                    if (Command.EXIT.name().equalsIgnoreCase(commandWithParameters)) {
                        break;
                    }

                    commandData.setParameters(commandWithParameters);
                    CommandExecutor executor = new CommandExecutor();
                    executor.executeCommand(commandData);

                } catch (UnknownCommandException ex) {
                    System.out.println("Unable to understand the command. ");
                }
            }
        }
    }

    private static void introduction(Surface table) {
        System.out.println("* * * Toy Robot Simulator * * *");
        System.out.println(table.getSpace().length + " X " + table.getSpace()[0].length + " " + table.getType() + " has been setup.");
        System.out.println("Valid coordinate range is from (0,0) to (" + (table.getSpace().length - 1) + "," + (table.getSpace()[0].length - 1) + ")");
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
        table.setType("Table");
        SurfaceUtil.initializeSpace(table, 5, 5);
        return table;
    }
}
