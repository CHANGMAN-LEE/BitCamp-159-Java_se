class MethodTest2 {

	public static void main(String[] args) {
		//System.out.println("�� = " + (25 + 36));
		//System.out.println();

		MethodTest2 s = new MethodTest2();

		System.out.println("�� = " + s.sum(25, 36));
		System.out.println("�� = " + s.sub(25, 36));
		System.out.println("�� = " + s.mul(25, 36));
		System.out.println("�� = " + s.div(25, 36));
	}

	public int sum(int a, int b){	//�Լ��ȿ� ������ parameter!! ������ �ƴϾ�!!
		return a+b;
	}
	public int sub(int a, int b){
		return a-b;
	}
	public int mul(int a, int b){
		return a*b;
	}
	public double div(int a, int b){
		return (double)a/b;
	}

}
