/*이름, 국어, 영어, 점수를 입력 받아서 총점과 평균을 구하시오.
단, 총점은 calcTot() 구하여 반환, 총점은 calcAvg() 구하여 반환

[실행결과]
이름 입력:
국어점수 입력:
영어점수 입력:
수학점수 입력:

		*** 홍길동의 성펵표 ***
국어:  영어:  수학:  총점:  평균:*/

import java.util.Scanner;

class SungJuk {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름 입력 : ");
		String name = scanner.nextLine();
		System.out.print("국어점수 입력 : ");
		int kor = scanner.nextInt();
		System.out.print("영어점수 입력 : ");
		int eng = scanner.nextInt();
		System.out.print("수학점수 입력 : ");
		int math = scanner.nextInt();

		SungJuk sj = new SungJuk();
		int tot = sj.calcTot(kor, eng, kor);
		double avg = sj.calcAvg(tot);
		sj.disp(name, kor, eng, math, tot, avg);

		scanner.close();
	}

	public int calcTot(int a, int b, int c){
		return a+b+c;
	}

	public double calcAvg(int a){
		return a/3.0;
	}

	public void disp(String a, int b, int c, int d, int e, double f){
		System.out.println("*** "+a+"의 성적표 ***");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println(" "+b+"\t "+c+"\t "+d+"\t "+e+"\t "+String.format("%.2f", f));
	}

}
