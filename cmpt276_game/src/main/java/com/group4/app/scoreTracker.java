package com.group4.app;

import javax.swing.*;
import java.awt.*;

class scoreTracker extends tracker{
    private int marks = 0;
    public scoreTracker() {
        super();
        holder.setLocation(100,30);
        addMarks(0);
    }

    public void addMarks(int i){
        marks += i;
        holder.remove(display);
        holder.repaint();
        display = new JLabel("Score: " + marks, SwingConstants.LEFT);
        display.setForeground(Color.white);
        display.setFont(customFont);
        display.setSize(400,120);
        holder.add(display);
        display.repaint();
        holder.repaint();

    }
    public int getMarks(){
        return marks;
    }

    public JPanel getHolder() {
        return holder;
    }
    public JLabel getDisplay(){
        return display;
    }
}