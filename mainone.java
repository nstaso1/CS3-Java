/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;

/**
 *
 * @author natha
 */
import java.util.Scanner;

public class MainOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //inputs radius helper method
        double radius = readRadius(scanner);

        //circumference calculation helper method call
        double circumference = calcCirc(radius);

        //area calculation helper method call
        double area = calcArea(radius);

        //outputs all the values
        System.out.printf("Radius: %.2f%n", radius);
        System.out.printf("Circumference: %.2f%n", circumference);
        System.out.printf("Area: %.2f%n", area);
    }

    public static double readRadius(Scanner scanner) {
        //enters radius input
        System.out.print("Enter the radius of the circle: ");
        return scanner.nextDouble();
    }

    public static double calcCirc(double radius) {
        //the formula for circumference
        return 2 * Math.PI * radius;
    }

    public static double calcArea(double radius) {
        //the formula for radius
        return Math.PI * radius * radius;
    }
}
