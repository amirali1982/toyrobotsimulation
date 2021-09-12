package command;

import surface.Surface;
import surface.SurfaceUtil;
import toyrobot.ToyRobot;

public class RightCommand implements CommandInterface {

    final Surface surface;
    final ToyRobot toyRobot;

    public RightCommand(CommandData commandData) {
        this.surface = commandData.getSurface();
        this.toyRobot = commandData.getToyRobot();
    }

    @Override
    public void execute() {
        if (!SurfaceUtil.hasObject(surface)) {
            System.out.println("You must first use the PLACE command.");
            return;
        }
        toyRobot.turnRight();
    }
}
