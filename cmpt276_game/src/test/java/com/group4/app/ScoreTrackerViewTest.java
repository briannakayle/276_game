package com.group4.app;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreTrackerViewTest{

    @Test
    @DisplayName("test for initialize")
    public void viewTest(){
        ScoreTrackerView sTracker = new ScoreTrackerView();
        //check location
        assertEquals(100, sTracker.getHolder().getX());
        assertEquals(30, sTracker.getHolder().getY());
        //check initialized two marks
        assertEquals(0,sTracker.getMarks());
        assertEquals(0,sTracker.getRealMarks());
    }

    @Test
    public void addMarksTest(){
        ScoreTrackerView sTracker = new ScoreTrackerView();
        ScoreTracker scoreTracker = new ScoreTracker();

        scoreTracker.addMarks(1);
        sTracker.addMarks(1);
        assertEquals(scoreTracker.getMarks(), sTracker.getMarks());

        scoreTracker.addMarks(2);
        sTracker.addMarks(2);
        assertEquals(scoreTracker.getMarks(), sTracker.getMarks());

        scoreTracker.addMarks(3);
        sTracker.addMarks(3);
        assertEquals(scoreTracker.getMarks(), sTracker.getMarks());

        scoreTracker.addMarks(4);
        sTracker.addMarks(4);
        assertEquals(scoreTracker.getMarks(), sTracker.getMarks());

        scoreTracker.addMarks(210);
        sTracker.addMarks(210);
        assertEquals(scoreTracker.getMarks(), sTracker.getMarks());

        scoreTracker.addMarks(-12);
        sTracker.addMarks(-12);
        assertEquals(scoreTracker.getMarks(), sTracker.getMarks());

        scoreTracker.addMarks(0);
        sTracker.addMarks(0);
        assertEquals(scoreTracker.getMarks(), sTracker.getMarks());

        scoreTracker.addMarks(-1);
        sTracker.addMarks(-1);
        assertEquals(scoreTracker.getMarks(), sTracker.getMarks());

    }

    @Test
    public void addRealMarksTest(){
        ScoreTracker scoreTracker = new ScoreTracker();
        ScoreTrackerView sTracker = new ScoreTrackerView();

        scoreTracker.addRealMarks(1);
        sTracker.addRealMarks(1);
        assertEquals(scoreTracker.getRealMarks(), sTracker.getRealMarks());

        scoreTracker.addRealMarks(2);
        sTracker.addRealMarks(2);
        assertEquals(scoreTracker.getRealMarks(), sTracker.getRealMarks());

        scoreTracker.addRealMarks(8);
        sTracker.addRealMarks(8);
        assertEquals(scoreTracker.getRealMarks(), sTracker.getRealMarks());

        scoreTracker.addRealMarks(9);
        sTracker.addRealMarks(9);
        assertEquals(scoreTracker.getRealMarks(), sTracker.getRealMarks());

        scoreTracker.addRealMarks(100);
        sTracker.addRealMarks(100);
        assertEquals(scoreTracker.getRealMarks(), sTracker.getRealMarks());

        scoreTracker.addRealMarks(-1);
        sTracker.addRealMarks(-1);
        assertEquals(scoreTracker.getRealMarks(), sTracker.getRealMarks());

        scoreTracker.addRealMarks(-190);
        sTracker.addRealMarks(-190);
        assertEquals(scoreTracker.getRealMarks(), sTracker.getRealMarks());
    }
}
