class MethodTest {
	public static void main(String[] args) {
		MethodTest.print();

		//MethodTest MT = new MethodTest();
		//MT.disp();

		//new MethodTest().disp();

		MethodTest aa; //Ŭ������ ����, ��ü
		aa = new MethodTest();
		System.out.println("��ü aa = "+aa);
		System.out.println("��ü aa = "+aa.toString());	//16����
		System.out.println("��ü aa = "+aa.hashCode());	//10����
		aa.disp();
	}

	public void disp(){
		System.out.println("non-static �޼ҵ�");
	}

	public static void print(){
		System.out.println("static �޼ҵ�");
	}
}


/*
�޼ҵ�()
- ��ɾ���� ����
*/