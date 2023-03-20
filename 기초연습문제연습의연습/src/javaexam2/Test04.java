package javaexam2;

import java.util.*;

public class Test04 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		for(int inx= 0; inx < 10; inx ++) {
			int data = (int)(Math.random() *10 +1);
			list.add(data);
			System.out.print(data + " ");
		}
		System.out.println(" ");
		Collections.sort(list);
		
		for(int inx =0; inx < 10; inx++) {
			System.out.print(list.get(inx)+" ");
		}
			
		}
	}

