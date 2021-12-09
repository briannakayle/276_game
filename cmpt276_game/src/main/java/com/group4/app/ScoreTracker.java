package com.group4.app;

public class ScoreTracker {

    /**
     *Class that tracks the player's progress in the game. Since the bonus does not count as
     * an actual score, we have marks, which gets incremented by coins AND bonus, and realMarks
     * which gets incremented only by coins.
     */

    private int totalScore = 0;
    private int totalRRewards = 0;

    public void addTotalScore(int i) {
        totalScore += i;
    }

    public void addTotalRRewards(int i) {
        totalRRewards += i;
    }

    public int getTotalScore(){
        return totalScore;
    }
    public int getTotalRRewards() {
        return totalRRewards;
    }
}
