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
public class Ball extends JPanel implements ActionListener, KeyListener {

    

    //////////////////////INITIALIZATION\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //Timer (Timer We Will Use To Update Frames)
    //Timer Calls Our Action Listener 
    Timer t = new Timer(5, this);

    //Values For Our Window Size
    public int w = 1400;
    public int h = 800;

    // Initialize Ball Positions And Size (In Center)
    public int x = 700-60;
    public int y = 400-60;
    public int sx = 60;
    public int sy = 60;

    double dx;
    double dy;

    

    //A Contstructor For Our Ball CLass
    //This Way When Its Created Our Timer Starts
    //So We Start Listening For Events
    public Ball(){
        t.start();
        addKeyListener(this);
        setFocusable(true); //Much Like How When We Need To Type We Have
        //To Click Our Window First, This Makes It So We Can Do That
        setFocusTraversalKeysEnabled(false);
        //Allows us to recieve key events for(From) our focused window
    }

    //////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    


    

    //////////////////////////CREATES BALL\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public void paint(Graphics g) {
        // Clears the screen before reprint a circle at a new postion
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Antialising makes the figure smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draws the circle at new positionw ith same diameter
        g2d.setColor(Color.black);
        g2d.fillOval(x, y, sx, sy);
    }

    

    ////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\



    //////////////////////////INPUT MANAGER(TICK)\\\\\\\\\\\\\\\\\\\\\\\\\\\
    //Check if A Key Is Pressed And Exectues The Following Commands
    public void keyPressed(KeyEvent e) {
        //Inputs Are Recieved In Integer Values
        //So We Save This Value And Check It For Up,Down,Left,or Right
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP){
            up(); //Then We Exxecute a Function
        }
        if(code == KeyEvent.VK_DOWN){
            down(); //Then We Exxecute a Function
        }
        if(code == KeyEvent.VK_LEFT){
            left(); //Then We Exxecute a Function
        }
        if(code == KeyEvent.VK_RIGHT){
            right(); //Then We Exxecute a Function
        }
    }


    //Runs The Following Code Whenever An Action is Performed
    public void actionPerformed(ActionEvent e) {
        //Repaints Scree(Clears Old Player Location)
        //And Moves The Circle(Adds To Its Position/Transform)
        repaint();
        if(x <= 0 || x >= w-sx ){
            dx = dx * -1;
        }
        if(y <= 0 || y >= h-sy){
            dy = dy * -1;
        }
        x += dx*3;
        y += dy*3;
        
        

    }

    //Sets The Values Being Added To Circle Movement
    //Based On Player Input
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
    /////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\



    ///////////////////////////CREATE GAME\\\\\\\\\\\\\\\\\\\\\\\\
    public static void main(String[] args) throws InterruptedException {
        // Creates The Window
        JFrame frame = new JFrame("Mini Tennis");
        Ball game = new Ball();
        frame.add(game);
        frame.setSize(game.w, game.h);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame,"Cordinates"+game.x+" "+game.y);
        
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

