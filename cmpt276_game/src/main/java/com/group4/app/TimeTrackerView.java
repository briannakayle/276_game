package com.group4.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TimeTrackerView extends tracker implements ActionListener {
    TimeTracker timeTracker = new TimeTracker();

    public TimeTrackerView(){
        super();
        timeTracker.startTimer();
        holder.setLocation(650,30);
        refresh();
    }
    private void refresh(){
        holder.remove(display);
        holder.repaint();
        display = new JLabel("Time: " + timeTracker.getSeconds(), SwingConstants.LEFT);
        display.setForeground(Color.white);
        display.setFont(customFont);
        display.setSize(400,120);
        holder.add(display);
        display.repaint();
        holder.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timeTracker.actionPerformed(e);
        refresh();
    }
}