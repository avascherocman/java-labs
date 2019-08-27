// Grid 3x3 Lab
// AP Computer Science A
// Ava Scherocman
// 8/21/2019

//import swing, colors
import javax.swing.*;
import java.awt.*;

public class Grid3x3 {
    //create width and height variables
    public static int width;
    public static int height;
    //create GUI JFrame
    public static JFrame GUI = new JFrame();
    //create container pane
    public static Container pane = GUI.getContentPane();
    public static void main (String[] args) {
        //answer used to test do while loop
        int answer = JOptionPane.YES_OPTION;
        do {
            //create GUI
            createGUI();
            //remove all previous panels from pane (clear)
            pane.removeAll();
            //ask user for dimensions of grid
            getDimensions();
            //display grid
            displayPanels();
            //set answer to user input using dialog box
            answer=JOptionPane.showConfirmDialog(null,
                    "Would you like to run again?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
           //if answer is no, close program
            if (answer==JOptionPane.NO_OPTION){
                System.exit(0);
            }
            //continue running loop until answer is "no" or "cancel"
        } while (answer!=JOptionPane.NO_OPTION && answer!= JOptionPane.CANCEL_OPTION);
    }
    public static void getDimensions (){
        //create new dialog box and set visible
        JOptionPane askDimensions = new JOptionPane();
        askDimensions.setVisible(true);
        height=0;
        width=0;
        //set width and height to user input from dialog box
        width = Integer.parseInt(JOptionPane.showInputDialog("Enter width"));
        height = Integer.parseInt(JOptionPane.showInputDialog("Enter height"));
    }
    public static void createGUI(){
        //set grid title, size, and other settings
        GUI.setTitle("Grid");
        GUI.setSize(600,600);
        GUI.setResizable(true);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setVisible(true);
    }
    public static void createPanel(){
        //create new pane and set layout to width x height
        pane.setLayout(new GridLayout(width,height));
        //create new panel
        JPanel panel = new JPanel();
        //generate 3 random r, g, and b values
        int r = (int)(Math.random() *254+ 1);
        int g = (int)(Math.random() *254+ 1);
        int b = (int)(Math.random() *254+ 1);
        //set panel color to random colors
        panel.setBackground(new Color (r, g, b));
        //add panel to pane
        pane.add(panel);
    }
    public static void displayPanels(){
        //set number of panels to width x height
        int numPanels = width*height;
        int n = 1;
        //create panels from number given
        while (n<numPanels){
            //create panel
            createPanel();
            n++;
        }
        //set GUI visible
        GUI.setVisible(true);
    }
}
