import java.util.Scanner;

class SungJukMain2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		SungJuk[] sj = new SungJuk[3]; //��ü�迭

		sj[0] = new SungJuk();
		sj[1] = new SungJuk();
		sj[2] = new SungJuk();

		sj[0].setData("������", 43, 61, 88);
		sj[1].setData("������", 99, 97, 99);
		sj[2].setData("���μ�", 91, 95, 92);
		
		System.out.println(" �̸�\t\t����\t����\t����\t����\t���\t\t����");
		for(int i = 0; i < sj.length; i++){
			/*sj[i] = new SungJuk(); //<<<<�갡 Ŭ������ ����°ž�!!
			
			System.out.println((i+1) + "��° �л��� �̸��� ������ �Է����ּ���.");
			System.out.print("�̸� ���� : ");
			String name = scanner.nextLine();
			System.out.print("���� ���� : ");
			int kor = scanner.nextInt();
			System.out.print("���� ���� : ");
			int eng = scanner.nextInt();
			System.out.print("���� ���� : ");
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
