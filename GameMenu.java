import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class GameMenu extends JPanel{
    public static int w = 1400;
    public static int h = 800;
    public static Boolean isMenue = true;

    JButton createStartButton(JFrame frame){
        JButton start_Button = new JButton("PLAY");
        start_Button.setBounds(575,500,250,100);
        frame.add(start_Button);
        return(start_Button);
    }
    JButton createQuitButton(JFrame frame){
        JButton quit_Button = new JButton("QUIT");
        quit_Button.setBounds(575,650,250,100);
        frame.add(quit_Button);
        return(quit_Button);
    }
    void EnableMenue(){
        isMenue = true;
    }

    
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Main Menu");
        GameMenu Menue = new GameMenu();
        boolean Running = true;

        frame.add(Menue);
        frame.setLayout(null);
        frame.setSize(Menue.w, Menue.h);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create start button
        JButton StartButton = Menue.createStartButton(frame);
        JButton QuitButton = Menue.createQuitButton(frame);


        //Get Button Clicks
        while(Running == true){
            if(isMenue){
                if(StartButton.getModel().isPressed()){
                    System.out.print("Pressed Start");
                    Running = false; //Disable Button
                    Game game = new Game(Menue);
                    game.CallMain();
                    isMenue = false;
                    
                }
    
                if(QuitButton.getModel().isPressed()){
                    System.out.print("Pressed QUIT");
                    Running = false; //Disable Button
                    System.exit(ABORT);
                }
            }
        }


        

        



    }
}