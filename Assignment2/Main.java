/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
 * @author natha
 */
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Main {
    public static double initialBalance, transactionAmount;
    public static int transactionCode;
    public static CheckingAccount ca;
    public static int firstTime = 0;
    public static DecimalFormat dollar;

    public static void main(String[] args) {
        String initialBal;
        dollar = new DecimalFormat("#,##0.00; (#,##0.00)");

        initialBal =
                JOptionPane.showInputDialog ("Enter your initial balance: ");

        initialBalance = Double.parseDouble (initialBal);

        ca = new CheckingAccount (initialBalance);

        do

        {

            transactionCode = getTransCode ();

            switch (transactionCode)

            {

                case 1:

                    transactionAmount = getTransAmt ();

                    processCheck (transactionAmount);

                    break;

                case 2:transactionAmount = getTransAmt ();

                    processDeposit (transactionAmount);

                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Transaction: End\n"
                            + "Current Balance: $" + ca.getBalance() + "\n"
                            + "Total Service Charge: $" + dollar.format(ca.getServiceCharge()) + "\n"
                            + "Final Balance: $" + dollar.format(ca.getBalance() - ca.getServiceCharge()));
                    break;

                default:JOptionPane.showMessageDialog (null,
                        "Invalid Choice. Enter Again.");

            }

        }
        while (transactionCode != 0);

    }

    public static int getTransCode ()
    {

        int code;

        String userInput;

        userInput = JOptionPane.showInputDialog ("Enter the transaction code:\n" +
                "1) Check \n2) Deposit \n0) Exit the program");

        code = Integer.parseInt (userInput);

        return code;

    }

    public static double getTransAmt ()
    {

        double amount;

        String userInput;

        userInput =
                JOptionPane.showInputDialog ("Enter the transaction amount: ");

        amount = Double.parseDouble (userInput);

        return amount;

    }

    public static double processCheck(double transAmt) {
        double transactionAmount = transAmt;

        ca.setBalance(transactionAmount, 1);
        ca.setServiceCharge(0.15);
        String message = "Transaction: Check in Amount of $" + transactionAmount + "\n" +
                "Current Balance: $" + ca.getBalance() + "\n" +
                "Service Charge: Check --- charge $0.15 \n";

        if (ca.getBalance() < 500) {
            if (firstTime == 0) {
                ca.setServiceCharge(5.00);
                message += "Service Charge: Below $500 --- charge $5.00\n";
                firstTime++;
            }
            
        }

        if (ca.getBalance() < 50) {
            message += "\nWarning: Balance below $50.";
        }

        if (ca.getBalance() < 0) {
            ca.setServiceCharge(10.00);
            message += "\nService Charge: Below $0 --- charge $10.00";
            
        }
        message += "\nTotal Service Charge: $" + dollar.format(ca.getServiceCharge());
        JOptionPane.showMessageDialog(null, message);

        return transAmt;
    }

    public static double processDeposit(double transAmt) {
        double transactionAmount = transAmt;

        ca.setBalance(transactionAmount, 2);
        ca.setServiceCharge(0.10);
        String message = "Transaction: Deposit in Amount of $" + transactionAmount + "\n" +
                "Current Balance: $" + ca.getBalance() + "\n" +
                "Service Charge: Deposit --- charge $0.10 \n";

        if (ca.getBalance() < 500) {
            if (firstTime == 0) {
                ca.setServiceCharge(5.00);
                message += "Service Charge: Below $500 --- charge $5.00\n";
                firstTime++;
            }
           
        }

        if (ca.getBalance() < 50) {
            message += "\nWarning: Balance below $50.";
        }

        if (ca.getBalance() < 0) {
            ca.setServiceCharge(10.00);
            message += "\nService Charge: Below $0 --- charge $10.00";
            message += "\nTotal Service Charge: $" + Double.toString(ca.getServiceCharge());
        }
         message += "Total Service Charge: $" + dollar.format(ca.getServiceCharge());
        JOptionPane.showMessageDialog(null, message);

        return transAmt;
    }


}

