package com.group4.app;

public class ScoreTracker {

    /**
     *Class that tracks the player's progress in the game. Since the bonus does not count as
     * an actual score, we have marks, which gets incremented by coins AND bonus, and realMarks
     * which gets incremented only by coins.
     */

    private int marks = 0;
    private int realMarks = 0;

    public void addMarks(int i) {
        marks += i;
    }

    public void addRealMarks(int i) {
        realMarks += i;
    }

    public int getMarks(){
        return marks;
    }
    public int getRealMarks() {
        return realMarks;
    }
}
