package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Vladimir on 23.12.2016.
 */
public class PointTests {

 @Test
  public void testCalcDistancepass (){
    Point p1 = new Point(2, 8);
    Point p2 = new Point(5, 4);

   Assert.assertEquals(p1.calcDistance(p2), 5.0);

  }
  @Test
  public void testCalcDistancepass2 (){
    Point p1 = new Point(3, 8);
    Point p2 = new Point(9, 4);

    Assert.assertEquals(p1.calcDistance(p2), 7.211102550927978);

  }
  @Test
  public void testCalcDistancefail (){
    Point p1 = new Point(2, 8);
    Point p2 = new Point(5, 4);

    Assert.assertEquals(p1.calcDistance(p2), 5);

  }

}
