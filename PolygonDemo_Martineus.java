//Martineus Fearon
import java.awt.*;
import javax.swing.JFrame;
import java.awt.Polygon;

public class PolygonDemo_Martineus extends Canvas{
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.drawString("Hey, a triagle!",50,50);

        Polygon tri = new Polygon();
        tri.addPoint(100, 100);
        tri.addPoint(100, 300);
        tri.addPoint(200, 300);

        g.setColor(Color.blue);
        g.fillPolygon(tri);

        Polygon pent = new Polygon();
        
        pent.addPoint(450, 200);
        pent.addPoint(500, 250);
        pent.addPoint(475, 350);
        pent.addPoint(425, 350);
        pent.addPoint(400, 250);

        g.setColor(Color.green);
        g.fillPolygon(pent);

        //Pentagon with changed order
        Polygon pentChanged = new Polygon();
        pentChanged.addPoint(475+100, 350+100);
        pentChanged.addPoint(450+100, 200+100);
        pentChanged.addPoint(400+100, 250+100);
        pentChanged.addPoint(500+100, 250+100);
        pentChanged.addPoint(425+100, 350+100);
        

        g.setColor(Color.red);
        g.fillPolygon(pentChanged);

        //Trapezoid
        Polygon Trap = new Polygon();
        Trap.addPoint(500/2, 250/2);
        Trap.addPoint(600/2, 350/2);
        Trap.addPoint(350/2, 350/2);
        Trap.addPoint(400/2, 250/2);
        

        g.setColor(Color.yellow);
        g.fillPolygon(Trap);

        Polygon hex = new Polygon();

        //Use Trig to make a regular hexagon
        int radius = 100;
        int xCenter = 200;
        int yCenter = 500;

        for(double ang = 0; ang<2*Math.PI; ang = ang+(2*Math.PI)/6.0){
            double xDelta = radius * Math.cos(ang);
            double yDelta = -radius * Math.sin(ang);
            hex.addPoint(xCenter+(int)xDelta, yCenter+(int)yDelta);
        }

        g.setColor(Color.black);
        g.fillPolygon(hex);

    }

    public static void main(String[] args) {
        JFrame win = new JFrame("Polygon Demo");
        win.setSize(1024, 768);

        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.add(new PolygonDemo_Martineus());
        win.setVisible(true);

    }
}

//Changing the order of the points will result in a deformity
//As lines are created from the first given point to the next and so on

//Trapezoid On line 41