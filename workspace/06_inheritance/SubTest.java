class SubTest extends SuperTest {
	private String name;
	private int age;

	public SubTest(String name, int age, double weight, double height){
		System.out.println("SubTest ������");
		this.name = name;
		this.age = age;
		super.weight = weight;
		super.height = height;
	}

	public void output(){
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
		//System.out.println("������ = " + weight);
		//System.out.println("Ű = " + height);
		//disp();	//ó������ ���ѵ��� ã�ٰ� ������ super�� ���� ã�´�.
		super.disp();
	}

	public static void main(String[] args) {
		SubTest aa = new SubTest("ȫ�浿", 25, 72.5, 175.3);		//�����ڰ� 2�� ȣ��(���� �θ�)
		aa.output();
		System.out.println("--------------------");
		aa.disp();
		System.out.println("====================");

		SuperTest bb = new SubTest("�ڳ�", 13, 40.3, 153.8);		//�θ�͸� �ҷ��� �� �ִ�.
		//bb.output();	<<error
		bb.disp();
	}
}
