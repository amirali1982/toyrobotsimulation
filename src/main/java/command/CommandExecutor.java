package command;

public class CommandExecutor {

    public void executeCommand(CommandData commandData) throws UnknownCommandException {

        String[] commandWithParametersParts = ((String) commandData.getParameters()).split(" ");
        String strCommand = commandWithParametersParts[0].toUpperCase();
        String parameters = "";
        if (commandWithParametersParts.length > 1) {
            parameters = commandWithParametersParts[1];
        }
        CommandInterface command;

        if (Command.PLACE.name().equals(strCommand)) {
            commandData.setParameters(parameters);
            command = new PlaceCommand(commandData);
        } else if (Command.MOVE.name().equals(strCommand)) {
            command = new MoveCommand(commandData);
        } else if (Command.LEFT.name().equals(strCommand)) {
            command = new LeftCommand(commandData);
        } else if (Command.RIGHT.name().equals(strCommand)) {
            command = new RightCommand(commandData);
        } else if (Command.REPORT.name().equals(strCommand)) {
            command = new ReportCommand(commandData);
        } else {
            throw new UnknownCommandException("Unknown Command: " + strCommand);
        }

        command.execute();
    }
}
