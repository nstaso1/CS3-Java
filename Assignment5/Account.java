/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment5;

/**
 *
 * @author natha
 */
public class Account
{
    protected String name; // The person who owns the account
    protected double balance;// do not define this in CheckingAccount class
    
    public Account(String acctName, double initBalance)
    {
    balance = initBalance;
    name = acctName;
    }
    public String getName() 
    {
    return name;
    }
    public void setName(String name) 
    {
    this.name = name;
    }
    public double getBalance() 
    {
    return balance;
    }
    public void setBalance(double balance) 
    {
    this.balance = balance;
    }
}
