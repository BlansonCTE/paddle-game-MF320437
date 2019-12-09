import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.Timer;

@SuppressWarnings("serial")

//Create Our Ball Class
public class Game extends JPanel implements ActionListener, KeyListener {

    

    //////////////////////INITIALIZATION\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //Timer (Timer We Will Use To Update Frames)
    //Timer Calls Our Action Listener 
    Timer t = new Timer(5, this);

    //Values For Our Window Size
    public static int w = 1400;
    public static int h = 800;

    double dx = 1;
    double dy = 1;

    public static Ball Activeball;
    public static Paddle Activepaddle;
    

    //A Contstructor For Our Ball CLass
    //This Way When Its Created Our Timer Starts
    //So We Start Listening For Events
    public Game(){
        t.start();
        addKeyListener(this);
        setFocusable(true); //Much Like How When We Need To Type We Have
        //To Click Our Window First, This Makes It So We Can Do That
        setFocusTraversalKeysEnabled(false);
        //Allows us to recieve key events for(From) our focused window
    }

    public void paint(Graphics g) {
        // Clears the screen before reprint a circle at a new postion
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Antialising makes the figure smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Creates Player One Paddle
        g2d.setColor(Color.black);
        g2d.fillOval(Activeball.x, Activeball.y, Activeball.cx, Activeball.cy);

        //Creates Player One Paddle
        g2d.setColor(Color.black);
        g2d.fillRect(Activepaddle.xsquare, Activepaddle.ysquare, Activepaddle.hsquare, Activepaddle.lsquare);

        //Creates Player Two Paddle
        g2d.setColor(Color.black);
        g2d.fillRect(Activepaddle.xsquare2, Activepaddle.ysquare2, Activepaddle.hsquare2, Activepaddle.lsquare2);
        


    }

    //Runs The Following Code Whenever An Action is Performed
    public void actionPerformed(ActionEvent e) {
        //Repaints Scree(Clears Old Player Location)
        //And Moves The Circle(Adds To Its Position/Transform)
        repaint();
        
        
        

    }



    public void CollisionDetection(){

        ////////////////////////////////////////////////////////////////////////////////////////Check For Collision On Top And Bottom
        if(Activeball.y <= 0 || Activeball.y >= h-(Activeball.cy+10)){
            Activeball.dy = Activeball.dy * -1;
        }


        //////////////////////////////////////////////////////////////////////////////////////////Collision With Left Paddle
        if(Activeball.x <= 30 && Activeball.x >= -40){
            if(Activeball.y <= Activepaddle.ysquare+90 && Activeball.y >= Activepaddle.ysquare-40){
                Activeball.dx = Activeball.dx * -1;
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////Collision With Right Paddle
        if(Activeball.x <= w+40 && Activeball.x >= w-105){
            if(Activeball.y <= Activepaddle.ysquare2+90 && Activeball.y >= Activepaddle.ysquare2-40){
                Activeball.dx = Activeball.dx * -1;
            }
        }

        
        //////////////////////////////////////////////////////////////////////////////////////////Right Paddle Collision With Top
        if(Activepaddle.ysquare <= 0 || Activepaddle.ysquare >= h-Activepaddle.lsquare){
            Activepaddle.ysquarVel = Activepaddle.ysquarVel * -1;
        }

        //////////////////////////////////////////////////////////////////////////////////////////Left Paddle Collision With Top

        if(Activepaddle.ysquare2 <= 0 || Activepaddle.ysquare2 >= h-Activepaddle.lsquare2){
            Activepaddle.ysquarVel2 = Activepaddle.ysquarVel2 * -1;
        }
        //Activepaddle.ysquare += Activepaddle.ysquarVel*3;

        //////////////////////////////////////////////////////////////////////////////////////////Add Velocity To Paddle
        Activeball.x += Activeball.dx*2;
        Activeball.y += Activeball.dy*2;
    }

    //Check if A Key Is Pressed And Exectues The Following Commands
    public void keyPressed(KeyEvent e) {
        //Inputs Are Recieved In Integer Values
        //So We Save This Value And Check It For Up,Down,Left,or Right
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_I){
            Activeball.up(); //Then We Exxecute a Function
        }
        if(code == KeyEvent.VK_K){
            Activeball.down(); //Then We Exxecute a Function
        }
        if(code == KeyEvent.VK_J){
            Activeball.left(); //Then We Exxecute a Function
        }
        if(code == KeyEvent.VK_L){
            Activeball.right(); //Then We Exxecute a Function
        }

        if(code == KeyEvent.VK_W){
            Activepaddle.uppad1();
        }
        if(code == KeyEvent.VK_S){
            Activepaddle.downpad1();
        }

        if(code == KeyEvent.VK_UP){
            Activepaddle.uppad2();
        }
        if(code == KeyEvent.VK_DOWN){
            Activepaddle.downpad2();
        }
    }

    public void keyReleased(KeyEvent e) {
        //Because we implemented this is required to be here
    }
    public void keyTyped(KeyEvent e) {
        //Because we implemented this is required to be here
    }

    ///////////////////////////CREATE GAME\\\\\\\\\\\\\\\\\\\\\\\\
    public static void main(String[] args) throws InterruptedException {
        // Creates The Window
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        Ball ball = new Ball(game);
        Paddle paddle = new Paddle(game);
        frame.add(game);
        frame.setSize(game.w, game.h);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Activeball = ball;
        Activepaddle = paddle;
        

        
        while(true){
            game.repaint();
            Activeball.moveBall();
            Activepaddle.movePaddle();
            Activepaddle.movePaddle2();
            game.CollisionDetection();
            Thread.sleep(10);
        }
    }
}
