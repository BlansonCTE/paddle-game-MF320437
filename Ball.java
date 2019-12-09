import java.awt.*;

class Ball{
    
    ///////////////////////////////////////////////Variables
    private Game game;

    // Initialize Ball Positions And Size (In Center)
    public int x = 700-60;
    public int y = 400-60;
    public int cx = 60;
    public int cy = 60;

    //Ball Velocity
    double dx = 1;
    double dy = 1;



    ////////////////Constructor
    public Ball(Game ngame){
        this.game = ngame;
    }


    public void moveBall(){
        x += dx*2;
        y += dy*2;
    }


    public void up(){
        dy = -1.5;
        dx = 0;
        
    }
    public void down(){
        dy = 1.5;
        dx = 0;
    }

    public void left(){
        dx = -1.5;
        dy = 0;
    }
    public void right(){
        dx = 1.5;
        dy = 0;
    }
}