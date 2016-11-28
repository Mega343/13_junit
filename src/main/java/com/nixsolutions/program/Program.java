package com.nixsolutions.program;

import com.nixsolutions.robot.Robot;

import java.io.*;

public class Program {

    private static final char LEFT = 'l';
    private static final char RIGHT = 'r';
    private static final char FORWARD = 'f';

    public void robotMove(File inputData, File outputData) throws IOException {
        StringWriter writer = new StringWriter();
        Robot robot = new Robot(writer);
        String route = readRoute(inputData);
        char[] commandsForRobot = route.toCharArray();
        
        robotRoutePassage(robot, commandsForRobot);
        writeRoute(writer, outputData);
    }

    void robotRoutePassage(Robot robot, char[] commandsForRobot) throws IOException {
        for (int i = 0; i < commandsForRobot.length; i++) {
            if (commandsForRobot[i] == LEFT) {
                robot.turnLeft();
            } else if (commandsForRobot[i] == RIGHT) {
                robot.turnRight();
            } else if (commandsForRobot[i] == FORWARD) {
                robot.stepForward();
            }
        }
    }

     String readRoute(File fileName) {
        String route;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            route = reader.readLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return route;
    }

     void writeRoute(Writer writer, File fileName) throws IOException {
        String s = writer.toString();

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            pw.write(s);
            pw.flush();
            writer.close();
        }
    }
}
