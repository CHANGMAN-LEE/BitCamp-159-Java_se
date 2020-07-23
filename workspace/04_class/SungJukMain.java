/*
	setData(이름, 국어, 영어, 수학)
	
	이름	국어	영어	수학	총점	평균	학점
	Lee	90	91	91

	학점 평균이 90이상이면 A
	80 B
	70 C
	60 D
	그외 F
*/

import java.util.Scanner;

class SungJukMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		SungJuk sj = new SungJuk();
		sj.setData("하인성", 90, 91, 91);
		sj.calcTot();
		sj.calcAvg();
		sj.calcGrade();

		SungJuk sj2 = new SungJuk();
		sj2.setData("김전일", 85, 54, 82);
		sj2.calcTot();
		sj2.calcAvg();
		sj2.calcGrade();

		SungJuk sj3 = new SungJuk();
		sj3.setData("남도일", 100, 100, 97);
		sj3.calcTot();
		sj3.calcAvg();
		sj3.calcGrade();

		System.out.println("이름\t\t국어\t영어\t수학\t총점\t평균\t\t학점");
		System.out.println(sj.getName() + "\t\t " + sj.getKor() + "\t " + sj.getEng() + "\t " + sj.getMath() + "\t " + sj.getTot() + "\t" + String.format("%.2f", sj.getAvg()) + "\t\t " + sj.getGrade());
		System.out.println(sj2.getName() + "\t\t " + sj2.getKor() + "\t " + sj2.getEng() + "\t " + sj2.getMath() + "\t " + sj2.getTot() + "\t" + String.format("%.2f", sj2.getAvg()) + "\t\t " + sj2.getGrade());
		System.out.println(sj3.getName() + "\t\t " + sj3.getKor() + "\t " + sj3.getEng() + "\t " + sj3.getMath() + "\t " + sj3.getTot() + "\t" + String.format("%.2f", sj3.getAvg()) + "\t\t " + sj3.getGrade());

		
		
		scanner.close();
	}
}
