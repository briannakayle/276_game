package com.group4.app;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;




public class RegularRewardsIntegrationTest {
  
    @Test
    //test  whether adding rewards mark succeed (1 points for regularrewards)
    public void addRewardsMarkTest(){
        ScoreTrackerView scoreTrackerView = new ScoreTrackerView();
        ScoreTracker scoreTracker = new ScoreTracker();

        scoreTracker.addMarks(1);
        scoreTrackerView.addMarks(1);
        assertEquals(1, scoreTrackerView.getMarks());
        assertEquals(1, scoreTracker.getMarks());

    }
    @Test
    //test addRegularRewards method
    
    public void drawRewardTest() {
        int x=2;int y=3;
        AppWindow window = new AppWindow();
        Board board1 = new Board(null,null,null,null,window);
        board1.addRegularRewards(x,y);
        //check whether the point is null after drawing 
        if(checkGridSpot(x,y)){
            System.out.print("Failed at drawing rewards");

        }else{
            System.out.print("Succeed at drawing rewards");
        }
   
    
 }
    @Test
    //check what is print out if the point want to draw at is not null
    public void drawRewardsFullTest(){
        int x=2;int y=3;
        AppWindow window = new AppWindow();
        Board board1 = new Board(null,null,null,null,window);
        board1.addRegularRewards(2,3);
        board1.addRegularRewards(x, y);
     
     
 }
    private boolean checkGridSpot(int x, int y) {
        return false;
    }
    
   
}
