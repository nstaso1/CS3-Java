/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment6_1;

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
    

    public static String filename = "C:\\users\\natha\\downloads\\camenu.dat";
    public static boolean saved = false;
    public static JTextArea ta;
    public static Vector<CheckingAccount> dataStore; 
    private static Vector<CheckingAccount> datastore;
    


    public static void main (String[] args) {
        
        dataStore = new Vector<CheckingAccount>();

//        String initialBal = "";
        dollar = new DecimalFormat("#,##0.00; (#,##0.00)");
        frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame = new CheckOptionsFrame("Transactions Menu");

        ta = new JTextArea(30,50);
        ta.setFont(new Font("Monospaced",Font.PLAIN, 12));
        frame.getContentPane().add(ta);
        frame.pack();
        frame.setVisible(false);
        
//       String name, message;
//       int number, again;
//       CheckingAccount datum;
//          accountName = "";
//          boolean inputCheck;
//         do 
//        {
//            inputCheck = false;
//            try{
//                  accountName = 
//             JOptionPane.showInputDialog (null,"Enter the account name: ");
//            initialBal = JOptionPane.showInputDialog (null, "Enter your initial balance: ");
//            initialBalance = Double.parseDouble (initialBal);
//
//            if(accountName.equals(""))
//            JOptionPane.showMessageDialog (null,"You have to enter a name. No blanks.");
//        
//            datum = new CheckingAccount(accountName, initialBalance); 
//            dataStore.addElement(datum);
//            
//            saved = false;
//            message = datum.toString();
//            inputCheck = true;
//        
//            }
//        
//        catch (Exception e) {
//        JOptionPane.showMessageDialog(null,"Something went wrong.");
//        }
//        }
//        while (!inputCheck);
//    
//         
////        do
////        {  
////            inputCheck = false;
////        try{
////        initialBal =
////             JOptionPane.showInputDialog ("Enter your initial balance: ");
////                
////            initialBalance = Double.parseDouble (initialBal);
////            if(initialBalance < 0)
////        {
////            throw new Exception("Please put in a positive number.");
////        }
////            inputCheck = true;
////            
////           }
////        
////        catch (NumberFormatException e) {
////                  JOptionPane.showMessageDialog(null, "Please input a valid number.");
////                  inputCheck = false;
////           }
////        catch (Exception e) {
////        JOptionPane.showMessageDialog(null,"Something went wrong.");
////        }
////        }
////        while (!inputCheck);
//    
//        
//
//
//        ca = new CheckingAccount (accountName, initialBalance);
//
//  
       frame.setVisible(true);

        }
    
    public static void addAccount() throws Exception
   {  
       frame.setVisible(false);
//       int again;
       CheckingAccount datum;

           String initialBal = "";
         
           boolean inputCheck;
         do 
        {
            inputCheck = false;
            try{
           
           accountName = 
            JOptionPane.showInputDialog (null,"Enter the account name: ");
            inputCheck = true;
            if(accountName.equals(""))
            {
              JOptionPane.showMessageDialog (null,"You have to enter a name. No blanks.");
              inputCheck = false;
            }
              }
            catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Something went wrong.");
            inputCheck = false;

            }

            
            }
        while (!inputCheck);
         
        do
        {  
            inputCheck = false;
        try{

         initialBal = JOptionPane.showInputDialog (null, "Enter your initial balance: ");
         initialBalance = Double.parseDouble (initialBal);

            if(initialBalance < 0)
        {
            throw new Exception("Please put in a positive number.");
        }

	 datum = new CheckingAccount(accountName, initialBalance); 
         dataStore.addElement(datum);
         saved = false;
         ca = datum;

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
    

//         again = JOptionPane.showConfirmDialog (null, "Input Another?");
//       }
//       while (again == JOptionPane.YES_OPTION);

       frame.setVisible(true);
       ta.setText("New account added for " + accountName);
   }
    
    public static void findAccount() throws Exception
   {  
       frame.setVisible(false);
        String name = "", message;
        message = "";
        boolean flag = false;
        boolean inputCheck;
        
        do
        {  
            inputCheck = false;
        try {
        name = JOptionPane.showInputDialog ("Enter the Account name: ");
            inputCheck = true;

          if(name.equals(""))
            {
              JOptionPane.showMessageDialog (null,"You have to enter a name. No blanks.");
              inputCheck = false;
            }
           }
            catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Something went wrong.");
            inputCheck = false;

            }
        }
        while (!inputCheck);
        
        // search through vector
	for (int index=0; index != dataStore.size(); index++)
	{
	  CheckingAccount datum = dataStore.elementAt(index);
					
	  // check on the name of the account
	  if (name.equals(datum.getName()))
             {
			// display chosen account
                 datum = dataStore.elementAt(index);
      			message = "Account found for " + name + "\n";
                        ca = datum;
                        flag = true;            
             }
	}
        if(!flag)
        {
            message = "Account not found for " + name +"\n";
        }
        ta.setText(message);
        frame.setVisible(true);

        

   }

    public static void listAccounts()
   {  
      frame.setVisible(false);
      CheckingAccount datum;   
      String message = "List of All Accounts:\n\n";
      for (int index=0; index != dataStore.size();index++)
      {
       
	datum = dataStore.elementAt(index);
        ca = datum;
        message += "Name: " + datum.getName() + "\n";
        message += "Balance: $" + dollar.format(datum.getBalance()) + "\n";
        message += "Total Service Charge: $" + dollar.format(datum.getServiceCharge()) + "\n\n";
      }
      ta.setText(message);
      frame.setVisible(true);
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
                    String message = "Transaction completed";
                    ta.setText(message);
 //                   listT();
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
    
//    public static void reProcess()
//    {
//        
//        for(int i = 0; i < ca.transList.size(); i++)
//        {
//           tr = ca.getTrans(i);
//            if(tr.getTransId() == 1)
//                {
//                  tr.transAmt = tr.getTransAmount();
//                  ca.setBalance(tr.transAmt, 1);
//                }
//           else if(tr.getTransId() == 2)
//                {
//                  tr.transAmt = tr.getTransAmount();
//                  ca.setBalance(tr.transAmt, 2);
//                }
//            else if(tr.getTransId() == 3)
//                {
//                  tr.transAmt = tr.getTransAmount();
//                  ca.setServiceCharge(tr.transAmt);
//                }
//        }
//    }

   public static void readFile() 
   { 
        int confirm;  
        if (!saved)
        {
           String  message = """
                             The data in the application is not saved.
                             would you like to save it before reading the new file in?""";
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
             dataStore = (Vector<CheckingAccount>)in.readObject();
                String message = "";
                message += "dataStore size = " + dataStore.size() + "\n";
                ca = dataStore.firstElement();
                message += "Account found for " + ca.getName();
                ta.setText(message);
                frame.setVisible(true);
                    
                    saved = true;
                }
			
		catch(ClassNotFoundException | IOException e) 
                 { 
                     System.out.println(e);
                 } 
   
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
                     out.writeObject(dataStore);
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

