package com.group4.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTracker  implements ActionListener {

    private final Timer t;
    private int seconds = 0;

    public TimeTracker(ActionListener listener) {
        t = new Timer(1250,listener);
    }

    public int getSeconds(){
        return seconds;
    }

    public void stopTimer(){
        t.stop();
    }

    public void startTimer(){
        t.start();
    }

    public void addSeconds(){
        seconds++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addSeconds();
    }
}
