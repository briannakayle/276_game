package com.group4.app;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TimeTrackerViewTest {

    @Test
    public void TimeTrackerViewTest(){

        TimeTrackerView tTracker = new TimeTrackerView();
        TimeTracker timeTracker = new TimeTracker(null);
        timeTracker.startTimer();

        //test for initialize
        assertEquals(650, tTracker.getHolder().getX());//test location
        assertEquals(30, tTracker.getHolder().getY());
    }
}
