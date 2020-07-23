import java.util.Scanner;

class SungJukMain2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		SungJuk[] sj = new SungJuk[3]; //객체배열

		sj[0] = new SungJuk();
		sj[1] = new SungJuk();
		sj[2] = new SungJuk();

		sj[0].setData("유명한", 43, 61, 88);
		sj[1].setData("남도일", 99, 97, 99);
		sj[2].setData("하인성", 91, 95, 92);
		
		System.out.println(" 이름\t\t국어\t영어\t수학\t총점\t평균\t\t학점");
		for(int i = 0; i < sj.length; i++){
			/*sj[i] = new SungJuk(); //<<<<얘가 클래스를 만드는거야!!
			
			System.out.println((i+1) + "번째 학생의 이름과 점수를 입력해주세요.");
			System.out.print("이름 점수 : ");
			String name = scanner.nextLine();
			System.out.print("국어 점수 : ");
			int kor = scanner.nextInt();
			System.out.print("영어 점수 : ");
			int eng = scanner.nextInt();
			System.out.print("수학 점수 : ");
			int math = scanner.nextInt();

			sj[i].setData(name, kor, eng, math);*/
			sj[i].calcTot();
			sj[i].calcAvg();
			sj[i].calcGrade();

			System.out.println(sj[i].getName() + "\t\t " + sj[i].getKor() + "\t " + sj[i].getEng() + "\t " + sj[i].getMath() + "\t " + sj[i].getTot() + "\t" + String.format("%.2f", sj[i].getAvg()) + "\t\t " + sj[i].getGrade());
		}

		
		scanner.close();		
	}
}
