class ChildTest extends SuperTest {
	private String name;
	private int age;

	public ChildTest(String name, int age, double weight, double height){
		System.out.println("ChildTest 생성자");
		this.name = name;
		this.age = age;
		super.weight = weight;
		super.height = height;
	}

	public void disp(){
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		super.disp();
	}

	public static void main(String[] args) {
		ChildTest aa = new ChildTest("홍길동", 25, 72.5, 175.3);
		aa.disp();

		System.out.println("====================");

		SuperTest bb = new ChildTest("코난", 13, 40.3, 153.8);
		bb.disp();
	}
}
