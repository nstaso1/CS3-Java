/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment6_1;

/**
 *
 * @author natha
 */
import static assignment6_1.Main.Start;
import static assignment6_1.Main.ca;
import static assignment6_1.Main.dollar;
import static assignment6_1.Main.frame;
import static assignment6_1.Main.idText;
import static assignment6_1.Main.tr;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author nathan
 */


    

    public class CheckOptionsFrame extends JFrameL{
    BufferedReader KB = new BufferedReader (new InputStreamReader (System.in));
    String Input = new String();
    boolean done = false;


    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    private JMenu fileMenu, accountMenu, transactionMenu;
    private JMenuItem openFile, saveFile, addA, listT, listC, listD, listSC, findA, listA, enterT;
    private JMenuBar bar;
    
    
    
    public CheckOptionsFrame(String title) {
        super(title);
        setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fileMenu = new JMenu("File");
        
        CheckOptionsListener ml = new CheckOptionsListener();
        
        openFile = new JMenuItem ("Open File");
        openFile.addActionListener(ml);
        fileMenu.add(openFile);
        
        saveFile = new JMenuItem ("Save File");
        saveFile.addActionListener(ml);
        fileMenu.add(saveFile);
        
        accountMenu = new JMenu("Accounts");
        
        addA = new JMenuItem ("Add New Account");
        addA.addActionListener(ml);
        accountMenu.add(addA);
        
        listT = new JMenuItem ("List All Transactions");
        listT.addActionListener(ml);
        accountMenu.add(listT);
        
        listC = new JMenuItem ("List All Checks");
        listC.addActionListener(ml);
        accountMenu.add(listC);
        
        listD = new JMenuItem ("List All Deposits");
        listD.addActionListener(ml);
        accountMenu.add(listD);
        
        listSC = new JMenuItem ("List All Service Charges");
        listSC.addActionListener(ml);
        accountMenu.add(listSC);
        
        findA = new JMenuItem ("Find An Account");
        findA.addActionListener(ml);
        accountMenu.add(findA);
        
        listA = new JMenuItem ("List All Accounts");
        listA.addActionListener(ml);
        accountMenu.add(listA);
        
        transactionMenu = new JMenu("Transactions");
        
        enterT = new JMenuItem ("Enter Transactions");
        enterT.addActionListener(ml);
        transactionMenu.add(enterT);
        
        bar = new JMenuBar();
        bar.add(fileMenu);
        bar.add(accountMenu);
        bar.add(transactionMenu);
        setJMenuBar(bar);
        
//        JPanel containerPanel = new JPanel(new GridBagLayout());
  //      containerPanel.add()

        
        
        CheckOptionsListener listener = new CheckOptionsListener();
        
        
        
    }

    

   
    // Represents the listener for the radio buttons
    //*****************************************************************
    private class CheckOptionsListener implements ActionListener
    {
    //--------------------------------------------------------------
    // Calls the method to process the option for which radio
    // button was pressed.
    //--------------------------------------------------------------
    public void actionPerformed (ActionEvent event)
    {
        
    Object source = event.getSource();
    
    if ((source == enterT || source == listT || source == listD || source == listC || source == listSC) && (ca == null) )
    {
        JOptionPane.showMessageDialog(null, "You must select an account first");
           frame.setVisible(true);
    }
    
    if (source == enterT && ca != null)
    { 
        frame.setVisible(false);
        try {
            Main.Start();
        } catch (Exception ex) {
            Logger.getLogger(CheckOptionsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
    
    else if
            (source == listT && ca != null)
    {
        frame.setVisible(false);
        
 
        
        
        String transactionsList = "";
        transactionsList = "List All Transactions\n";
        transactionsList += "Name: " + ca.getName() + "\n";
        transactionsList += "Balance: $" + dollar.format(ca.getBalance()) + "\n";
        transactionsList += "Total Service Charge: $" + dollar.format(ca.getServiceCharge()) + "\n";
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
            transactionsList +=  ca.transList.indexOf(tr) + "    " + idText + "    $" +  dollar.format(tr.getTransAmount()) + "\n";
            
            }
        transactionsList += "\nNumber of Transactions = " + ca.getTransCount() + "\n";
        transactionsList += "\nCurrentBalance = $" + dollar.format(ca.getBalance()) + "\n";
        transactionsList += "\nTotalServiceCharge = $" + dollar.format(ca.getServiceCharge()) + "\n"; 
        transactionsList += "\nFinal Balance: $" + dollar.format(ca.getBalance() - ca.getServiceCharge()) + "\n";
        Main.ta.setText(transactionsList);
        frame.setVisible(true);
    } 
    
    else if
         
           (source == listC && ca != null)
    {
        frame.setVisible(false);
        int checksAmount = 0;
        String checksList = "";
        checksList = "List All Checks\n";
        checksList += "Name: " + ca.getName() + "\n";
        checksList += "Balance: $" + dollar.format(ca.getBalance()) + "\n";
        checksList += "Total Service Charge: $" + dollar.format(ca.getServiceCharge()) + "\n";
        checksList += "ID    Check              Amount\n";
        for(int i=0; i<ca.getTransCount(); i++) {
            tr = ca.getTrans(i);
            if(tr.getTransId() == 1)
                {
                checksList +=  ca.transList.indexOf(tr) + "       " + tr.getCheckNumber() + "        $" +  dollar.format(tr.getTransAmount()) + "\n";
                checksAmount++;
                }
            
            }
        checksList += "\nNumber of Checks = " + checksAmount + "\n";
        Main.ta.setText(checksList);
        frame.setVisible(true);
    }
    else if
           (source == listD && ca != null)
            {
                frame.setVisible(false);
                int depositsAmount = 0;
                String depositsList = "";
                depositsList = "List All Deposits\n";
                depositsList += "Name: " + ca.getName() + "\n";
                depositsList += "Balance: $" + dollar.format(ca.getBalance()) + "\n";
                depositsList += "Total Service Charge: $" + dollar.format(ca.getServiceCharge()) + "\n";
                depositsList += "ID     Cash      Checks       Amount\n";
        for(int i=0; i<ca.getTransCount(); i++) {
            tr = ca.getTrans(i);
            if(tr.getTransId() == 2)
                {
            
                depositsList +=  ca.transList.indexOf(tr) + "      $" + dollar.format(tr.getDepositCash()) + "      $" + dollar.format(tr.getDepositCheck()) + "        $" +  dollar.format(tr.getTransAmount()) + "\n";
                depositsAmount++;
                }
            
            }
        
        
            
            depositsList += "\nNumber of Deposits = " + depositsAmount + "\n";
            
        Main.ta.setText(depositsList);
        frame.setVisible(true);
            }
    
    else if
           (source == listSC && ca != null)
            {
                frame.setVisible(false);
                int scAmount = 0;
                String scList = "";
                scList = "List All Service Charges\n";
                scList += "Name: " + ca.getName() + "\n";
                scList += "Balance: $" + dollar.format(ca.getBalance()) + "\n";
                scList += "Total Service Charge: $" + dollar.format(ca.getServiceCharge()) + "\n";
                scList += "ID       Amount\n";
        for(int i=0; i<ca.getTransCount(); i++) {
            tr = ca.getTrans(i);
            if(tr.getTransId() == 3)
                {
            
                scList +=  ca.transList.indexOf(tr) + "      $" + dollar.format(tr.getTransAmount()) + "\n";
                scAmount++;
                }
            
            }
                Main.ta.setText(scList);
                frame.setVisible(true);
            }
        else if
           (source == findA)
            {
        try {
            Main.findAccount();
        } catch (Exception ex) {
            Logger.getLogger(CheckOptionsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            }
         else if
           (source == addA)
            {
        try {
            Main.addAccount();
        } catch (Exception ex) {
            Logger.getLogger(CheckOptionsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            }
         else if
           (source == listA)
            {
                Main.listAccounts();
       
            }
    
    
    else if(source == openFile)
        {
            Main.readFile();
        }
    else if(source == saveFile)
        {
            Main.saveFile();
        }
    
    
    } // end of Actionperformed
    
    } // end of CheckOptionsListener
         
    } //end of CheckOptionsPanel
    
   

