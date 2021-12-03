package com.group4.app;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreTrackerTest {

    @Test
    public void addMarksTest(){
        ScoreTracker sTracker = new ScoreTracker();

        sTracker.addMarks(0);
        assertEquals(0, sTracker.getMarks());

        for(int i = 0; i < 10; i++){
            sTracker.addMarks(1);
        } //after loop, marks = 10
        assertEquals(10, sTracker.getMarks());

        //test for deleting 1
        for (int i = 0; i < 9; i++) {
            sTracker.addMarks(-1);
        } //after loop, marks = 1
        assertEquals(1, sTracker.getMarks());

        sTracker.addMarks(9);
        assertEquals(10, sTracker.getMarks());
        sTracker.addMarks(-7);
        assertEquals(3, sTracker.getMarks());
    }

    @Test
    public void addRealMarksTest() {
        ScoreTracker sTracker = new ScoreTracker();
        sTracker.addRealMarks(0);
        assertEquals(0, sTracker.getRealMarks());

        //test for adding 1
        for(int i = 0; i < 10; i++){
            sTracker.addRealMarks(1);
        } //after loop, marks = 10
        assertEquals(10, sTracker.getRealMarks());

        //test for deleting 1
        for(int i = 0; i < 9; i++){
            sTracker.addRealMarks(-1);
        } //after loop, marks = 1
        assertEquals(1, sTracker.getRealMarks());

        sTracker.addRealMarks(9);
        assertEquals(10, sTracker.getRealMarks());
        sTracker.addRealMarks(-7);
        assertEquals(3, sTracker.getRealMarks());
    }
}

