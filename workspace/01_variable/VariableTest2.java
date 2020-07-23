class VariableTest2 {
	int a;	//필드, 초기화가 되어있음. 얘는 무조건 0이 나옴.
	static int b;

	public static void main(String[] args) {
		int a=10;	//local variable(지역변수), garbage(쓰레기 값)
		System.out.println("a="+a);

		System.out.println("필드 a="+ new VariableTest2().a);

		System.out.println("필드 b="+ VariableTest2.b);
		System.out.println("필드 b="+ b);
	}
}
