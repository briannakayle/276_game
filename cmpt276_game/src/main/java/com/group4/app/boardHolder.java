package com.group4.app;

import javax.swing.*;

class boardHolder extends JPanel {
    private final Board held;
    public boardHolder(Board toHold){
        held = toHold;
        held.setHolder(this);
        setSize(1024,880);
        add(toHold);
        setDoubleBuffered(true);
        setOpaque(false);
    }
    public Board getHeld(){
        return held;
    }
}