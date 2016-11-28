package com.nixsolutions.robot;


import java.io.*;

import static com.nixsolutions.robot.Direction.*;

public class Robot {

    private int positionX;
    private int positionY;
    private StringWriter writer;
    private static final int STEP = 1;

    private Direction direction;

    public Robot(StringWriter writer) throws IOException {
        this.positionX = 0;
        this.positionY = 0;
        this.writer = writer;
        this.direction = RIGHT;
        writeWay();
    }

    public void turnLeft() {
        if (direction == RIGHT) {
            direction = TOP;
        } else if (direction == BOTTOM) {
            direction = RIGHT;
        } else if (direction == LEFT) {
            direction = BOTTOM;
        } else if (direction == TOP) {
            direction = LEFT;
        }
    }

    public void turnRight() {
        if (direction == RIGHT) {
            direction = BOTTOM;
        } else if (direction == BOTTOM) {
            direction = LEFT;
        } else if (direction == LEFT) {
            direction = TOP;
        } else if (direction == TOP) {
            direction = RIGHT;
        }
    }

    public void stepForward() throws IOException {
        if (direction == RIGHT) {
            positionX += STEP;
            writeWay();
        } else if (direction == BOTTOM) {
            positionY -= STEP;
            writeWay();
        } else if (direction == LEFT) {
            positionX -= STEP;
            writeWay();
        } else if (direction == TOP) {
            positionY += STEP;
            writeWay();
        }
    }

    private void writeWay() throws IOException {
        writer.write(positionX + " " + positionY + System.lineSeparator());
        writer.flush();
    }
}
