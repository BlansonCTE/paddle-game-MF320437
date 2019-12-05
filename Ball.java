import java.awt.*;

class Ball implements ActionListener, KeyListener{
    
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

    ///////////////////////////////////////////////Functions

    ////////////////Constructor
    public Ball(Game game){
        this.game = game;
    }


    ////////////////Move Ball
    public void paint(Graphics g) {
        // Clears the screen before reprint a circle at a new postion
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Antialising makes the figure smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Creates Player One Paddle
        g2d.setColor(Color.black);
        g2d.fillRect(xsquare, ysquare, hsquare, lsquare);


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
}