package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam01_KeyboardInput {

	public static void main(String[] args) {
		
		System.out.println("키보드로 한줄을 입력하세요!");
		
		// 키보드로부터 입력을 받으려면 데이터 연결 통로(Stream)이 있어야 해요!
		// System.in이 제공되는데.. InputStream class의 객체예요. 사용하기 너무 불편하다.
		// 문자 기반의 데이터를 받기를 원하니.. Reader를 하나 만들어야한다!!
		// new InputStreamReader(System.in) 이렇게 Stream을 결합해서 조금 더
		// 편한 문자 기반의 통로를 열었다. => 그럼에도 불구하고 불편하다!
		// 조금 더 문자 기반의 데이터 입력 연결통로를 만들어 볼꺼다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		
		try {
			String s = br.readLine();
			System.out.println("입력받은 데이터는 : " + s);
		} catch (IOException e) {
		}
		
	}
}
