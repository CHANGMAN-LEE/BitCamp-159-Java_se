class StaticTest {
	private int a;			//필드, 인스턴스변수
	private static int b;	//필드, 클래스변수

	static{					//스태틱의 초기화 영역
		System.out.println("초기화 영역");
		b=3;
	}

	public StaticTest(){
		System.out.println("기본 생성자");
		a=3;
	}

	public void calc(){
		a++;
		b++;
	}

	public void disp(){
		System.out.println("a=" + a + "\t b=" + b);
	}

	public static void output(){
		System.out.println("static method...");
		//System.out.println("a=" + a + "\t b=" + b); -> error
	}

	public static void main(String[] args) {
		StaticTest aa = new StaticTest();
		aa.calc();
		aa.disp();
		System.out.println();

		StaticTest bb = new StaticTest();
		bb.calc();
		bb.disp();
		System.out.println();

		StaticTest cc = new StaticTest();
		cc.calc();
		cc.disp();
		System.out.println();
		
		StaticTest.output();
		output();
		aa.output();
		bb.output();
		cc.output();
	
	}
}
