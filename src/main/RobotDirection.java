package main;

import java.util.EnumMap;

public class RobotDirection {

    public enum Direction {
        North,
        South,
        East,
        West
    }

    Direction currentDirection;
    public EnumMap<Direction, Direction> turnLeftMap   = new EnumMap<Direction, Direction>(Direction.class);
    public EnumMap<Direction, Direction> turnRightMap  = new EnumMap<Direction, Direction>(Direction.class);

    public RobotDirection() {
        currentDirection = Direction.North;
        turnLeftMap.put(Direction.North, Direction.West);
        turnLeftMap.put(Direction.West, Direction.South);
        turnLeftMap.put(Direction.South, Direction.East);
        turnLeftMap.put(Direction.East, Direction.North);

        turnRightMap.put(Direction.North, Direction.East);
        turnRightMap.put(Direction.East, Direction.South);
        turnRightMap.put(Direction.South, Direction.West);
        turnRightMap.put(Direction.West, Direction.North);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }
}
