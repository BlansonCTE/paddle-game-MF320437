import javax.swing.*;
import java.awt.*;

public class FramePanel{
    public static void main(String[] args) {

        //Create the frame.
        Frame f = new Frame();

        //makes the close button operational
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //makes the window appear
        f.setVisible(true);
    }
}
class Frame extends JFrame{

    public Frame() {

        setTitle("Blanson Rocks!");
        setSize(300,200);
        setLocation(100,200);

        /*Panel is the simplest container class. A panel provides
        space in which an application can attach any other 
         component, including other panels.*/
        Panel panel = new Panel();

        /*A container is an AWT/Swing object that can 
        hold other components. It's like a drawing area
        where you assign it to use a layout manager to 
        determine how and where components are place.*/
        Container cp = getContentPane();

        // adding the panel to the container 
        cp.add(panel);
    }
}
class Panel extends JPanel{

    public void paintComponent(Graphics g){

        //draw background
        super.paintComponent(g);

        //What to draw, and where
        g.drawString("Hi", 75, 100);
    }
}