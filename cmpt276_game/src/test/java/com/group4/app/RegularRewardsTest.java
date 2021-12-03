package com.group4.app;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegularRewardsTest {

    @Test
    public void positionTest() {
        int x = 110;
        int y = 330;
        RegularRewards regularRewards = new RegularRewards(x, y);
        assertEquals(x, regularRewards.getX());
    }

    @Test
    public void drawTest() {
        int x=0;int y=2;
        AppWindow window = new AppWindow();
        Board board1 = new Board(null,null,null,null,window);
        board1.addRegularRewards(x,y);
    }
 
    
}