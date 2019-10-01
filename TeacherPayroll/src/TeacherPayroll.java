import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TeacherPayroll {
    public static void main(String args[]) {
        //create GUI
        JFrame GUI = new JFrame();
        //create string of titles to apply to labels
        String[] labelTitles = {"Base Salary", "Education Level (0-Bachelor, 1-Master, 2-Doctorate", "Years Teaching"};
        //create array of labels
        JLabel[] labels = new JLabel[3];
        //create array of text fields for input
        JTextField[] textFields = new JTextField[7];
        //loop through all categories and add arrays of text fields and labels to GUI
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(labelTitles[i]);
            GUI.add(labels[i]);
            textFields[i] = new JTextField("", 25);
            GUI.add(textFields[i]);
        }
        //create menu buttons
        JButton calculate = new JButton("Calculate pay");
        JButton openFile = new JButton("Open file");
        //add buttons to GUI
        GUI.add(calculate);
        GUI.add(openFile);
        //set GUI layout to flow with objects
        GUI.setLayout(new FlowLayout());
        //set GUI settings
        GUI.setResizable(true);
        GUI.setSize(325, 250);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setVisible(true);

        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculatePay(Integer.parseInt(textFields[0].getText()), Integer.parseInt(textFields[1].getText()), Integer.parseInt(textFields[2].getText()));
                showTable(Integer.parseInt(textFields[0].getText()));
            }
        });

        openFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int base = 0;
                int level = 0;
                int years = 0;
                String strLine = "";
                try {
                    int i = 0;
                    BufferedReader br = new BufferedReader(new FileReader("src/teacherpayroll.txt"));
                    while (i < 3) {
                        strLine = br.readLine();
                        if (i == 0) {
                            base = Integer.parseInt(strLine);
                        } else if (i == 1) {
                            level = Integer.parseInt(strLine);
                        } else if (i == 2) {
                            years = Integer.parseInt(strLine);
                        }
                        i++;
                        if (strLine == null)
                            break;

                    }
                    br.close();
                } catch (FileNotFoundException f) {
                    System.err.println("File not found");
                } catch (IOException f) {
                    System.err.println("Unable to read the file.");
                }
                calculatePay(base, level, years);
                showTable(base);
            }
        });
    }

    public static int calculatePay(int base, int level, int years) {
        //create GUI
        JFrame GUI = new JFrame();
        int pay = base + (500 * level) + (1000 * years);
        JOptionPane.showMessageDialog(GUI, ("$") + Integer.toString(pay), "Your pay", JOptionPane.INFORMATION_MESSAGE);
        return pay;
    }

    public static void showTable(int base) {

                Frame GUI = new JFrame();
        String[] tableTitles = new String[]{"Years", "Bachelors", "Masters", "PhD"};
        JTable table = new JTable(getSalaryTable(base),tableTitles);
        // JTable properties.
        table.setLocation(0,0);
        table.setSize(400,335);
        // Add table to GUI
        GUI.add(table);

        GUI.setResizable(true);
        GUI.setSize(500, 500);
        GUI.setVisible(true);


    }

   public static String[][] getSalaryTable(int base) {
        // Create table of salaries.
        String[][] table = new String[21][4];
        for (int i = 0; i <= 20; i++) {
            table[i][0] = String.valueOf(i);
            table[i][1] = String.valueOf(Integer.toString(base));
            table[i][2] = String.valueOf((Integer.toString(base + 1000 + (i * 1000)))); // Master's degree.
            table[i][3] = String.valueOf(Integer.toString(base + 1000 + (i * 1000)));
        }
        return table;
    }
}
