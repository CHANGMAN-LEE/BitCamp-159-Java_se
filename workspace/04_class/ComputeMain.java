/*
[실행결과]
X		Y		SUM		SUB		MUL		DIV(소수 세자리)
320		258
126		89
257		126
*/

class ComputeTest {
	private int x;
	private int y;
	private int sum;
	private int sub;
	private int mul;
	private double div;

	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void calc(){
		sum = x+y;
		sub = x-y;
		mul = x*y;
		div = (double)x/y;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getSum(){
		return sum;
	}
	public int getSub(){
		return sub;
	}
	public int getMul(){
		return mul;
	}
	public double getDiv(){
		return div;
	}

}

class ComputeMain {
	public static void main(String[] args) {
		ComputeTest[] ct = new ComputeTest[3];

		ct[0] = new ComputeTest();
		ct[1] = new ComputeTest();
		ct[2] = new ComputeTest();

		ct[0].setX(320);
		ct[0].setY(258);
		
		ct[1].setX(126);
		ct[1].setY(89);
		
		ct[2].setX(257);		
		ct[2].setY(126);

		for(ComputeTest c : ct){
			c.calc();
		}//for

		System.out.println("X\tY\t합\t차\t곱\t몫");

		for(int i=0; i<ct.length; i++){
			System.out.println(ct[i].getX() + "\t" + ct[i].getY() + "\t"
									+ ct[i].getSum() + "\t"  + ct[i].getSub() + "\t"
										+ ct[i].getMul() + "\t" + String.format("%.3f", ct[i].getDiv()));
		}//for
	
	}
}
