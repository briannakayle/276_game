package com.group4.app;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private static AppWindow window;

    @BeforeAll
    static void setup(){
        window = new AppWindow();
        window.setVisible(false);
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
        Board board1 = new Board(null,null,null,null,window);
        boardHolder holder1 = new boardHolder(board1);
        Board board2 = new Board(holder1,null,null,null,window);
        boardHolder holder2 = new boardHolder(board2);
        board1.setDown(holder2);
        board1.addPlayer(new character());
        window.addBoard(holder1);
        window.setBoard(holder1);
        assertNotNull(board1.window);
        assertNotNull(board2.window);
        assertNotNull(window.currentBoard);
        assert(board1.t.isRunning());
        board1.change(holder2,0,0);
        assert(!board1.t.isRunning());
        assert(board2.t.isRunning());
        assertEquals(window.currentBoard, board2);
        board2.change(holder1,0,0);
        assertEquals(window.currentBoard, board1);
        board1.addRegularRewards(0,0);
        board1.addNonAnimatedEnemy(0,1);
        board1.collectPoint(0,0,"RR");
        assert(window.getsTracker().getMarks() == 101);
        board1.collectPoint(0,1,"NAE");
        assert(window.getsTracker().getMarks() == 100);
    }
}
