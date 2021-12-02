package com.group4.app;
import org.junit.jupiter.api.Test;



public class BarrierIntegrationTest {
   
    @Test
    //test addbarrier method
    
    public void drawBarrierTest() {
        int x=2;int y=3;
        AppWindow window = new AppWindow();
        Board board1 = new Board(null,null,null,null,window);
        board1.addBarrier(x,y);
        //check whether the point is null after drawing 
        if(checkGridSpot(x,y)){
            System.out.print("Failed at drawing barrier");

        }else{
            System.out.print("Succeed at drawing barrier");
        }
        

    }
    @Test
    //check if the point what to draw barrier at is not null
    public void drawBarrierFullTest(){
        int x=2;int y=3;
        AppWindow window = new AppWindow();
        Board board1 = new Board(null,null,null,null,window);
        board1.addBarrier(2,3);
        board1.addBarrier(x, y);
        
        
    }
    private boolean checkGridSpot(int x, int y) {
        return false;
    }
}
