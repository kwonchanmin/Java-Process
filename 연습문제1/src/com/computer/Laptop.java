package com.computer;

public class Laptop extends Computer implements Graphic{

	public Laptop() {
		
	}
	
	public Laptop(String name, int cpu, int memory,int battery) {
		super(name,cpu,memory,battery);
	}

	@Override
	public double rendering(int size) {
		return (double)size/(getCpu() * getMemory())*20;
	}

	@Override
	public void operate(int time) {
		// 입력으로 들어온 시간 10 당 1씩 배터리가 감소
		// 프로그램에서 연산(+,-,*,/)은 일단 같은 데이터 타입끼리 발생.
		int result = time / 10;
		setBattery(getBattery() - result);
//		if(time < 10) {
//			setBattery(getBattery());
//		}else {
//			setBattery(getBattery() - (time / 10));
//		}
	}
	
}
