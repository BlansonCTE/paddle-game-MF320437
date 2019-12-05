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
    public int w = 1400;
    public int h = 800;

    double dx = 1;
    double dy = 1;

    

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

    //////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    
    ////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\



    //////////////////////////INPUT MANAGER(TICK)\\\\\\\\\\\\\\\\\\\\\\\\\\\
    

    //Runs The Following Code Whenever An Action is Performed
    public void actionPerformed(ActionEvent e) {
        //Repaints Scree(Clears Old Player Location)
        //And Moves The Circle(Adds To Its Position/Transform)
        repaint();
        if(ball.x >= w-cx ){
            ball.dx = ball.dx * -1;
        }
        if(ball.y <= 0 || ball.y >= h-(cy+10)){
            ball.dy = ball.dy * -1;
        }


        //Checks For Collision With Left Rectangle
        if(ball.x <= 5 && ball.x >= -5){
            if(ball.y <= paddle.ysquare+90 && ball.y >= paddle.ysquare-90){
                dx = dx * -1;
            }
        }

        //Add Velocity
        ball.x += dx*2;
        ball.y += dy*2;

        if(paddle.ysquare <= 0 || paddle.ysquare >= h-paddle.lsquare){
            paddle.ysquarVel = paddle.ysquarVel * -1;
        }

        paddle.ysquare += paddle.ysquarVel*3;
        
        

    }

    //Check if A Key Is Pressed And Exectues The Following Commands
    public void keyPressed(KeyEvent e) {
        //Inputs Are Recieved In Integer Values
        //So We Save This Value And Check It For Up,Down,Left,or Right
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP){
            ball.up(); //Then We Exxecute a Function
        }
        if(code == KeyEvent.VK_DOWN){
            ball.down(); //Then We Exxecute a Function
        }
        if(code == KeyEvent.VK_LEFT){
            ball.left(); //Then We Exxecute a Function
        }
        if(code == KeyEvent.VK_RIGHT){
            ball.right(); //Then We Exxecute a Function
        }


        // //Paddle Controls
        // if(code == KeyEvent.VK_W){
        //     upPad(); //Then We Exxecute a Function
        // }
        // if(code == KeyEvent.VK_S){
        //     downPad(); //Then We Exxecute a Function
        // }

        // //Paddle Player two Controls
        // if(code == KeyEvent.VK_I){
        //     upPad2(); //Then We Exxecute a Function
        // }
        // if(code == KeyEvent.VK_K){
        //     downPad2(); //Then We Exxecute a Function
        // }
    }



    ///////////////////////////CREATE GAME\\\\\\\\\\\\\\\\\\\\\\\\
    public static void main(String[] args) throws InterruptedException {
        // Creates The Window
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        Ball ball = new Ball();
        Paddle paddle = new Paddle();
        frame.add(game);
        frame.setSize(game.w, game.h);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }




    //UN USED COMPONENTS

    public void keyReleased(KeyEvent e) {
        //Because we implemented this is required to be here
    }
    public void keyTyped(KeyEvent e) {
        //Because we implemented this is required to be here
    }


    //Old But Not UseLess Code


    //while (true) {

        //game.repaint();

        // Tells the processer that the thread which is being run must sleep for 10
        // miliseconds
        //Thread.sleep(10);
}
        //game.moveBall();

        
        //This
    //private void moveBall() {
      //  x += dx;
        //y += dy;
    //}

