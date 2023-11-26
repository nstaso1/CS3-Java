/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

import javax.swing.JOptionPane;

/**
 *
 * @author nathan
 */
public class Transaction
{
 public int transNumber;
 public int transId;
 public double transAmt;
 
 public Transaction(int number, int id, double amount)
 {
 transNumber = number;
 transId = id;
 transAmt = amount;
 }
 public int getTransNumber()
 {
 return transNumber;
 }
 public int getTransId()
 {
 return transId;
 }
 public double getTransAmount()
 {
 return transAmt;
 }
 
}
