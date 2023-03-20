package assignment;

import java.util.Scanner;

public class Test01 {

	// 우리프로그램을 실행시키려면
	//javac ExampleTest.java => compile
	// 결과로 bytecode인 ExampleTest.class 파일이 생성된다
	// java ExampleTest 엔터눌러서 실행
	// java ExampleTest 10 20 
	// class package explorer 에서 class 파일을 오른쪽 마우스로 눌러 Run as 누르고 Run con~ 눌러 args 눌러서 안에 자료 넣기
	public static void main(String[] args) {
		
		int a; 
		int b;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수 : ");
		a = sc.nextInt();
		System.out.println("두번째 정수 : ");
		b = sc.nextInt();
		
		int c = a % b;
		
		if( c > 1) {
			System.out.println("나머지가 1보다 크다!");
		}else if(c <= 1){
			System.out.println("나머지가 1보다 작거나 같다!");
		}
		
				
		}
		
	}

