package com.group4.app;

import javax.swing.*;
import java.awt.*;

public class ScoreTracker {
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
