package com.Test4;

public abstract class Shape {

	public Shape() {
		
	}
	
	public Shape(Point point) {
		this.point = point;
	}
	
	protected Point point;
	
	public abstract double getArea();
	
	public abstract double getCircumference();

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	
}
