# Toy Robot Simulator

This is a console based simulation of a toy robot who can move on a 2D surface while avoiding any move that can make the toy robot to fall off the surface.

## Implementation

This is gradle based project written using the following:

- JDK11
- Junit5.7.0

## Design Notes

I've chosen this to be a gradle project to save time in build and packaging.

**ToyRobotSimulation**

This is the main console application. I've implemented a **Command Design Pattern** to separate the command execution logic from the view. This class contains code for displaying some introductory message, initializing the table and taking the commands from console.

**CommandExecutor**

I've kept the logic to interpret the user's entered free form command and execute the relevant command here. Keeping this concise will make sure that once the toy robot functionality grows then it's easy to maintain and add new commands.

**PlaceCommand, MoveCommand, LeftCommand, RightCommand, ReportCommand**

These are the actual commands which executes the logic for the command. You may notice that I've invoked a util class from here. The reason for this is that I want to create room for managing complex action in the future. Example, In future a command may execute multiple methods of multiple utils to perform its job. Keeping it this way will make sure it's easy to manage and maintain in the future.

**ToyRobot**

Conceptually, a toy robot should have some intelligence in itself, therefore, I've kept the logic for the toy robot as part of this class.

**Surface**

Although, the requirement was specifically about a Table. However, a table is a surface, and a toy robot's current requirement makes it able to roam around on any 2D surface. Therefore, I've generified this concept and created a surface entity. This entity has a **type** field and in my implementation I've set the type to **table**.

Conceptually, a surface should be a dumb plane, therefore, I've placed the intelligence in **SurfaceUtil**. However, based on the situation this can be merged. This is open to discussion and votes.

## Future Improvements

- Add more test coverage for Command Pattern implementation.
- More Refactoring.

## Run Program

Run `java -jar build/libs/toyrobotsimulation-1.0-SNAPSHOT.jar` from the application folder root or copy the jar to your preferred location to run it.

## Usage

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

**To move one step ahead. The toy robot will not move ahead if it's going to fall:**
```bash
MOVE
```

**To face towards left:**
```bash
LEFT
```
**To face towards right:**
```bash
RIGHT
```
**Report toy robot's coordinates and direction:**
```bash
REPORT
```
**To exit the program:**
```bash
EXIT
```
