class SuperTest {
	protected double weight, height;	//생성자를 통해서 데이터 초기화

	public SuperTest(){
		System.out.println("SuperTest 기본 생성자");
	}

	public SuperTest(double weight, double height){
		System.out.println("SuperTest 생성자");
		this.weight = weight;
		this.height = height;
	}

	public void disp(){
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
	}
}
