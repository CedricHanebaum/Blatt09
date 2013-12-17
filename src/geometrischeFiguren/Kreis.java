package geometrischeFiguren;

import java.awt.Point;
import java.util.ArrayList;

public class Kreis extends Figur{
	
	public static int RESOLUTION = 100;
	
	private Point center;
	private int radius;
	
	public Kreis(Point center, int radius){
		this.center = new Point(center);
		this.radius = radius;
		
		this.createFigur();
	}

	private void createFigur() {
		punkte = new ArrayList<Point>();
		for(int i = 1; i <= RESOLUTION + 1; i++){
			int gegenkathete = (int) (Math.sin((Math.PI/(RESOLUTION/2)) * i) * radius);
			int ankathete = (int) (Math.cos((Math.PI/(RESOLUTION/2)) * i) * radius);
			punkte.add(new Point(center.x + ankathete, center.y + gegenkathete));
		}
	}


}
