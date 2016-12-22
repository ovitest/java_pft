package ru.stqa.pft.sandbox;

public class Distance {

	public static void main(String[] args) {

		Point p1 = new Point(3, 3);
		Point p2 = new Point(5, 6);

		System.out.println("Расстояние между точками с координатами " +"x="+p1.x + ",y="+ p1.y + " и " + "x="+p2.x + ",y="+p2.y+" = "+ p1.calcDistance(p2));

	}

}
