class SubTest extends SuperTest {
	private String name;
	private int age;

	public SubTest(String name, int age, double weight, double height){
		System.out.println("SubTest 생성자");
		this.name = name;
		this.age = age;
		super.weight = weight;
		super.height = height;
	}

	public void output(){
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		//System.out.println("몸무게 = " + weight);
		//System.out.println("키 = " + height);
		//disp();	//처음에는 나한데서 찾다가 없으면 super로 가서 찾는다.
		super.disp();
	}

	public static void main(String[] args) {
		SubTest aa = new SubTest("홍길동", 25, 72.5, 175.3);		//생성자가 2번 호출(지꺼 부모꺼)
		aa.output();
		System.out.println("--------------------");
		aa.disp();
		System.out.println("====================");

		SuperTest bb = new SubTest("코난", 13, 40.3, 153.8);		//부모것만 불러올 수 있다.
		//bb.output();	<<error
		bb.disp();
	}
}
