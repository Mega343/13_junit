package com.nixsolutions.robot;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class RobotTest {

    private Robot robot;
    private StringWriter writer;

    @Before
    public void setUp() throws Exception {
        writer = new StringWriter();
        robot = new Robot(writer);
    }

    @Test
    public void shouldStepInDefaultDirection() throws Exception {
        //given
        String expectedResult = "0 0" + System.lineSeparator() + "1 0" + System.lineSeparator();

        //when
        robot.stepForward();
        String actualResult = writer.toString();

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldStepDownwards() throws Exception {
        //given
        String expectedResult = "0 0" + System.lineSeparator() + "0 -1" + System.lineSeparator();

        //when
        robot.turnRight();
        robot.stepForward();
        String actualResult = writer.toString();

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldStepUpwards() throws Exception {
        //given
        String expectedResult = "0 0" + System.lineSeparator() + "0 1" + System.lineSeparator();

        //when
        robot.turnLeft();
        robot.stepForward();
        String actualResult = writer.toString();

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldStepLeft() throws Exception {
        //given
        String expectedResult = "0 0" + System.lineSeparator() + "-1 0" + System.lineSeparator();

        //when
        robot.turnLeft();
        robot.turnLeft();
        robot.stepForward();
        String actualResult = writer.toString();

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldStepRightAfterReverse() throws Exception {
        //given
        String expectedResult = "0 0" + System.lineSeparator() + "1 0" + System.lineSeparator();

        //when
        robot.turnLeft();
        robot.turnLeft();
        robot.turnLeft();
        robot.turnLeft();
        robot.stepForward();
        String actualResult = writer.toString();

        //then
        assertEquals(expectedResult, actualResult);
    }

    @After
    public void tearDown() throws Exception {
        writer.close();
    }
}
