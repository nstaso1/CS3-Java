/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
 * @author natha
 */
public class CheckingAccount
{

    private double balance;

    private double totalServiceCharge;
  
    public CheckingAccount (double initialBalance)
    {

        balance = initialBalance;

        totalServiceCharge = 0;

    }

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

    public double getServiceCharge ()
    {

        return totalServiceCharge;
    }

    public void setServiceCharge(double currentServiceCharge) {
        totalServiceCharge += currentServiceCharge;
    }

}
