/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment6_1;

/**
 *
 * @author natha
 */
import java.util.ArrayList;
import java.io.Serializable;
        
//public class CheckingAccount extends Account
public class CheckingAccount extends Account implements Serializable
{
   
    protected String accountName;
    protected double totalServiceCharge;
//    protected double individualServiceCharge;
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
    
    public ArrayList<Transaction> transList = new ArrayList<>();
    public int transCount; 

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
    
    @Override
    public String toString()
    {
        return "";
    }
    
    double getServiceCharge ()
    {

        return totalServiceCharge;
    }

//   String getAccountName ()
//    {
//
//        return accountName;
//    }

    public void setServiceCharge(double currentServiceCharge) 
    {
        totalServiceCharge += currentServiceCharge;
    }

    public void addTrans(Transaction newTrans)
    {
        transList.add(newTrans);
    }
    
    /**
     *
     * @return
     */
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
