/*
	�л��� �̸��� ������� �Է¹޾Ƽ� ������ ���Ͻÿ�.
	[������]
	�̸� �Է� : ȫ�浿
	����� �Է� : 12141 (���ڿ�)

	�̸�		1 2 3 4 5		����
	Lee		o x o x o		60
*/

import java.util.Scanner;

class Quiz6_changman {
	public static void main(String[] args) {
		final String ANSWER = "11111";
		Scanner scanner = new Scanner(System.in);

		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = scanner.nextLine();
		System.out.print("������� �Է��ϼ��� : ");
		String answer_sheet = scanner.nextLine();
		String[] a = new String[5];
		int count = 0;
		int i;

		for(i=0; i<5; i++){
			//System.out.print((i+1) + "�� ������ ������ �Է��ϼ��� : ");
			//char answer = scanner.next().charAt(0);
			char[] answer = answer_sheet.toCharArray();
			if(answer[i] == ANSWER.charAt(i)){
				a[i] = "O";
				count++;
			}else{
				a[i] = "X";
			}
		}
		
		System.out.println();
		System.out.println("= = = = = = = = = " + name + "���� ����� = = = = = = = = =");
		System.out.println("�̸�\t 1��\t2��\t3��\t4��\t5��\t ����");
		System.out.println(name + "\t  " + a[0] + "\t " + a[1] + "\t " + a[2] + "\t " + a[3] + "\t " + a[4] + "\t  " + (100/i)*count);
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = =");

		scanner.close();
	}
}
