class StaticTest {
	private int a;			//�ʵ�, �ν��Ͻ�����
	private static int b;	//�ʵ�, Ŭ��������

	static{					//����ƽ�� �ʱ�ȭ ����
		System.out.println("�ʱ�ȭ ����");
		b=3;
	}

	public StaticTest(){
		System.out.println("�⺻ ������");
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
