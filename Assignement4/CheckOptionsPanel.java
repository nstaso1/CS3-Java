/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment4;


import static assignment4.Main.Start;
import static assignment4.Main.ca;
import static assignment4.Main.dollar;
import static assignment4.Main.frame;
import static assignment4.Main.idText;
import static assignment4.Main.tr;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author nathan
 */


    

    public class CheckOptionsPanel extends JPanel {

    private JLabel actionPrompt;
    private JRadioButton transButton, listTransButton, listChecksButton, listDepositsButton;

    public CheckOptionsPanel() {
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
        
        CheckOptionsListener listener = new CheckOptionsListener();
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
    private class CheckOptionsListener implements ActionListener
    {
    //--------------------------------------------------------------
    // Calls the method to process the option for which radio
    // button was pressed.
    //--------------------------------------------------------------
    public void actionPerformed (ActionEvent event)
    {
        
    Object source = event.getSource();
    
    if (source == transButton)
    { 
        frame.setVisible(false);
        Start();
    }
        
    
    else if
            (source == listTransButton)
    {
        frame.setVisible(false);
        String transactionsList = "";
        transactionsList = "List All Transactions\n";
        transactionsList += "Name: " + Main.accountName + "\n\n";
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
        JOptionPane.showMessageDialog(null, transactionsList);
        frame.setVisible(true);
    } 
    
    else if
         
           (source == listChecksButton)
    {
        frame.setVisible(false);
        int checksAmount = 0;
        String checksList = "";
        checksList = "List All Checks\n";
        checksList += "Name: " + Main.accountName + "\n\n";
        checksList += "ID    Check              Amount\n";
        for(int i=0; i<ca.getTransCount(); i++) {
            tr = ca.getTrans(i);
            if(tr.getTransId() == 1)
                {
                checksList +=  tr.getTransNumber() + "       " + tr.getCheckNumber() + "        $" +  dollar.format(tr.getTransAmount()) + "\n";
                checksAmount++;
                }
            
            }
        checksList += "\nNumber of Checks = " + checksAmount + "\n";
        JOptionPane.showMessageDialog(null, checksList);
        frame.setVisible(true);
    }
    else if
           (source == listDepositsButton)
            {
                frame.setVisible(false);
                int depositsAmount = 0;
                String depositsList = "";
                depositsList = "List All Deposits\n";
                depositsList += "Name: " + Main.accountName + "\n\n";
                depositsList += "ID     Cash      Checks       Amount\n";
        for(int i=0; i<ca.getTransCount(); i++) {
            tr = ca.getTrans(i);
            if(tr.getTransId() == 2)
                {
            
                depositsList +=  tr.getTransNumber() + "      $" + dollar.format(tr.getDepositCash()) + "      $" + dollar.format(tr.getDepositCheck()) + "        $" +  dollar.format(tr.getTransAmount()) + "\n";
                depositsAmount++;
                }
            
            }
            
            depositsList += "\nNumber of Deposits = " + depositsAmount + "\n";
            
        JOptionPane.showMessageDialog(null, depositsList);
        frame.setVisible(true);
            }
           
    }
    } 
    }

