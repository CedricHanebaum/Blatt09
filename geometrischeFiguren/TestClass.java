package geometrischeFiguren;

import java.awt.Point;

public class TestClass {

	public static void main(String[] args) throws InterruptedException {
		Grafik g = new Grafik(800, 600);
		
		Rechteck r1 = new Rechteck(new Point(100, 200), new Point(200, 100));
		g.add(r1);
		
		Kreis k1 = new Kreis(new Point(400, 300), 50);
		g.add(k1);
	}

}
