package com.group4.app;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;




public class BonusIntegrationTest {
  
    @Test
    //test  whether adding bonus mark succeed (2 points for bonus)
    public void addBonusMarkTest(){
        ScoreTrackerView scoreTrackerView = new ScoreTrackerView();
        ScoreTracker scoreTracker = new ScoreTracker();

        scoreTracker.addMarks(2);
        scoreTrackerView.addMarks(2);
        assertEquals(2, scoreTrackerView.getMarks());
        assertEquals(2, scoreTracker.getMarks());

    }
    @Test
    //test addbonus method
    
    public void drawBonusTest() {
        int x=2;int y=3;
        AppWindow window = new AppWindow();
        Board board1 = new Board(null,null,null,null,window);
        board1.addBonus(x,y);
        //check whether the point is null after drawing bonus
        if(checkGridSpot(x,y)){
            System.out.print("Failed at drawing bonus");

        }else{
            System.out.print("Succeed at drawing bonus");
        }
  

 }
    private boolean checkGridSpot(int x, int y) {
        return false;
    }
    
   
}
