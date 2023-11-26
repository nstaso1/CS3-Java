/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment5;

/**
 *
 * @author natha
 */
public class Deposit extends Transaction
{
private int depositNumber; //  number for each deposit transaction
public Deposit(int tCount, int tId, double tAmt, int checkNum, int depositCheck, int depositCash) {
super(tCount, tId, tAmt, checkNum, depositCheck, depositCash);
this.depositNumber = depositNumber;
}
public int getDepositNumber() {
return depositNumber;
}
public void setDepositNumber(int DepositNumber) {
this.depositNumber = depositNumber;
}
}

