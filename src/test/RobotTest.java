package test;

import junit.framework.TestCase;
import main.Position;
import main.Robot;
import main.RobotDirection;
import org.junit.Test;

public class RobotTest extends TestCase {

    Robot robot = new Robot();
    Position position = new Position();;

    @Test
    public void testSetRobotPosition() {
        //test changing y position
        position.setCurrentXPosition(1);
        position.setCurrentYPosition(1);
        robot.setRobotPosition(position);
        assertEquals(2, position.getCurrentYPosition());

        //test changing x position
        position.setCurrentXPosition(2);
        position.setCurrentYPosition(2);
        robot.setRobotPosition(position);
        assertEquals(2,position.getCurrentXPosition());
    }


    @Test
    public void testGetRobotDirection() {
        char leftDirection = 'L';
        char rightDirection = 'R';
        RobotDirection.Direction direction;

        // test changing left direction
        direction = robot.getRobotDirection(leftDirection);
        assertEquals(RobotDirection.Direction.West, direction);

        //// test changing right direction
        direction = robot.getRobotDirection(rightDirection);
        assertEquals(RobotDirection.Direction.East, direction);
    }
}
