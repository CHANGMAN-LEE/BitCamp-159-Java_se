class StringMain {
	public static void main(String[] args) {
		String aa= "apple";		//literal ����
		String bb= "apple";
		if(aa == bb) System.out.println("a�� b�� �������� ����.");	//�۾��� ���°� �ƴ϶� �ּҰ��� ��...!!
		else System.out.println("a�� b�� �������� �ٸ���.");
		if(aa.equals(bb)) System.out.println("a�� b�� ���ڿ��� ����.");	//���ڿ��� ���ϱ� ���ؼ��� equals�� �̿��Ѵ�.
		else System.out.println("a�� b�� ���ڿ��� �ٸ���.");
		System.out.println();

		String cc = new String("apple");
		String dd = new String("apple");
		if(cc == dd) System.out.println("a�� b�� �������� ����.");
		else System.out.println("a�� b�� �������� �ٸ���.");
		if(cc.equals(dd)) System.out.println("a�� b�� ���ڿ��� ����.");
		else System.out.println("a�� b�� ���ڿ��� �ٸ���.");
		System.out.println();

		String ee = "���� ���� ��¥�� " + 2020 + "-" + 4 + "-" + 13 + "(Mon)";
		System.out.println(ee);
		System.out.println("���ڿ� ũ�� " + ee.length());
		System.out.println("���� ���� " + ee.charAt(4));
		System.out.println("���ڿ� " + ee.substring(7));
		System.out.println("���ڿ� " + ee.substring(7, 11));
		
		System.out.println();
		System.out.println("�빮�� ���� " + "Hello".toUpperCase());
		System.out.println("�ҹ��� ���� " + "Hello".toLowerCase());
		
		System.out.println();
		System.out.println("���ڿ� �˻� " + ee.indexOf("¥"));
		System.out.println("���ڿ� �˻� " + ee.indexOf("��¥"));
		System.out.println("���ڿ� �˻� " + ee.indexOf("���ٺ�"));

		System.out.println();
		System.out.println("���ڿ� ġȯ = " + ee.replace("����", "����"));
	}
}