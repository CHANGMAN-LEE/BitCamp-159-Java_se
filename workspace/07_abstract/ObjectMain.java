class Test{
	@Override
	public String toString(){
		return getClass() + "����";
	}
}

class Sample {}

class ObjectMain extends Object{
	public static void main(String[] args){
		Test t = new Test();
		System.out.println("��ü t = " + t);
		System.out.println("��ü t = " + t.toString());
		
		System.out.println();

		Sample s = new Sample();
		System.out.println("��ü s = " + s);
		System.out.println("��ü s = " + s.toString());
		System.out.println("��ü s = " + s.hashCode());

		System.out.println();

		String str = "apple";
		System.out.println("��ü str = " + str);
		System.out.println("��ü str = " + str.toString());
		System.out.println("��ü str = " + str.hashCode()); //������~

		System.out.println();

		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc==dd" + (cc==dd));
		System.out.println("cc.equals(dd)" + cc.equals(dd)); // ������ ��
		
		System.out.println();

		Object ee = new String("apple");
		Object ff = new String("apple);
		System.out.println("ee==ff" + (ee==ff));
		System.out.println("ee.equals(ff)" + ee.equals(ff)); // ���ڿ� ��
	}
}

/*
	class Object{
		public String toString(){} //Ŭ����@16����
		public int hashCode(){} //10����
		public boolean equals(Object ){}//������ ��
	}

	class String extends Object{
		public String toString(){} //���ڿ�
		public int hashCode(){} // ���ڿ��� 10������ ��ȯ (���ڿ� ���� ����)
		public boolean equals(Object ){}//���ڿ� ��
	}
*/