import java.awt.*;


class Paddle{

    private Paddle paddle;
    private Game game;

    // Initalize Square Positions And Size( To The Left) (Player One)
    public int hsquare = 13;  //widtth  
    public int lsquare = 100; //height

    public int xsquare = 25;   //Positionx
    public int ysquare = 250;  //Positiony

    //Paddle Velocity
    public double xsquareVel = 0;
    public double ysquarVel = 0;


    // Initalize Square Positions And Size( To The Left) (Player Two)
    public int hsquare2 = 13;  //widtth  
    public int lsquare2 = 100; //height

    public int xsquare2 = 1350;   //Positionx
    public int ysquare2 = 250;  //Positiony

    //Paddle Velocity
    public double xsquareVel2 = 0;
    public double ysquarVel2 = 0;

    ///////////////////////////////////////////////Functions

    ////////////////Constructor
    public Paddle(Game ngame){
        this.game = ngame;
    }


    /////////////////Input Functions


    public void movePaddle(){
        ysquare += ysquarVel*4;
    }

    public void movePaddle2(){
        ysquare2 += ysquarVel2*4;
    }


    public void uppad1(){
        ysquarVel = -1.5;
        
    }
    public void downpad1(){
        ysquarVel = 1.5;
    }

    public void uppad2(){
        ysquarVel2 = -1.5;
        
    }
    public void downpad2(){
        ysquarVel2 = 1.5;
    }







        
}