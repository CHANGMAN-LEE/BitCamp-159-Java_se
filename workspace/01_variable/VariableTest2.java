class VariableTest2 {
	int a;	//�ʵ�, �ʱ�ȭ�� �Ǿ�����. ��� ������ 0�� ����.
	static int b;

	public static void main(String[] args) {
		int a=10;	//local variable(��������), garbage(������ ��)
		System.out.println("a="+a);

		System.out.println("�ʵ� a="+ new VariableTest2().a);

		System.out.println("�ʵ� b="+ VariableTest2.b);
		System.out.println("�ʵ� b="+ b);
	}
}
