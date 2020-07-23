interface InterA{
	public static final String NAME = "홍길동";	//상수..!! 인터페이스에는 상수만 들어온다.
	int AGE = 25;	//public static final << 생략!! 즉, 변수가 아니다.

	public abstract void aa();
	public void bb();	//abstract << 생략!!
	//public void cc(){}	//구현부 즉, {}이게 있으면 안대...
}