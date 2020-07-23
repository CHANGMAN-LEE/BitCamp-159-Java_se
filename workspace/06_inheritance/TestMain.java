class Test{
	int a, b;
}
//--------------------
class TestMain {
	public static void main(String[] args) {
		System.out.println();
		Test aa = new Test();
		Test bb = aa;
		aa.a = 10;
		aa.b = 20;
		System.out.println(aa.a + "\t" + aa.b);		//10, 20
		System.out.println(bb.a + "\t" + bb.b);		//10, 20

		bb.a = 30;
		bb.b = 40;
		System.out.println(aa.a + "\t" + aa.b);		//30, 40
		System.out.println(bb.a + "\t" + bb.b);		//30, 40

		bb = new Test();
		bb.a = 50;
		bb.b = 60;
		System.out.println(aa.a + "\t" + aa.b);		//30, 40
		System.out.println(bb.a + "\t" + bb.b);		//50, 60

	}
}
