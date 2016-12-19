package ru.stqa.pft.sandbox;

/**
 * Created by Vladimir on 19.12.2016.
 */
public class Point {
  public double x;
  public double y;

  public Point (double x, double y){
    this.x = x;
    this.y = y;
  }

  public double calcDistance(Point p2){
    return Math.sqrt((this.x - p2.x)*(this.x - p2.x)+(this.y - p2.y)*(this.y - p2.y));
  }
}
