/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment4;

/**
 *
 * @author natha
 */
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

import javax.swing.JFrame;


//import javax.swing.*;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main {
 //   private static JFrame frame = new JFrame();
    public static JFrame frame;
    
    public static double initialBalance, transactionAmount;
    public static int checkNumber, cashDeposit, checkDeposit;
    public static int transactionCode;
    public static CheckingAccount ca;
    public static Transaction tr;
    public static int firstTime = 0;
    public static DecimalFormat dollar;
    public static int transactionNumber = 0;
    public static String idText = "";
    public static String accountName;

    public static void main (String[] args) {
        String initialBal;
        dollar = new DecimalFormat("#,##0.00; (#,##0.00)");
        frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CheckOptionsPanel panel = new CheckOptionsPanel();
        frame.getContentPane().add(panel);
        frame.pack();

        
        accountName = 
             JOptionPane.showInputDialog ("Enter the account name: ");
        initialBal =
             JOptionPane.showInputDialog ("Enter your initial balance: ");

                frame.setVisible(true);

        initialBalance = Double.parseDouble (initialBal);

        ca = new CheckingAccount (accountName, initialBalance);
        
        }


    public static void Start()
    {
        do

        {

            transactionCode = getTransCode();

            switch (transactionCode)

            {

                case 1:

                    checkNumber = getCheckNum();
                    
                    transactionAmount = getTransAmt();
                    
                    processCheck (transactionAmount);
                    

                    break;

                case 2:
                    
                    getDepositAmount();
                   
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Transaction: End\n"
                            + "Current Balance: $" + dollar.format(ca.getBalance()) + "\n"
                            + "Total Service Charge: $" + dollar.format(ca.getServiceCharge()) + "\n"
                            + "Final Balance: $" + dollar.format(ca.getBalance() - ca.getServiceCharge()));
                    frame.setVisible(true);

                    break;
                    
                default:JOptionPane.showMessageDialog (null,
                        "Invalid Choice. Enter Again.");

            }

        }
        while (transactionCode != 0);
        frame.setVisible(true);

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
    
    public static int getCheckNum()
    {
        int checkNum;
        String userInput;
        userInput = JOptionPane.showInputDialog("Enter check number: \n");
        checkNum = Integer.parseInt(userInput);
        return checkNum;
    }
    
    public static void getDepositAmount()
    {
      
      int depositCash;
      int depositCheck;
      JPanel panel = new JPanel(new GridLayout(4, 1));
      JTextField cash = new JTextField(10);
      JTextField check = new JTextField(10);
      panel.add(new JLabel("Cash"));
      panel.add(cash);  
      panel.add(new JLabel("Checks"));
      panel.add(check);
      JOptionPane.showConfirmDialog(null,panel, "Deposit Window", JOptionPane.OK_CANCEL_OPTION);
      if("".equals(cash.getText()))
      {
          cash.setText("0");
      }
      if("".equals(check.getText()))
      {
          check.setText("0");
      }
      depositCash = Integer.parseInt(cash.getText());
      depositCheck = Integer.parseInt(check.getText());
      processDeposit (depositCash, depositCheck, depositCash + depositCheck);
    
     
      
    }
    


    public static double getTransAmt ()
    {

        double amount;

        String userInput;

        userInput =
           JOptionPane.showInputDialog ("Enter the check amount: ");

        amount = Double.parseDouble (userInput);

        return amount;

    }

    public static double processCheck(double transAmt) {
        double transactionAmount = transAmt;

        
        tr = new Transaction(transactionNumber, 1, transactionAmount,checkNumber, cashDeposit, checkDeposit);
        transactionNumber += 1;
        ca.addTrans(tr);
        
        
        
        ca.setBalance(transactionAmount, 1);
        ca.setServiceCharge(0.15);
        tr = new Transaction(transactionNumber, 3, 0.15, 0, 0, 0);
        transactionNumber += 1;
        ca.addTrans(tr);
        String message = accountName + "'s Account\n" + "Transaction: Check #" + checkNumber + " in Amount of $" + dollar.format(transactionAmount) + "\n" +
                "Current Balance: $" + dollar.format(ca.getBalance()) + "\n" +
                "Service Charge: Check --- charge $0.15 \n"
                ;
                

        if (ca.getBalance() < 500) {
            if (firstTime == 0) {
                ca.setServiceCharge(5.00);
                message += "Service Charge: Below $500 --- charge $5.00\n";
                tr = new Transaction(transactionNumber, 3, 5.00, 0, 0, 0);
                transactionNumber += 1;
                ca.addTrans(tr);
                firstTime++;
            }
            
        }

        if (ca.getBalance() < 50) {
            message += "Warning: Balance below $50.\n";
        }

        if (ca.getBalance() < 0) {
            ca.setServiceCharge(10.00);
            message += "Service Charge: Below $0 --- charge $10.00\n";
            tr = new Transaction(transactionNumber, 3, 10.00, 0 , 0, 0);
            transactionNumber += 1;
            ca.addTrans(tr);
            
        }
        message += "Total Service Charge: $" + dollar.format(ca.getServiceCharge()) + "\n";
        JOptionPane.showMessageDialog(null, message);

        return transAmt;
    }

    public static double processDeposit(int cashDep, int checkDep, double transAmt) {
        double transactionAmount = transAmt;
        int cashDeposit = cashDep;
        int checkDeposit = checkDep;
        

        tr = new Transaction(transactionNumber, 2, transactionAmount, checkNumber, cashDeposit, checkDeposit);
        transactionNumber += 1;
        ca.addTrans(tr);

        ca.setBalance(transactionAmount, 2);
        ca.setServiceCharge(0.10);
        tr = new Transaction(transactionNumber, 3, 0.10, 0, 0, 0);
                transactionNumber += 1;
                ca.addTrans(tr);
        
               
             
                
                
        String message = "Transaction: Deposit in Amount of $" + dollar.format(transactionAmount) + "\n" +
                "Current Balance: $" + dollar.format(ca.getBalance()) + "\n" +
                "Service Charge: Deposit --- charge $0.10 \n";

        if (ca.getBalance() < 500) {
            if (firstTime == 0) {
                ca.setServiceCharge(5.00);
                message += "Service Charge: Below $500 --- charge $5.00\n";
                tr = new Transaction(transactionNumber, 3, 5.00, 0, 0, 0);
                transactionNumber += 1;
                ca.addTrans(tr);
                firstTime++;
            }
           
        }

        if (ca.getBalance() < 50) {
            message += "Warning: Balance below $50.\n";
        }

//        if (ca.getBalance() < 0) {
//            ca.setServiceCharge(10.00);
//            message += "\nService Charge: Below $0 --- charge $10.00";
//            message += "\nTotal Service Charge: $" + Double.toString(ca.getServiceCharge());
//        }
         message += "Total Service Charge: $" + dollar.format(ca.getServiceCharge());
        JOptionPane.showMessageDialog(null, message);

        return transAmt;
    }


        

}

