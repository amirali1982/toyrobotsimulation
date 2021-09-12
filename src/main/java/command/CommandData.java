package command;

import surface.Surface;
import toyrobot.ToyRobot;

public class CommandData {

    final Surface surface;
    final ToyRobot toyRobot;
    Object parameters;

    public CommandData(Surface surface, ToyRobot toyRobot) {
        this.surface = surface;
        this.toyRobot = toyRobot;
    }

    public Surface getSurface() {
        return surface;
    }

    public ToyRobot getToyRobot() {
        return toyRobot;
    }

    public Object getParameters() {
        return parameters;
    }

    public void setParameters(Object parameters) {
        this.parameters = parameters;
    }
}
