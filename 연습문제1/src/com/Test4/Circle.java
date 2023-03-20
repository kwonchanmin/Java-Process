package com.Test4;

public class Circle extends Shape implements Movable{

	public Circle() {
		
	}

	
	public Circle(int radius, int x, int y) {
		super(new Point(x,y));
		this.radius = radius;
		
	}

	private int radius;
	

	@Override
	public void move(int x, int y) {
		// x와 y의 좌표값을 변경하는거다!
		Point p = getPoint();
		p.setX(p.getX() + x + 1);
		p.setY(p.getY() + y + 1);
		setPoint(p);
//		move(x+2,y+2);
		}

	@Override
	public double getArea() {
		return Math.round(Math.pow(radius,2) * Math.PI); //Math 라는 클래스에서 원주율 등 수학적인 것들을 제공한다. Math.PI는 원주율 Math.pow는 제곱을 뜻한다. Math.pow(제곱할려는 길이, 제곱할려는 횟수)
	}                                                    // Math.round는 소수점 첫번째 자리에서 반올림해주는거

	@Override
	public double getCircumference() {
		return  Math.round(radius * 2 * Math.PI);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}


	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "     \t " + radius + "\t " + getPoint().getX() + "\t " + getPoint().getY() + "\t " + getArea() + "\t " + getCircumference(); 
	}
	
	
	
}
