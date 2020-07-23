class ChildTest extends SuperTest {
	private String name;
	private int age;

	public ChildTest(String name, int age, double weight, double height){
		System.out.println("ChildTest ������");
		this.name = name;
		this.age = age;
		super.weight = weight;
		super.height = height;
	}

	public void disp(){
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
		super.disp();
	}

	public static void main(String[] args) {
		ChildTest aa = new ChildTest("ȫ�浿", 25, 72.5, 175.3);
		aa.disp();

		System.out.println("====================");

		SuperTest bb = new ChildTest("�ڳ�", 13, 40.3, 153.8);
		bb.disp();
	}
}
