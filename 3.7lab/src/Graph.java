// 3.7 Lab
// AP Computer Science A
// Ava Scherocman
// 9/12/2019

//import swing, colors
import javax.swing.*;
import java.awt.*;
//import mouseevent and adapter
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Graph {
    //create GUI and colorpanel to display information
    public static JFrame GUI = new JFrame();
    public static ColorPanel panel = new ColorPanel(Color.white);
    public static JLabel point = new JLabel();
    public static JLabel origin = new JLabel();
    //create x,y to hold location information
    public static int x;
    public static int y;
    public static void main(String args[]) {
        //set GUI settings
        GUI.setTitle("Grid");
        GUI.setSize(600,600);
        GUI.setResizable(true);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setVisible(true);
        GUI.add(panel);

        //test if mouse has been clicked
        panel.addMouseListener(new MouseAdapter(){
            @Override
                    public void mouseClicked(MouseEvent e){
                        super.mouseClicked(e);
                        //set x and y to mouse x and y
                         x = e.getX();
                         y = e.getY();
                         //refresh panel
                        panel.repaint();
                        //set label location near the point
                        point.setLocation(x+10, y-10);
                        //set label text. size, visibility
                        point.setText(("\""+ ((panel.getWidth()/2) - e.getX())*-1) + ", " + ((panel.getHeight()/2) - e.getY()));
                        point.setSize(60,10);
                        point.setVisible(true);
                        panel.add(point);


            }


        });

    }


    static class ColorPanel extends JPanel{
        //default
        ColorPanel(){
            setBackground(Color.white);
;        }
        //fill - custom background color
        ColorPanel(Color c){
            setBackground(c);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //make a new instance of graphics2d
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2));
            //draw grid
            for (int i=0;i<getWidth();i+=10){
                g2d.drawLine(i, 0, i, getHeight());
                g2d.drawLine(0,i,getWidth(),i);
            }
            g2d.setColor(Color.black);
            g2d.setStroke(new BasicStroke(4));
            //draw x and y axis
            g2d.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
            g2d.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);

            //draw origin
            g2d.setColor(Color.magenta);
            g2d.setStroke(new BasicStroke(6));
            g2d.drawLine(getWidth()/2, getHeight()/2,getWidth()/2, getHeight()/2);
           //set label location
            origin.setLocation(((panel.getWidth()/2)+10),((panel.getHeight()/2)+10));
            origin.setText("0,0");
            origin.setSize(20,10);
            origin.setVisible(true);
            panel.add(origin);
            //draw point based on user input
            g2d.drawLine(x, y, x, y);




        }
    }
}



