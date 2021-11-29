package com.group4.app;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private static AppWindow window;

    @BeforeAll
    static void setup(){
        window = new AppWindow();
    }

    @Test
    @DisplayName("SetupTest")
    public void setupTest(){
        assertNotNull(window);
        assertNotNull(window.gettTracker());
        assertNotNull(window.getsTracker());
        assertNotNull(window.getAudioFile());
    }

    @Test
    public void updateScoreTrackerTest() {
        window.updateScoreTracker(100);
        assertEquals(100, window.getsTracker().getMarks());
        window.updateRealTracker(100);
        assertEquals(100, window.getsTracker().getMarks());
        assertEquals(100, window.getsTracker().getRealMarks());
    }
}
