// Grid 3x3 Project
// AP Computer Science A
// Ava Scherocman
// 8/21/2019

//import Scanner, Swing, Colors
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Grid3x3 {
    //create width and height variables
    public static int width;
    public static int height;
    //create GUI JFrame
    public static JFrame GUI = new JFrame();
    public static void main (String[] args) {
        //create GUI
        createGUI();
        //ask user for dimensions of grid
        getDimensions();
        //display grid
        displayPanels();
    }
    public static void getDimensions (){
        //create new dialog box and set visible
        JOptionPane askDimensions = new JOptionPane();
        askDimensions.setVisible(true);
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
        Container pane = GUI.getContentPane();
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
