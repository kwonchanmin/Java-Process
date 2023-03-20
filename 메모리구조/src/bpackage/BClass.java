package bpackage;

class BClass {

	// 1.constructor
		//private 생성자는 사용될까?
	    // 이러면 같은 package 안에서 다른 class에 의해 객체생성이 안되는데요?
	    //일반적으로 이렇게 사용하는것에 대한 장점이 없어요,
	    //그런데.. 딱 1가지 이렇게 사용하는 경우가 있어요 => singleton(싱글톤 패턴)
	    BClass() {
			
		}
		
		// 2.field
		private int bField;
		// bField 라는 private field는 우리 class 내에서만 조회와 변경이
		// 가능하도록 처리해야된다.
		//특수한 목적의 method를 이용해야 한다.
		// 하나는 private field의 값을 조회하는 목적을 가진 method
		// 다른 하나는 private field의 값을 변경하는 목적을 가진 method
		// getter(field의 값을 조회) & setter (field의 값을 설정)
		// getter를 만들어보자(값을 알아내는)
		// access modifier는 public

		public int getbField() {
			return bField;
		}
        public void setbField(int bField) {
			this.bField = bField;
		}
	
	
		
		
		
		// 3.method
		void bMethod() {
			System.out.println("하이하이.");
		}

}


	
