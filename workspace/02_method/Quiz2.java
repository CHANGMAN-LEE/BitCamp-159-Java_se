/*
	10 ~ 99 ������ ������ 2�� �߻��Ͽ� ���� ���ߴ� ����.
	[������]
	12 + 36 = ���� �־���

*/

import java.util.Random;
import java.util.Scanner;

class Quiz2 {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int user;
		int a = (int)(random.nextDouble()*90)+10;
		int b = (int)(random.nextDouble()*90)+10;
		int count = 0;

		System.out.println("1~100���� �߿��� �ΰ��� ���ڰ� �߻��Ͽ����ϴ�.");
		System.out.println("=========== �� ������ ���� ���纸����~!! ===========");
		while(true){
			System.out.print("���ڸ� �Է����ּ��� : ");
			user = scanner.nextInt();
			if(user < (a+b)){
				System.out.println(user + "���� Ů�ϴ�.");
				//System.out.println("�߻��� ���� a�� " + a + ", �߻��� ���� b�� " + b + "�Դϴ�.");
				count++;
				System.out.println();
			}else if(user > (a+b)){
				System.out.println(user + "���� �۽��ϴ�.");
				//System.out.println("�߻��� ���� a�� " + a + ", �߻��� ���� b�� " + b + "�Դϴ�.");
				count++;
				System.out.println();
			}else{
				System.out.println("�����Դϴ�!!");
				System.out.println("�߻��� ���� a�� " + a + ", �߻��� ���� b�� " + b + "�Դϴ�.");
				System.out.println(count + "������ ���߼̽��ϴ�.");
				break;
			}//if
		}//while

		scanner.close();
	}//main
}

//System.out.println();