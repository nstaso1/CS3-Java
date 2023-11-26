/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment4;

/**
 *
 * @author nathan
 */

import java.util.ArrayList;
        
//public class CheckingAccount extends Account
public class CheckingAccount extends Account
{
   
    protected String name;
    protected double totalServiceCharge;
    protected int depositCash;
    protected int depositCheck;
   
    /**
     *
     * @param accountName
     * @param initialBalance
     */
    // constructor
    public CheckingAccount(String accountName, double initialBalance)
    {

        super (accountName,initialBalance);

    }
    
    @Override //Not needed??
    public double getBalance ()
    {

        return balance;

    }

    public void setBalance (double transAmt, int tCode)
    {

        if (tCode == 1)

            balance -= transAmt;

        else if (tCode == 2)

            balance += transAmt;

    }
    
 double getServiceCharge ()
    {

        return totalServiceCharge;
    }

    public void setServiceCharge(double currentServiceCharge) 
    {
        totalServiceCharge += currentServiceCharge;
    }

    
    
    public ArrayList<Transaction> transList = new ArrayList<>();
    
    private int transCount; 
    
    public void addTrans(Transaction newTrans)
    {
        transList.add(newTrans);
    }
    
    public int getTransCount()
    {
        transCount = transList.size();
        return transCount;
    }
    
    public Transaction getTrans(int i)
    {
        return transList.get(i);
    }
}
