class AA{
	public int a = 3;
	public void disp(){
		a += 5;
		System.out.print("AA : " + a + " ");
	}
}
//-------------------------
class BB extends AA{
	public int a = 8;
	public void disp(){
		this.a += 5;
		System.out.print("BB : " + a + " ");
	}
}
class TestMain2 {
	public static void main(String[] args) {
		System.out.println();
		BB bb = new BB();
		bb.disp();
		System.out.println(bb.a + " ");

		AA aa = new BB();		//�θ� = �ڽ� ����
		aa.disp();
		System.out.println(aa.a + " ");

		//BB bb2 = aa;			//�ڽ� !=(�ڽ�)�θ�
		BB bb2 = (BB)aa;		//(BB)�� �� ��ȯ�� ������Ѵ�.
		System.out.println(bb2.a + " ");

	}
}
