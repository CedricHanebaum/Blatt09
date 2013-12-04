package geometrischeFiguren;

import java.awt.Point;
import java.util.ArrayList;

public class Rechteck extends Figur {

	private Point upperLeft;
	private int width, height;

	public Rechteck(Point p1, Point p2) {
		Point tmp = new Point(p2.x - p1.x, p2.y - p1.y);
		if ((tmp.x > 0 && tmp.y > 0) || (tmp.x < 0 && tmp.y < 0)) {
			if (tmp.x > 0) {
				upperLeft = p1;
				width = p2.x - p1.x;
				height = p2.y - p1.y;
			} else {
				upperLeft = p2;
				width = p1.x - p2.x;
				height = p1.y - p2.y;
			}
		} else {
			if (tmp.x > 0) {
				upperLeft = new Point(p2.x - p1.x, p1.y - p2.y);
				width = p2.x - upperLeft.x;
				height = p1.y - upperLeft.y;
			} else {
				upperLeft = new Point(p1.x - p2.x, p2.y - p1.y);
				width = p1.x - upperLeft.x;
				height = p2.y - upperLeft.y;
			}
		}
		this.createFigure();
	}

	public Rechteck(Rechteck r) {
		this.upperLeft = new Point(r.upperLeft);
		this.width = r.width;
		this.height = r.height;
		this.createFigure();
	}

	public void skaliere(double d) {
		upperLeft = new Point(upperLeft.x - (int) ((width * d) / 4), upperLeft.y - (int) ((height * d) / 4));
		height *= d;
		width *= d;
		this.createFigure();
	}

	public Rechteck vereinige(Rechteck r) {
		Point tmp = new Point(r.upperLeft.x - this.upperLeft.x, r.upperLeft.y - this.upperLeft.y);
		if ((tmp.x > 0 && tmp.y > 0) || (tmp.x < 0 && tmp.y < 0)) {
			if (tmp.x > 0) {
				return new Rechteck(this.upperLeft, new Point(r.upperLeft.x + r.width, r.upperLeft.y + r.height));
			} else {
				return new Rechteck(r.upperLeft, new Point(this.upperLeft.x + this. width, this.upperLeft.y + this.height));
			}
		} else {
			if (tmp.x > 0) {
				return new Rechteck(new Point(this.upperLeft.x, r.upperLeft.y), new Point(r.upperLeft.x + r.width, this.upperLeft.y + this.height));
			} else {
				return new Rechteck(new Point(r.upperLeft.x, this.upperLeft.y), new Point(this.upperLeft.x + this.width, r.upperLeft.y + r.height));
			}
		}
	}

	private void createFigure() {
		punkte = new ArrayList<Point>();
		punkte.add(new Point(upperLeft));
		punkte.add(new Point(upperLeft.x + width, upperLeft.y));
		punkte.add(new Point(upperLeft.x + width, upperLeft.y + height));
		punkte.add(new Point(upperLeft.x, upperLeft.y + height));
		punkte.add(new Point(upperLeft));
	}

	public String toString() {
		return "Rechteck: Hoehe=" + height + " Breite=" + width;
	}

}
