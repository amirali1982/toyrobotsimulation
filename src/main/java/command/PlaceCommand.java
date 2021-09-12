package command;

import surface.Surface;
import toyrobot.ToyRobot;

public class PlaceCommand implements CommandInterface {

    final Surface surface;
    final ToyRobot toyRobot;
    final Object args;

    public PlaceCommand(CommandData commandData) {
        this.surface = commandData.getSurface();
        this.toyRobot = commandData.getToyRobot();
        this.args = commandData.getParameters();
    }

    @Override
    public void execute() {
        toyRobot.place(surface, args.toString());
    }
}
