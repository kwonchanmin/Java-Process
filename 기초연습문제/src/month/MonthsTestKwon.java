package month;

import java.util.HashMap;
import java.util.Scanner;

public class MonthsTestKwon {

	
	public static void main(String[] args) {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	map.put(1, 31);
	
	map.put(2, 28);
	
	map.put(3, 31);
	
	map.put(4, 30);
	
	map.put(5, 31);
	
	map.put(6, 30);
	
	map.put(7, 31);
	
	map.put(8, 31);
	
	map.put(9, 30);
	
	map.put(10, 31);
	
	map.put(11, 30);
	
	map.put(12, 31);
	
//	Scanner sc = new Scanner(System.in);
//	
//	int a;
//	a = sc.nextInt();
	String a = args[0];
	int b = Integer.parseInt(a);
	System.out.println("입력받을월 :" + b + "월");
	System.out.println("마지막일자 : " + map.get(b) + "일");
	
//	if(a != a) {
//		System.out.println("다시 입력해 주세요.");
//	} else if( a  ) {
//		
//	}
	}
	
	}

