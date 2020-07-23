class MethodTest4 {

	public static void main(String[] args) {

		int a= Integer.parseInt(args[0]);
		double b = Double.parseDouble(args[1]);
		System.out.println(a + " + " + b + " = " + (a+b));

	}

}


/*
	형변환 Casting
	클래스 - 클래스, 객체 - 객체		가능
	String타입을 int타입으로 변환?	불가능!!
	메소드로 변환해서 해야함!!
*/