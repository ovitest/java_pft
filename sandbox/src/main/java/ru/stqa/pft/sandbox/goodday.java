package ru.stqa.pft.sandbox;

public class Goodday {

	public static void main(String[] args) {
				hello("Vladimir");

		Point p1 = new Point();
		p1.x = 2;
		p1.y = 3;
		Point p2 = new Point();
		p2.x = 5;
		p2.y = 2;
		System.out.println("Расстояние между точками с координатами " +"x="+p1.x + ",y="+ p1.y + " и " + "x="+p2.x + "y="+p2.y+" = "+ distance(p1,p2));


		Square s = new Square(4);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4, 9);
		System.out.println("Площадь прямоугольника со сторонами " +  r.a + " и " + r.b + " = " + r.area());
	}

	public static void hello(String somebody) {

		System.out.println("Hello, " + somebody + "!");
	}

	public static double distance(Point p1, Point p2){
		return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x)+(p1.y - p2.y)*(p1.y - p2.y));
	}

}
