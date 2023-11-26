/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment5;

/**
 *
 * @author natha
 */
import java.text.DecimalFormat;


import java.io.*;
//import java.util.Vector;
//import java.io.FileInputStream;

import java.awt.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.awt.Font;
//import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.ButtonGroup;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;



public class Main{
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
    
    public static String filename = "C:\\users\\natha\\downloads\\ca.dat";
    public static boolean saved = false;
    public static Vector<Transaction> dataStore; 


    public static void main (String[] args) {
        
        dataStore = new Vector<Transaction>();

        String initialBal = "";
        dollar = new DecimalFormat("#,##0.00; (#,##0.00)");
        frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CheckOptionsPanel panel = new CheckOptionsPanel();
        frame.getContentPane().add(panel);
        frame.pack();

 
          //accountName = "";
          boolean inputCheck;
         do 
        {
            inputCheck = false;
            try{
        accountName = 
             JOptionPane.showInputDialog (null,"Enter the account name: ");
             
            
        if(accountName.equals(""))
            JOptionPane.showMessageDialog (null,"You have to enter a name. No blanks.");
        inputCheck = true;
            }
        
        catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Something went wrong.");
        }
        }
        while (!inputCheck);
    
         
        do
        {  
            inputCheck = false;
        try{
        initialBal =
             JOptionPane.showInputDialog ("Enter your initial balance: ");
                
            initialBalance = Double.parseDouble (initialBal);
            if(initialBalance < 0)
        {
            throw new Exception("Please put in a positive number.");
        }
            inputCheck = true;
            
           }
        
        catch (NumberFormatException e) {
                  JOptionPane.showMessageDialog(null, "Please input a valid number.");
                  inputCheck = false;
           }
        catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Something went wrong.");
        }
        }
        while (!inputCheck);
    
        
        frame.setVisible(true);


        ca = new CheckingAccount (accountName, initialBalance);
        
        }


    public static void Start() throws Exception
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


        int code = 0;

        String userInput = "";
        boolean inputCheck = false;
        do
        {
            inputCheck = false;
        try
        {
            
        userInput = JOptionPane.showInputDialog ("Enter the transaction code:\n" +
                "1) Check \n2) Deposit \n0) Exit the program");
        code = Integer.parseInt (userInput);
        
        inputCheck = true;}
        
        
        catch (NumberFormatException e) {
                  JOptionPane.showMessageDialog(null, "Please input a valid number.");
                  inputCheck = false;
           }
        catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Something went wrong.");
        }
    }
    while(!inputCheck);

        return code;

    }
    
    public static int getCheckNum() throws Exception
    {
        int checkNum = 0;
        boolean inputCheck;
        String userInput = "";
         do 
        {
            inputCheck = false;
            try{
        userInput =
           JOptionPane.showInputDialog ("Enter the check number: ");
        checkNum = Integer.parseInt(userInput);
        if(checkNum < 0)
        {
            throw new Exception("Please put in a positive number.");
        }
            
            inputCheck = true;
            }
            
            catch (NumberFormatException e) {
                  JOptionPane.showMessageDialog(null, "Please input a valid number.");
                  inputCheck = false;
           }
        catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Something went wrong.");
        }
        }
        while (!inputCheck);
        
        return checkNum;
    }
    
    public static void getDepositAmount()
    {
      
      int depositCash = 0;
      int depositCheck = 0;
      JPanel panel = new JPanel(new GridLayout(4, 1));
      JTextField cash = new JTextField(10);
      JTextField check = new JTextField(10);
      panel.add(new JLabel("Cash"));
      panel.add(cash);  
      panel.add(new JLabel("Checks"));
      panel.add(check);
      boolean inputCheck;
                    
    do
      {
        inputCheck = false;
        try{
        depositCash =
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
      if(depositCash < 0 || depositCheck < 0)
        {
            throw new Exception("Please put in a positive number.");
        }
      inputCheck = true;
            
      }
        
     catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please input a valid number.");
        inputCheck = false;
      }
        catch (Exception e) {
         JOptionPane.showMessageDialog(null,"Something went wrong.");
         inputCheck = false;
      }
       }
       while (!inputCheck);
      
      
      processDeposit (depositCash, depositCheck, depositCash + depositCheck);
    
     
      
    }
    


    public static double getTransAmt()
    {

        double amount = 0;
        boolean inputCheck;
        String userInput = "";
         do 
        {
            inputCheck = false;
            try{
        userInput =
           JOptionPane.showInputDialog ("Enter the check amount: ");
        amount = Double.parseDouble (userInput);
        if(amount < 0)
        {
            throw new Exception("Please put in a positive number.");
        }
          
        inputCheck = true;
            }
            catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please input a valid number.");
        inputCheck = false;
            }
        catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Something went wrong.");
        }
        }
        while (!inputCheck);
         
        

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
    
    public static void reProcess()
    {
        
        for(int i = 0; i < ca.transList.size(); i++)
        {
           tr = ca.getTrans(i);
            if(tr.getTransId() == 1)
                {
                  tr.transAmt = tr.getTransAmount();
                  ca.setBalance(tr.transAmt, 1);
                }
           else if(tr.getTransId() == 2)
                {
                  tr.transAmt = tr.getTransAmount();
                  ca.setBalance(tr.transAmt, 2);
                }
            else if(tr.getTransId() == 3)
                {
                  tr.transAmt = tr.getTransAmount();
                  ca.setServiceCharge(tr.transAmt);
                }
        }
    }

   public static void readFile() 
   { 
        int confirm;  
        if (!saved)
        {
           String  message = "The data in the application is not saved.\n"+
               "would you like to save it before reading the new file in?";
           confirm = JOptionPane.showConfirmDialog (null, message);
           if (confirm == JOptionPane.YES_OPTION)
              chooseFile(2); 
        }
        chooseFile(1);	
	try
		{
			FileInputStream fis = new
			FileInputStream(filename);
			ObjectInputStream in = new
				       ObjectInputStream(fis);
                    	CheckingAccount ca = (CheckingAccount)in.readObject();
//                        Main.accountName = ca.getName();

			in.close();
                        saved = true;
                        ca.transCount = ca.transList.size();
		}	
//		catch(ClassNotFoundException e)	
//                 { 
//                     System.out.println(e);
//                 }
                catch (IOException e) 
                 { 
                     System.out.println(e);
                 } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);}
        reProcess(); // Reprocess transactions to update balance and service charge
   }
   
public static void saveFile() 
   {  
        chooseFile(2);
      	try
		{
			FileOutputStream fos = new
			    FileOutputStream(filename);
			ObjectOutputStream out = new
				       ObjectOutputStream(fos);
//                     out.writeObject(ca.transList);
                     out.writeObject(ca);
                        out.close();
                        saved = true;
		}	
	catch(IOException e)	
                { 
                     System.out.println(e);
                }
   }
   
public static void chooseFile(int ioOption) 
   {
       int status, confirm;       
                
      String  message = "Would you like to use the current default file: \n" +
                          filename;
      confirm = JOptionPane.showConfirmDialog (null, message);
      if (confirm == JOptionPane.YES_OPTION)
          return;
      JFileChooser chooser = new JFileChooser();
      if (ioOption == 1)
          status = chooser.showOpenDialog (null);
      else
          status = chooser.showSaveDialog (null);
      if (status == JFileChooser.APPROVE_OPTION)
      {
          File file = chooser.getSelectedFile();
          filename = file.getPath();
      }
   }


   
}

