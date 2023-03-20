package com.Test;

public class Rectangle extends Shape implements Movable {

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Rectangle(int width, int x, int y) {
		super(new Point(x,y));
		this.width = width;
	}


	private int width;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void move(int x, int y) {
		Point p = getPoint();
		   p.setX(p.getX() + x + 2);
		   p.setY(p.getY() + y + 2);
		   setPoint(p);
		
	}

	@Override
	public double getArea() {
		return Math.round(Math.pow(width, 2));
		
	}

	@Override
	public double getCircumference() {
		return Math.round(4 * width) ;
	}
	@Override
	public String toString() {
		return getClass().getSimpleName() + " \t" + width + " \t" + getPoint().getX() + " \t" + getPoint().getY() + " \t" + getArea() + " \t" + getCircumference();
	}
}
