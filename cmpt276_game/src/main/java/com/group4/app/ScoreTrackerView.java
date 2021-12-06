package com.group4.app;

import javax.swing.*;
import java.awt.*;

class ScoreTrackerView extends tracker {

    /**
     * ScoreTrackerView handles the visual aspect of the Score. Split from ScoreTracker for ease of testing.
     */

    ScoreTracker scoreTracker = new ScoreTracker();

    public ScoreTrackerView() {
        super();
        holder.setLocation(100, 30);
        addMarks(0);
    }

    public void addMarks(int i) {
        scoreTracker.addMarks(i);
        holder.remove(display);
        holder.repaint();
        display = new JLabel("Score: " + getMarks(), SwingConstants.LEFT);
        display.setForeground(Color.white);
        display.setFont(customFont);
        display.setSize(400, 120);
        holder.add(display);
        display.repaint();
        holder.repaint();
    }

    public void addRealMarks(int i) {
        scoreTracker.addRealMarks(i);
    }

    public int getMarks(){
        return scoreTracker.getMarks();
    }
    public int getRealMarks() {
        return scoreTracker.getRealMarks();
    }

    public JPanel getHolder() {
        return holder;
    }
}
