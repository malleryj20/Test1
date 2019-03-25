package com.test;
import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {
        boolean z = true;
        double x;
	Account bankerAcct = new Account("Deborah Jones", "checking", 250.0);
	Account custAcct = new Account(JOptionPane.showInputDialog("Please input name:"), JOptionPane.showInputDialog("Please input account type:"));
	if (custAcct.getBalance() == 0)
	    while (z){
	        try{
                custAcct.setBalance(Double.parseDouble(JOptionPane.showInputDialog("Your account is empty. Please enter deposit amount")));
                z = false;
            }
            catch(NumberFormatException e){
	            JOptionPane.showMessageDialog(null, "That's not a number.");
            }
        }
	JOptionPane.showMessageDialog(null, custAcct);
    }
}
