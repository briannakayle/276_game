package com.group4.app;

import javax.swing.*;
import java.awt.*;

class ScoreTrackerView extends Tracker {

    /**
     * ScoreTrackerView handles the visual aspect of the Score. Split from ScoreTracker for ease of testing.
     */

    ScoreTracker scoreTracker = new ScoreTracker();

    public ScoreTrackerView() {
        super();
        holder.setLocation(100, 30);
        addTotalScore(0);
    }

    public void addTotalScore(int i) {
        scoreTracker.addTotalScore(i);
        holder.remove(display);
        holder.repaint();
        display = new JLabel("Score: " + getTotalScore(), SwingConstants.LEFT);
        display.setForeground(Color.white);
        display.setFont(customFont);
        display.setSize(400, 120);
        holder.add(display);
        display.repaint();
        holder.repaint();
    }

    public void addTotalRRewards(int i) {
        scoreTracker.addTotalRRewards(i);
    }

    public int getTotalScore(){
        return scoreTracker.getTotalScore();
    }
    public int getTotalRRewards() {
        return scoreTracker.getTotalRRewards();
    }

    public JPanel getHolder() {
        return holder;
    }
}
