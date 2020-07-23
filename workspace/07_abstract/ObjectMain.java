class Test{
	@Override
	public String toString(){
		return getClass() + "개밥";
	}
}

class Sample {}

class ObjectMain extends Object{
	public static void main(String[] args){
		Test t = new Test();
		System.out.println("객체 t = " + t);
		System.out.println("객체 t = " + t.toString());
		
		System.out.println();

		Sample s = new Sample();
		System.out.println("객체 s = " + s);
		System.out.println("객체 s = " + s.toString());
		System.out.println("객체 s = " + s.hashCode());

		System.out.println();

		String str = "apple";
		System.out.println("객체 str = " + str);
		System.out.println("객체 str = " + str.toString());
		System.out.println("객체 str = " + str.hashCode()); //믿지마~

		System.out.println();

		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc==dd" + (cc==dd));
		System.out.println("cc.equals(dd)" + cc.equals(dd)); // 참조값 비교
		
		System.out.println();

		Object ee = new String("apple");
		Object ff = new String("apple);
		System.out.println("ee==ff" + (ee==ff));
		System.out.println("ee.equals(ff)" + ee.equals(ff)); // 문자열 비교
	}
}

/*
	class Object{
		public String toString(){} //클래스@16진수
		public int hashCode(){} //10진수
		public boolean equals(Object ){}//참조값 비교
	}

	class String extends Object{
		public String toString(){} //문자열
		public int hashCode(){} // 문자열을 10진수로 변환 (문자열 무한 개수)
		public boolean equals(Object ){}//문자열 비교
	}
*/