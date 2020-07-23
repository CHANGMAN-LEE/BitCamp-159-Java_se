class MethodTest2 {

	public static void main(String[] args) {
		//System.out.println("합 = " + (25 + 36));
		//System.out.println();

		MethodTest2 s = new MethodTest2();

		System.out.println("합 = " + s.sum(25, 36));
		System.out.println("차 = " + s.sub(25, 36));
		System.out.println("곱 = " + s.mul(25, 36));
		System.out.println("몫 = " + s.div(25, 36));
	}

	public int sum(int a, int b){	//함수안에 변수는 parameter!! 변수가 아니야!!
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
