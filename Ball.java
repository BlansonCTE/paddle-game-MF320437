import java.awt.*;
import java.awt.Rectangle;

class Ball{
    
    ///////////////////////////////////////////////Variables
    private Game game;
    public boolean RectCol;
    Color ballcolor = new Color(0,0,0);

    // Initialize Ball Positions And Size (In Center)
    public int x = 700-60;
    public int y = 400-60;
    public int cx = 60;
    public int cy = 60;

    double dx,dy;
    //Ball Velocity
    

    //Return balls X,Y, and Size
    public Rectangle getBounds(){
        return new Rectangle(x,y,cx,cy);
    }
    private boolean collision(){
        if(game.Activepaddle.getBounds1().intersects(getBounds())){
            return(true);
        }
        else if(game.Activepaddle.getBounds2().intersects(getBounds())){
            return(true);
        }
        else{
            return false;
        }
        
    }

    ////////////////Constructor
    public Ball(Game ngame){
        this.game = ngame;
        dx = game.BallSpeed;
        dy = game.BallSpeed;
    }


    public void moveBall(){
        x += dx*game.BallSpeed;
        y += dy*game.BallSpeed;
        if(collision()){
            dx *= -1;
            game.BallSpeed += 1;
        }
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