package com.group4.app;

import org.junit.Test;
import java.awt.event.ActionEvent;
import static org.junit.Assert.*;

public class NonAnimatedEnemyTest {
    NonAnimatedEnemy na_enemy = new NonAnimatedEnemy(0,0);
    @Test
    public void shouldCreateNonAnimatedEnemy(){
        assertNotNull( na_enemy);
    }
    @Test
    public void shouldGetIdentifier() {
        assertEquals("NAE", na_enemy.getIdentifier());
    }

    @Test
    public void shouldChangeFrameCount(){
        int fc = na_enemy.frameCount;
        na_enemy.frameCount++;
        assertEquals(fc+1, na_enemy.frameCount);
    }

    @Test
    public void testActionPerformed(){
        ActionEvent e = new ActionEvent(na_enemy.t, 0, null );
        //if fc==0
        na_enemy.frameCount =0;
        na_enemy.actionPerformed(e);
        na_enemy.t.stop();
        assertEquals(1, na_enemy.frameCount);
        //else
        na_enemy.frameCount = 1;
        int fc_prev = na_enemy.frameCount;
        na_enemy.actionPerformed(e);
        na_enemy.t.stop();
        assertEquals(fc_prev-1, na_enemy.frameCount);
    }

}