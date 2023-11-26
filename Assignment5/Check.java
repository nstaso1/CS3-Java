/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment5;

/**
 *
 * @author natha
 */
public class Check extends Transaction
{
private int checkNumber; // check number for each check transaction
public Check(int tCount, int tId, double tAmt, int checkNum, int depositCheck, int depositCash) {
super(tCount, tId, tAmt, checkNum, depositCheck, depositCash);
this.checkNumber = checkNumber;
}
public int getCheckNumber() {
return checkNumber;
}
public void setCheckNumber(int checkNumber) {
this.checkNumber = checkNumber;
}
}
