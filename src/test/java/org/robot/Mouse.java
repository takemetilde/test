package org.robot;

import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.After;
import org.junit.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

public class Mouse {

    @Test
    public void moveMouse() throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(3300,400);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        robot.mouseMove(3300,250);


    }

}
