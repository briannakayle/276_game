package com.group4.app;

import javax.swing.*;
import java.awt.*;

class scoreTracker extends tracker {
    private int marks = 0;
    private int realMarks = 0;

    public scoreTracker() {
        super();
        holder.setLocation(100, 30);
        addMarks(0);
    }

    public void addMarks(int i) {
        marks += i;
        holder.remove(display);
        holder.repaint();
        display = new JLabel("Score: " + marks, SwingConstants.LEFT);
        display.setForeground(Color.white);
        display.setFont(customFont);
        display.setSize(400, 120);
        holder.add(display);
        display.repaint();
        holder.repaint();
    }

    public void addRealMarks(int i) {
        realMarks += i; }

    public int getRealMarks() {
        return realMarks;
    }

    public int getMarks() {
        return marks;
    }

    public JPanel getHolder() {
        return holder;
    }
}