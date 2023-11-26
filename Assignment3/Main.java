/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

/**
 *
 * @author natha
 */
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private static final JFrame frame = new JFrame();
    public static double initialBalance, transactionAmount;
    public static int transactionCode;
    public static CheckingAccount ca;
    public static Transaction tr;
    public static int firstTime = 0;
    public static DecimalFormat dollar;
    public static int transactionNumber = 0;
    public static String idText = "";

    public static void main(String[] args) {
        String initialBal;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dollar = new DecimalFormat("#,##0.00; (#,##0.00)");
        ActionOptionsPanel panel = new ActionOptionsPanel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        initialBal =
             JOptionPane.showInputDialog ("Enter your initial balance: ");

        initialBalance = Double.parseDouble (initialBal);

        ca = new CheckingAccount (initialBalance);
        
        }


    public static void Start()
    {
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
                            + "Current Balance: $" + dollar.format(ca.getBalance()) + "\n"
                            + "Total Service Charge: $" + dollar.format(ca.getServiceCharge()) + "\n"
                            + "Final Balance: $" + dollar.format(ca.getBalance() - ca.getServiceCharge()));
                    break;
                    
                default:JOptionPane.showMessageDialog (null,
                        "Invalid Choice. Enter Again.");

            }

        }
        while (transactionCode != 0);
    }
    
    
    public static class ActionOptionsPanel extends JPanel {

    private JLabel actionPrompt;
    private JRadioButton transButton, listTransButton, listChecksButton, listDepositsButton;

    public ActionOptionsPanel() {
        actionPrompt = new JLabel("      Choose action:    ");
        actionPrompt.setFont(new Font("Helvetica", Font.BOLD, 20));
        transButton = new JRadioButton("Enter transaction");
        listTransButton = new JRadioButton("List All Transactions");
        listChecksButton = new JRadioButton("List All Checks");
        listDepositsButton = new JRadioButton("List All Deposits");

        ButtonGroup group = new ButtonGroup();
        group.add(transButton);
        group.add(listTransButton);
        group.add(listChecksButton);
        group.add(listDepositsButton);
        
        ActionOptionsListener listener = new ActionOptionsListener();
        transButton.addActionListener(listener);
        listTransButton.addActionListener(listener);
        listChecksButton.addActionListener(listener);
        listDepositsButton.addActionListener(listener);
        
        transButton.setBackground(Color.green);
        listTransButton.setBackground(Color.green);
        listChecksButton.setBackground(Color.green);
        listDepositsButton.setBackground(Color.green);
        
        add(actionPrompt);
        add(transButton);
        add(listTransButton);
        add(listChecksButton);
        add(listDepositsButton);
        setBackground(Color.green);
        setPreferredSize(new Dimension(320, 100));
    }
    // Represents the listener for the radio buttons
    //*****************************************************************
    private class ActionOptionsListener implements ActionListener
    {
    //--------------------------------------------------------------
    // Calls the method to process the option for which radio
    // button was pressed.
    //--------------------------------------------------------------
    public void actionPerformed (ActionEvent event)
    {
        
    Object source = event.getSource();
    if (source == transButton)
        Start();
    
        
    
    else if
            (source == listTransButton)
    {
        String transactionsList = "";
        transactionsList = "List All Transactions\n";
        transactionsList += "ID     Type                     Amount\n";
        for(int i=0; i<ca.getTransCount(); i++) {
            tr = ca.getTrans(i);
            if(tr.getTransId() == 1)
            {
                idText = "Check                 ";
            }
            else if(tr.getTransId() == 2)
            {
                idText = "Deposit               ";
            }
            else if(tr.getTransId() == 3)
            {
                idText = "Service Charge";
            }
            transactionsList +=  tr.getTransNumber() + "    " + idText + "    $" +  dollar.format(tr.getTransAmount()) + "\n";
                
            }
        transactionsList += "\nNumber of Transactions = " + ca.getTransCount() + "\n";
//      javax.swing.UIManager.put("JOptionPane.messageFont", new Font("Courier", Font.PLAIN, 21));
        JOptionPane.showMessageDialog(null, transactionsList); 
    } 
    
    else if
         
           (source == listChecksButton)
    {
        
        int checksAmount = 0;
        String checksList = "";
        checksList = "List All Checks\n";
        checksList += "ID     Amount\n";
        for(int i=0; i<ca.getTransCount(); i++) {
            tr = ca.getTrans(i);
            if(tr.getTransId() == 1)
            {
                
                checksList +=  tr.getTransNumber() + "      $" +  dollar.format(tr.getTransAmount()) + "\n";
                checksAmount++;
            }
            
                
            }
        checksList += "\nNumber of Checks = " + checksAmount + "\n";
        JOptionPane.showMessageDialog(null, checksList);
    }
    else if
           (source == listDepositsButton)
            {
                int depositsAmount = 0;
                String depositsList = "";
                depositsList = "List All Deposits\n\n";
                depositsList += "ID     Amount\n";
        for(int i=0; i<ca.getTransCount(); i++) {
            tr = ca.getTrans(i);
            if(tr.getTransId() == 2)
            {
            
                depositsList +=  tr.getTransNumber() + "      $" +  dollar.format(tr.getTransAmount()) + "\n";
                depositsAmount++;
            }
            
                
            }
            
            depositsList += "\nNumber of Deposits = " + depositsAmount + "\n";
            

        JOptionPane.showMessageDialog(null, depositsList);
                     }
           
    }
    } 
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
        
        tr = new Transaction(transactionNumber, 1, transactionAmount);
        transactionNumber += 1;
        ca.addTrans(tr);
        
        ca.setBalance(transactionAmount, 1);
        ca.setServiceCharge(0.15);
        tr = new Transaction(transactionNumber, 3, 0.15);
        transactionNumber += 1;
        ca.addTrans(tr);
        String message = "Transaction: Check in Amount of $" + dollar.format(transactionAmount) + "\n" +
                "Current Balance: $" + dollar.format(ca.getBalance()) + "\n" +
                "Service Charge: Check --- charge $0.15 \n"
                ;
                

        if (ca.getBalance() < 500) {
            if (firstTime == 0) {
                ca.setServiceCharge(5.00);
                message += "Service Charge: Below $500 --- charge $5.00\n";
                tr = new Transaction(transactionNumber, 3, 5.00);
                transactionNumber += 1;
                ca.addTrans(tr);
                firstTime++;
            }
            
        }

        if (ca.getBalance() < 50) {
            message += "\nWarning: Balance below $50.";
        }

        if (ca.getBalance() < 0) {
            ca.setServiceCharge(10.00);
            message += "\nService Charge: Below= $0 --- charge $10.00";
            tr = new Transaction(transactionNumber, 3, 10.00);
            transactionNumber += 1;
            ca.addTrans(tr);
            
        }
        message += "\nTotal Service Charge: $" + dollar.format(ca.getServiceCharge());
        JOptionPane.showMessageDialog(null, message);

        return transAmt;
    }

    public static double processDeposit(double transAmt) {
        double transactionAmount = transAmt;

        tr = new Transaction(transactionNumber, 2, transactionAmount);
        transactionNumber += 1;
        ca.addTrans(tr);

        ca.setBalance(transactionAmount, 2);
        ca.setServiceCharge(0.10);
        tr = new Transaction(transactionNumber, 3, 0.10);
                transactionNumber += 1;
                ca.addTrans(tr);
        String message = "Transaction: Deposit in Amount of $" + dollar.format(transactionAmount) + "\n" +
                "Current Balance: $" + dollar.format(ca.getBalance()) + "\n" +
                "Service Charge: Deposit --- charge $0.10 \n";

        if (ca.getBalance() < 500) {
            if (firstTime == 0) {
                ca.setServiceCharge(5.00);
                message += "Service Charge: Below $500 --- charge $5.00\n";
                tr = new Transaction(transactionNumber, 3, 5.00);
                transactionNumber += 1;
                ca.addTrans(tr);
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

