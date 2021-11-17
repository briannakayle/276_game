package com.group4.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class timeTracker extends tracker implements ActionListener {
    private Timer t;
    private int seconds = 0;

    public timeTracker(){
        super();
        t = new Timer(1250,this);
        t.start();
        holder.setLocation(650,30);
        refresh();
    }
    private void refresh(){
        holder.remove(display);
        holder.repaint();
        display = new JLabel("Time: " + seconds, SwingConstants.LEFT);
        display.setForeground(Color.white);
        display.setFont(customFont);
        display.setSize(400,120);
        holder.add(display);
        display.repaint();
        holder.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        seconds++;
        refresh();
    }
}
