/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author natha
 */
public class Circle
{
  double radius;
  public Circle (double rad)
  {
    radius = rad;
  }
  public double getRadius ()
  {
    return radius;
  }
  public double getDiameter ()
  {
    return 2.0 * radius;
  }
  public double getCircumference ()
  {
    return 2.0 * Math.PI * radius;
  }
  public double getArea ()
  {
    return Math.PI * radius * radius;
  }
}
