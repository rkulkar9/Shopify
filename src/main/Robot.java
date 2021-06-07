package main;

import java.io.InputStreamReader;

public class Robot {

    static Position pos;
    static RobotDirection robotDirection;

    private final String helpMessage = "Welcome Robot\n"
                         +"L: Turn Robot Left\n"
                         +"R: Turn Robot Right\n"
                         +"M: Move Robot Forward\n"
                         +"?: Help message\n"
                         +"Q: Robot is sleeping\n";

    public Robot () {
        pos = new Position();
        robotDirection = new RobotDirection();
    }

    private void processCommands(char input) {
        RobotDirection.Direction newDirection;
        switch (input) {
            case 'L':
                newDirection = getRobotDirection('L');
                System.out.println("Robot at ("+ (pos.getCurrentXPosition() +","+pos.getCurrentYPosition()) + ") facing " +newDirection.toString());
                robotDirection.setCurrentDirection(newDirection);
                break;
            case 'R':
                newDirection = getRobotDirection('R');
                System.out.println("Robot at ("+ (pos.getCurrentXPosition() +","+pos.getCurrentYPosition()) + ") facing " + newDirection.toString());
                robotDirection.setCurrentDirection(newDirection);
                break;
            case 'M':
                setRobotPosition(pos);
                System.out.println("Robot at ("+ pos.getCurrentXPosition()+","+pos.getCurrentYPosition()+") facing " + robotDirection.getCurrentDirection());
                break;
            case '?':
                System.out.println(helpMessage);
                break;
        }
    }

    public RobotDirection.Direction getRobotDirection(char moveDirection) {
        RobotDirection.Direction direction = null;
        if (moveDirection == 'L') {
            direction = robotDirection.turnLeftMap.get(robotDirection.getCurrentDirection());
        }
        else if (moveDirection == 'R') {
            direction = robotDirection.turnRightMap.get(robotDirection.getCurrentDirection());
        }
        return direction;
    }

    public void setRobotPosition(Position pos) {
        int currentXPosition = pos.getCurrentXPosition();
        int currentYPosition = pos.getCurrentYPosition();

        if (robotDirection.getCurrentDirection().equals(RobotDirection.Direction.West)) {
            pos.setCurrentXPosition(currentXPosition - 1);
            pos.setCurrentYPosition(currentYPosition);
        }
        else if (robotDirection.getCurrentDirection().equals(RobotDirection.Direction.East)) {
            pos.setCurrentXPosition(currentXPosition + 1);
            pos.setCurrentYPosition(currentYPosition);
        }
        else if (robotDirection.getCurrentDirection().equals(RobotDirection.Direction.North)) {
            pos.setCurrentXPosition(currentXPosition);
            pos.setCurrentYPosition(currentYPosition + 1);
        }
        else if (robotDirection.getCurrentDirection().equals(RobotDirection.Direction.South)) {
            pos.setCurrentXPosition(currentXPosition);
            pos.setCurrentYPosition(currentYPosition-1);
        }
    }

    public static void main (String args[]) {
        Robot robot = new Robot();
        InputStreamReader is = new InputStreamReader(System.in);
        try {
            int data = is.read();
            while (data != 'Q') {
                char input = (char) data;
                robot.processCommands(input);
                data = is.read();
            }
            System.out.println("Robot is sleeping");
            is.close();
        } catch (Exception e) {
            System.out.println("Input error");
        }
    }
}
