/*�̸�, ����, ����, ������ �Է� �޾Ƽ� ������ ����� ���Ͻÿ�.
��, ������ calcTot() ���Ͽ� ��ȯ, ������ calcAvg() ���Ͽ� ��ȯ

[������]
�̸� �Է�:
�������� �Է�:
�������� �Է�:
�������� �Է�:

		*** ȫ�浿�� ����ǥ ***
����:  ����:  ����:  ����:  ���:*/

import java.util.Scanner;

class SungJuk {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("�̸� �Է� : ");
		String name = scanner.nextLine();
		System.out.print("�������� �Է� : ");
		int kor = scanner.nextInt();
		System.out.print("�������� �Է� : ");
		int eng = scanner.nextInt();
		System.out.print("�������� �Է� : ");
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
		System.out.println("*** "+a+"�� ����ǥ ***");
		System.out.println("����\t����\t����\t����\t���");
		System.out.println(" "+b+"\t "+c+"\t "+d+"\t "+e+"\t "+String.format("%.2f", f));
	}

}
