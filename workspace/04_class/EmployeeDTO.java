/*
	직원의 월급 계산 프로그램
	항목은 이름(name), 직급(position), 기본급(basicPay), 수당(extraPay), 세율(taxRate), 월급(salary)


	세율
	200만원 이하 1%
	400만원 이하 0.02
	400만원 초과 0.03

	월급 -> 기본급  수당 - (기본급+수당) * 세율

	set/get 설정, calcPay()에서 계산

	[실행결과]
	이름 : 홍길동
	직급 : 과장
	기본급 : 2500000
	수당 : 1000000

	-> 홍길동 과장 2500000 1000000 0.02 3430000
*/

class EmployeeDTO {
	private String name;
	private String position;
	private int basicPay;
	private int extraPay;
	private double taxRate;
	private int salary;

	public void setData(String n,  String p, int bP, int eP){
		name = n;
		position = p;
		basicPay = bP;
		extraPay = eP;
	}
	public void taxRate(){
		if(basicPay <= 2000000){
			taxRate = 0.01;
		}else if(basicPay <= 4000000){
			taxRate = 0.02;
		}else if(basicPay > 4000000){
			taxRate = 0.03;
		}
	}
	public void salary(){
		salary = (basicPay + extraPay) - (int)((basicPay + extraPay) * taxRate);
	}


	public String getName(){
		return name;
	}
	public String getPosition(){
		return position;
	}
	public int getBasicPay(){
		return basicPay;
	}
	public int getExtraPay(){
		return extraPay;
	}
	public double getTaxRate(){
		return taxRate;
	}
	public int getSalary(){
		return salary;
	}

	
}
