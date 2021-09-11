#Toy Robot Simulator

This is a console based simulation of a toy robot who can move on a 2D surface while avoiding any move that can make the toy robot to fall off the surface.

##Implementation

This is gradle based project written using the following:

- JDK11
- Junit5.7.0


##Run Program

Run `java -jar build/libs/toyrobotsimulation-1.0-SNAPSHOT.jar` from the application folder root or copy the jar to your preferred location to run it.

##Usage

1. Once the program starts, you can only use `PLACE` or `EXIT` commands. The commands can be given in either upper or lower case.

**Example:**
```bash
PLACE 1,1,NORTH
```
or in lower case:
```bash
place 1,1,north
```

2. Once the toy robot has been placed on the surface, you can now use the following commands:

**To move one step ahead:**
```bash
MOVE
```

**To turn left:**
```bash
LEFT
```
**To turn right:**
```bash
RIGHT
```
**Asking toy robot to give a report:**
```bash
REPORT
```
**To exit the program:**
```bash
EXIT
```

##Technical Notes

The two main entities are:

- **Surface**: A 2D surface, for example, a table where an object can be placed. This entity is intelligent enough to validate its territory and check if something has been placed on it yet.
- **ToyRobot**: A toy robot who has intelligence to report its position.

The **ToyRobotAI** is responsible for ToyRobot's movement on the Surface. The ToyRobotAI currently supports the following:

- **PLACE**: Place the toy robot on the surface and make sure it's not placed outside the surface.
- **LEFT**: Turn the toy robot face towards the left.
- **RIGHT**: Turn the toy robot face towards the right.
- **MOVE**: Move the toy robot 1 step ahead and make sure it doesn't fall off the surface.

