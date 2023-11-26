/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment5;

/**
 *
 * @author natha
 */
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author nathan
 */
public class Transaction implements Serializable
{
 public int transNumber;
 public int transId;
 public double transAmt;
 public int transCheckNum;
 public int transDepositCheck;
 public int transDepositCash;
 
 public Transaction(int number, int id, double amount, int checkNum, int depositCash, int depositCheck)
 {
 transNumber = number;
 transId = id;
 transAmt = amount;
 transCheckNum = checkNum;
 transDepositCash = depositCash;
 transDepositCheck = depositCheck;
 }
 public int getCheckNumber()
 {
     return transCheckNum;
 }
 public int getDepositCheck()
 {
     return transDepositCheck;
 }
 public int getDepositCash()
 {
     return transDepositCash;
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
