package com.Test;

public abstract class Shape {

	public Shape() {
		
	}
	
	public Shape(Point point) {
		super();
		this.point = point;
	}

	protected Point point;
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public abstract double getArea();
	
	public abstract double getCircumference();
}
