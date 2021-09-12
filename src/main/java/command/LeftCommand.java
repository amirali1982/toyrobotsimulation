package command;

import surface.Surface;
import surface.SurfaceUtil;
import toyrobot.ToyRobot;

public class LeftCommand implements CommandInterface {

    final Surface surface;
    final ToyRobot toyRobot;

    public LeftCommand(CommandData commandData) {
        this.surface = commandData.getSurface();
        this.toyRobot = commandData.getToyRobot();
    }

    @Override
    public void execute() {
        if (!SurfaceUtil.hasObject(surface)) {
            System.out.println("You must first use the PLACE command.");
            return;
        }
        toyRobot.turnLeft();
    }
}
