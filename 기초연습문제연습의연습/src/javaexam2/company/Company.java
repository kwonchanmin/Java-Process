package javaexam2.company;

import java.util.HashMap;

public class Company {

	public static void main(String[] args) {
		
		HashMap<Integer, Employee> map = new HashMap<>();
		map.put(1, new Secretary("Hilery",1,"secretary", 800));
		map.put(2, new Sales("Clinten",2,"sales", 1200));
		
		for(Integer i : map.keySet()) {
			System.out.println(map.get(i));
		}
		for(Integer i : map.keySet()) {
			((Bonus)map.get(i)).incentive(100);
			System.out.println(map.get(i) + "\t " + map.get(i).tax() );
		}
	
	}
}
