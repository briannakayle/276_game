package com.group4.app;

import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

public class TimeTrackerIntegrationTest {
    Board currentBoard;
    AppWindow window = new AppWindow();
    Board board1 = new Board(null,null,null,null,window);
    boardHolder holder1 = new boardHolder(board1);

    @Test
    public void TimeTrackerTest() throws InterruptedException {
        currentBoard = holder1.getHeld();
        currentBoard.startTimer();
        TimeUnit.SECONDS.sleep(5);
        currentBoard.stopTimer();
    }

}
