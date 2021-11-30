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
    @DisplayName("Setup Test")
    public void constructorTest(){
        assertNotNull(window);
        assertNotNull(window.gettTracker());
        assertNotNull(window.getsTracker());
        assertNotNull(window.getAudioFile());
    }

    @Test
    @DisplayName("ScoreTracker Test")
    public void updateScoreTrackerTest() {
        window.updateScoreTracker(100);
        assertEquals(100, window.getsTracker().getMarks());
        window.updateRealTracker(100);
        assertEquals(100, window.getsTracker().getMarks());
        assertEquals(100, window.getsTracker().getRealMarks());
    }

    @Test
    @DisplayName("Integrated AppWindow and Board")
    public void integratedWindowAndBoardTest(){
        Board board = new Board(null,null,null,null,window);
        boardHolder holder = new boardHolder(board);
        window.addBoard(holder);
        window.setBoard(holder);
        assertNotNull(board.window);
        assertNotNull(window.currentBoard);
        assert(board.t.isRunning());

    }
}
