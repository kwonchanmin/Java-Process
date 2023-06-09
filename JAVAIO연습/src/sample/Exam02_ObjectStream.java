package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Exam02_ObjectStream {

	public static void main(String[] args) {
		
		// 먼저 stream을 통해 내보낼 hashmap을 간단하게 만들어야한다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "홍길동");
		map.put("2", "신사임당");
		map.put("3", "강감찬");
		
		// 실제 파일을 생성하려면 당연히 자바쪽에서 파일 객체를 만들어야한다.
		File file = new File("readme.txt");

		try {
			FileOutputStream fis = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fis);
			
			oos.writeObject(map);
			
		} catch (Exception e) {
		}
		
	}
}
