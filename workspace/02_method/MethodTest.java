class MethodTest {
	public static void main(String[] args) {
		MethodTest.print();

		//MethodTest MT = new MethodTest();
		//MT.disp();

		//new MethodTest().disp();

		MethodTest aa; //클래스형 변수, 객체
		aa = new MethodTest();
		System.out.println("객체 aa = "+aa);
		System.out.println("객체 aa = "+aa.toString());	//16진수
		System.out.println("객체 aa = "+aa.hashCode());	//10진수
		aa.disp();
	}

	public void disp(){
		System.out.println("non-static 메소드");
	}

	public static void print(){
		System.out.println("static 메소드");
	}
}


/*
메소드()
- 명령어들의 집합
*/