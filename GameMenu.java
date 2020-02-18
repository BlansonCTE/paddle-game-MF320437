import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
public class GameMenu extends JPanel{
    public static int w = 1400;
    public static int h = 800;
    public static Boolean isMenue = true;
    public int Balance;

    public List<String> colors = Arrays.asList("Green,Blue,Yellow,Red");
    public List<JButton> custom_buttons;

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

    JButton MicroTransaction(JFrame frame){
        JButton Micro_Button = new JButton("REMOVE ADS");
        Micro_Button.setBounds(975,650,250,100);
        frame.add(Micro_Button);
        return(Micro_Button);
    }



    
    void EnableMenue(){
        isMenue = true;
    }

    public void MicroTran(JFrame newframe) {
        String Options[] = {"BUY", "COST","Exit"};
        int x = JOptionPane.showOptionDialog(null, "ADS!", "Ad Menu", JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
        if(x == 0){
            System.out.print("YOUR TOO POOR!");
        }
        if(x == 1){
            System.out.print("9.99$ Payed To Martineus Fearon Owner Of EAA");
        }
        if(x == 2){
            System.out.print("Exit!");
            System.exit(ABORT);
        }
        
    }

    
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Main Menu");
        GameMenu Menue = new GameMenu();
        boolean Running = true;
        isMenue = true;
        
        frame.add(Menue);
        frame.setLayout(null);
        frame.setSize(Menue.w, Menue.h);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create start button
        JButton StartButton = Menue.createStartButton(frame);
        JButton QuitButton = Menue.createQuitButton(frame);
        JButton MicroButton = Menue.MicroTransaction(frame);


        

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



                if(MicroButton.getModel().isPressed()){
                    Menue.MicroTran(frame);
                    Running = false; //Disable Button
                    System.exit(ABORT);
                }
            }
        }


        

        



    }
}