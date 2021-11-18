package com.group4.app;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class tracker{
    protected final JPanel holder;
    protected JLabel display;
    protected Font customFont;
    public tracker(){
        holder = new JPanel();
        display = new JLabel("",SwingConstants.LEFT);
        display.setForeground(Color.white);

        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/font.ttf")).deriveFont(48f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) { System.out.println("Could not find specified font"); }

        display.setFont(customFont);
        display.setSize(400,120);
        holder.setSize(400,120);
        holder.setLocation(100,30);
        holder.add(display);
        holder.setOpaque(false);
    }

    public JPanel getHolder() {
        return holder;
    }
}