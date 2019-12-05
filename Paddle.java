import java.awt.*;


class Paddle implements ActionListener, KeyListener{

    private Paddle paddle;

    // Initalize Square Positions And Size( To The Left) (Player One)
    public int hsquare = 10;  //widtth  
    public int lsquare = 100; //height

    public int xsquare = 0;
    public int ysquare = 250;

    //Paddle Velocity
    public int xsquareVel = 0;
    public int ysquarVel = 0;

    ///////////////////////////////////////////////Functions

    ////////////////Constructor
    public Paddle(Game game){
        this.game = game;
    }


    ////////////////Move Paddle
    public void paint(Graphics g) {
        // Clears the screen before reprint a circle at a new postion
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Antialising makes the figure smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draws the circle at new positionw ith same diameter
        g2d.setColor(Color.black);
        g2d.fillOval(x, y, cx, cy);


    }

    /////////////////Input Functions

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











            //Creates Player One Paddle
            g2d.setColor(Color.black);
            g2d.fillRect(xsquare, ysquare, hsquare, lsquare);
    
            //Creates Player Two Paddle
            g2d.setColor(Color.black);
            g2d.fillRect(xsquare2, ysquare2, hsquare2, lsquare2);
    
            
}