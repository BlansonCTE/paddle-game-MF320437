import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public static Color player1Color = new Color(200,13,13);
    public static Color player2Color = new Color(13,13,200);

    public static int Player1Score = 0;
    public static int Player2Score = 0;

    public static Game Activegame;
    public static JFrame Activeframe;

    public  int BallSpeed = 1;
    public  int PaddleSpeed = 1;

    public static boolean Paused;
    public static GameMenu Menu;

    Game(GameMenu menu){
        Menu= menu;
    }

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

        Font verdan = new Font("Verdana", Font.BOLD, 30);

        //Draw Scores
        g.setColor(Color.gray);
        g.setFont(verdan);
        g.drawString(Integer.toString(Player1Score),400,100);
        g.drawString(Integer.toString(Player2Score),900,100);


        // Antialising makes the figure smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Creates Ball
        g2d.setColor(Color.black);
        g2d.fillOval(Activeball.x, Activeball.y, Activeball.cx, Activeball.cy);

        //Creates Player One Paddle
        g2d.setColor(player1Color);
        g2d.fillRect(Activepaddle.xsquare, Activepaddle.ysquare, Activepaddle.hsquare, Activepaddle.lsquare);

        //Creates Player Two Paddle
        g2d.setColor(player2Color);
        g2d.fillRect(Activepaddle.xsquare2, Activepaddle.ysquare2, Activepaddle.hsquare2, Activepaddle.lsquare2);
        
        


    }

    //Runs The Following Code Whenever An Action is Performed
    public void actionPerformed(ActionEvent e) {
        //Repaints Scree(Clears Old Player Location)
        //And Moves The Circle(Adds To Its Position/Transform)
        repaint();
        
        
        

    }



    public void CollisionDetection() throws InterruptedException {

        ////////////////////////////////////////////////////////////////////////////////////////Check For Collision On Top And Bottom
        if(Activeball.y <= 0){
            Activeball.dy *= -1;
            // if(Activeball.x <= Activepaddle.xsquare+85 && Activeball.x >= Activepaddle.xsquare-60){
            //     Activeball.dy = Activeball.dy * -1;
            // }
            // if(Activeball.y <= -10){
            //     Activeball.dy *= -1;
            //     Activeball.y += 2;
            //     Player1Score++;
            //     BallSpeed = 1;
            //     //Scored(1, Activeframe, Activegame); 
            // }
            
        }
        if(Activeball.y >= h-(Activeball.cy+10)){
            Activeball.dy *= -1;
            // if(Activeball.x <= Activepaddle.xsquare2+85 && Activeball.x >= Activepaddle.xsquare2-60){
            //     Activeball.dy = Activeball.dy * -1;
            // }
            // if(Activeball.y >= 720){
            //     Activeball.dy *= -1;
            //     Activeball.y -= 2;
            //     Player2Score++;
            //     BallSpeed = 1;
            //     //Scored(2, Activeframe, Activegame); 
            // }
        }


        //////////////////////////////////////////////////////////////////////////////////////////Collision With Left
         if(Activeball.x <= -10 && Activeball.x >= -40){
            Scored(1, Activeframe, Activegame,Activeball);
            Player2Score++;
            Activeball.dx *= -1;
            Activeball.x += 10;
            if(BallSpeed < 3){
                BallSpeed = 1;
            }
         }

         //////////////////////////////////////////////////////////////////////////////////////////Collision With Right
        if(Activeball.x >= w+50 ){ //&& Activeball.x >= w-105
            Scored(2, Activeframe, Activegame,Activeball);
            Player1Score++;
            Activeball.dx *= -1;
            Activeball.x -= 10;
            if(BallSpeed < 3){
                BallSpeed = 1;
            }
            
        }

        
        // //////////////////////////////////////////////////////////////////////////////////////////Right Paddle Collision With Top
        if(Activepaddle.ysquare <= 0 ){
            Activepaddle.ysquare = 1;
        }
        if(Activepaddle.ysquare >= h-(Activepaddle.lsquare+20)){
            Activepaddle.ysquare = h-(Activepaddle.lsquare+20);
        }

        

        //////////////////////////////////////////////////////////////////////////////////////////Left Paddle Collision With Top

        if(Activepaddle.ysquare2 <= 0 ){
            Activepaddle.ysquare2 = 1;
        }
        if(Activepaddle.ysquare2 >= h-(Activepaddle.lsquare2+20)){
            Activepaddle.ysquare2 = h-(Activepaddle.lsquare2+20);
        }
        //Activepaddle.ysquare += Activepaddle.ysquarVel*3;

        //////////////////////////////////////////////////////////////////////////////////////////Add Velocity To Paddle
        Activeball.x += Activeball.dx*3;
        Activeball.y += Activeball.dy*3;
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
            Activepaddle.leftpad1();
        }
        if(code == KeyEvent.VK_S){
            Activepaddle.rightpad1();

        }

        if(code == KeyEvent.VK_UP){
            Activepaddle.leftpad2();
        }
        if(code == KeyEvent.VK_DOWN){
            Activepaddle.rightpad2();
        }



        //Pause
        if(code == KeyEvent.VK_P){
            if(!Paused){
                Pause(Activeframe);
            }
            else{

            }
            
        }
    }

    public void Pause(JFrame frame) {
        Paused = true;
        String Options[] = {"Unpause", "Save","Exit"};
        int x = JOptionPane.showOptionDialog(null, "Paused!", "Pause Menu", JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
        if(x == 0){
            Paused = false;
            System.out.print("UnPaused!");
        }
        if(x == 1){
            Paused = false;
            String content = ("Score:"+Player1Score+Player2Score+" Key: Password");
            String path = ("U:/VStudio/Github/Project1/Moveball- MF320437/paddle-game-MF320437/score.txt");
            try {
                Files.write(Paths.get(path),content.getBytes());
            } catch (IOException e) {
                //TODO: handle exception
            }
            
            System.out.print("Saving!");
        }
        if(x == 2){
            Paused = false;
            System.out.print("Exit!");
            Menu.EnableMenue();
            System.exit(ABORT);
        }
        
    }


    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        //Because we implemented this is required to be here
        if(code == KeyEvent.VK_W){
            Activepaddle.stop1();
        }
        if(code == KeyEvent.VK_S){
            Activepaddle.stop1();
        }
        if(code == KeyEvent.VK_UP){
            Activepaddle.stop2();
        }
        if(code == KeyEvent.VK_DOWN){
            Activepaddle.stop2();
        }
    }
    public void keyTyped(KeyEvent e) {
        //Because we implemented this is required to be here
    }



    void Scored(int Player, JFrame f,Game game, Ball b) throws InterruptedException {
        if(Player == 1){
            JOptionPane.showMessageDialog(f, "Player 1 SCORED!");
            b.x = w/2;
            b.y = h/2;
            BallSpeed = 1;
            Thread.sleep(1000);
            if(Player1Score >= 3){
                JOptionPane.showMessageDialog(f, "Player 1 WON!");
            }
        }
        else{
            
            JOptionPane.showMessageDialog(f, "Player 2 SCORED!");
            b.x = w/2;
            b.y = h/2;
            BallSpeed = 1;
            Thread.sleep(1000);
            if(Player2Score >= 3){
                JOptionPane.showMessageDialog(f, "Player 2 WON!");
            }
        }
        
    }

     public static void CallMain() throws InterruptedException{
         System.out.println("Calling Main");
         main(null);
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

        frame.getContentPane().setBackground(Color.blue);
        Activeball = ball;
        Activepaddle = paddle;
        Activegame = game; 
        Activeframe = frame;
        

        //JOptionPane.showMessageDialog(frame, "Press Enter To Start!");
        JOptionPane.showConfirmDialog(frame, "Player 1 Ready?","Ready Up!",JOptionPane.YES_NO_OPTION);
        JOptionPane.showConfirmDialog(frame, "Player 2 Ready?","Ready Up!", JOptionPane.YES_NO_OPTION);
        
        

        //Add Logo
        //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
        while(true){
            while(!Paused){
                game.repaint();
                Activeball.moveBall();
                Activepaddle.movePaddle();
                Activepaddle.movePaddle2();
                game.CollisionDetection();
                
                
                Thread.sleep(10);
    
            
               
            }
        }
        
    }
}
