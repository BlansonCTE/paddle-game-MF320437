import java.awt.*;
import java.awt.Rectangle;

class Paddle{

    private Paddle paddle;
    private Game game;

    // Initalize Square Positions And Size( To The Left) (Player One)
    public int hsquare = 13;  //widtth  
    public int lsquare = 100; //height

    public int xsquare = 50;   //Positionx
    public int ysquare = 400;  //Positiony

    //Paddle Velocity
    public double xsquareVel = 0;
    public double ysquareVel = 0;


    // Initalize Square Positions And Size( To The Left) (Player Two)
    public int hsquare2 = 13;  //widtth  
    public int lsquare2 = 100; //height

    public int xsquare2 = 1300;   //Positionx
    public int ysquare2 = 400;  //Positiony

    //Paddle Velocity
    public double xsquareVel2 = 0;
    public double ysquareVel2 = 0;

    ///////////////////////////////////////////////Functions
    public Rectangle getBounds1(){
        return new Rectangle(xsquare,ysquare,hsquare,lsquare);
    }
    public Rectangle getBounds2(){
        return new Rectangle(xsquare2,ysquare2,hsquare2,lsquare2);
    }
    public int getTopY1(){
        return ysquare;
    }
    public int getTopY2(){
        return ysquare2;
    }

    ////////////////Constructor
    public Paddle(Game ngame){
        this.game = ngame;
    }


    /////////////////Input Functions


    public void movePaddle(){
        ysquare += ysquareVel*4;
    }

    public void movePaddle2(){
        ysquare2 += ysquareVel2*4;
    }


    public void leftpad1(){
        ysquareVel = -1.5;
        
    }
    public void rightpad1(){
        ysquareVel = 1.5;
    }

    public void leftpad2(){
        ysquareVel2 = -1.5;
        
    }
    public void rightpad2(){
        ysquareVel2 = 1.5;
    }

    public void stop1(){
        ysquareVel = 0;
    }

    public void stop2(){
        ysquareVel2 = 0;
    }







        
}