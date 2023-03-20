package assignment;

public class CharTest {

	public static void main(String[] args) {
		
		String str = "JavaProgramming";
		String result = "";
		
		 char[] arr = str.toCharArray(); // String -> char[]
	        char[] reversedArr = new char[arr.length];
	        for(int i=0; i<arr.length; i++){
	            reversedArr[arr.length-1-i] = arr[i];
	        }

	        String reversedStr = new String(reversedArr);
	
			for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ' ')
				result += str.charAt(i);
		
		}
		
		
		
		System.out.println(reversedStr.toLowerCase());
	}
}
