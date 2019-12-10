import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LoanAmortTable {
    public static double price;
    public static double downPayment;
    public static double APR;
    public static double monthlyPayment;
    public static void main(String args[]){
        price = Integer.parseInt(JOptionPane.showInputDialog("Enter purchase price"));
        downPayment = price *.1;
        APR = .12;
        monthlyPayment = ((price-downPayment)*.05);
        showTable(price);

    }
    public static String[][] getPaymentTable(double price) {
        String[][] table = new String[30][6];
        //create amount variable to subtract each monthly payment from
        double amt=price;
        int i =1;
        double mi=.01;
        //while there is still balance remaining on the loan...
        while (amt>0){
            table[i][0]=Integer.toString(i); //month
            table[i][1]=Double.toString(round(amt)); //balance
            table[i][2]=Double.toString(round(amt*mi)); //interest paid this month
            table[i][3]=Double.toString(round(monthlyPayment-(amt*mi))); //principal paid this month
            table[i][4]=Double.toString(monthlyPayment); //monthly payment
            table[i][5]=Double.toString(round(amt-monthlyPayment)); //remaining balance
            amt = amt-monthlyPayment; //subtract this month's payment from the balance
            i++; //next month
        }
        return table;
    }

    public static void showTable(double price) {

        Frame GUI = new JFrame();
        String[] tableTitles = new String[]{"Month", "Balance", "Interest Amount", "Principal Amount", "Payment Amount", "Remaining Balance"};
        //make new table with data, labels
        JTable table = new JTable(getPaymentTable(price),tableTitles);
        // JTable properties.
        table.setLocation(0,0);
        table.setSize(1000,1000);
        // Add table to GUI
        GUI.add(new JScrollPane(table));

        GUI.setResizable(true);
        GUI.setSize(1000, 500);
        GUI.setVisible(true);


    }
    public static double round(double n){
        return Math.round(n * 100.0) / 100.0;
    }
}
