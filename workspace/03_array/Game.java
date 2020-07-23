/*
	���� ���� �� ����!!
	������ 1, ������ 2, ���� 3���� ����!!
	��ǻ�ʹ� 1~3������ ������ �߻�!!
	���� 1000������ ����.

	[������]
	***************
	1.���� 2.���� 3.��
	***************
	��ȣ �Է� : 2

	���ñݾ� : 200

	����� ������ Enter�� ġ����.

	��ǻ�� : ����		����� : ����

	You Win!!
	����� �ݾ� 1200�� �Դϴ�.
*/

import java.util.Random;
import java.util.Scanner;
import java.io.*;

class Game {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int money = 0;
		int batting;

		System.out.print("������ �ݾ��� �Է����ּ��� : ");
		money = scanner.nextInt();
		System.out.println(money + "���� �����Ǿ����ϴ�.");
		System.out.println();
		
		while(true){
			int com = (int)(random.nextDouble()*3)+1;

			if(money <= 0){
				System.out.println("������ �ٽ� �Ͻðڽ��ϱ�?");
				System.out.print("\t Y\t N : ");
				//int answer = scanner.nextInt();
				String answer = scanner.next();
				System.out.println();
				if(answer.equalsIgnoreCase("y")){
					System.out.println("�󸶸� �����Ͻðڽ��ϱ� ?");
					money = scanner.nextInt();
					System.out.println(money + "���� �����Ǿ����ϴ�.");
					System.out.println();
				}else{
					System.out.println("�̿��� �ּż� �����մϴ�.");
					break;
				}
			}//if -> money�� 0�� �϶�

			System.out.println("*******************************");
			System.out.println(" 1.����  2.����  3.��  4.����");
			System.out.println("*******************************");

			System.out.print("��ȣ �Է� : ");
			int user = scanner.nextInt();

			if(user == 4){
				System.out.println("�̿��� �ּż� �����մϴ�.");
				break;
			}//if -> �����ư 4���� ������ ��

			System.out.println();
			
			while(true){
				System.out.print("���� �ݾ� : ");
				batting = scanner.nextInt();
				if(batting > money){
					System.out.println("�����Ͻ� �ݾ��� �����Ͻ� �ݾ��� �ʰ��Ͽ����ϴ�.");
					System.out.println();
					continue;
				}else{
					System.out.println();
					break;
				}
			}
		
			System.out.println("����� ������ Enter�� ġ����.");
			pause();

			if(user == 1){
				if(com == 1){
					System.out.println("��ǻ�� : ����\t ����� : ����");
					System.out.println("�����ϴ�.");
					System.out.println("����� �ݾ��� " + money + "�� �Դϴ�.");
				}else if(com == 2){
					System.out.println("��ǻ�� : ����\t ����� : ����");
					System.out.println("����� �����ϴ�.");
					money-=batting;
					System.out.println("����� �ݾ��� " + money + "�� �Դϴ�.");
				}else{
					System.out.println("��ǻ�� : ��\t ����� : ����");
					System.out.println("����� �̰���ϴ�.");
					money+=batting;
					System.out.println("����� �ݾ��� " + money + "�� �Դϴ�.");
				}
			}else if(user == 2){
				if(com == 1){
					System.out.println("��ǻ�� : ����\t ����� : ����");
					System.out.println("����� �̰���ϴ�.");
					money+=batting;
					System.out.println("����� �ݾ��� " + money + "�� �Դϴ�.");
				}else if(com == 2){
					System.out.println("��ǻ�� : ����\t ����� : ����");
					System.out.println("�����ϴ�.");
					System.out.println("����� �ݾ��� " + money + "�� �Դϴ�.");
				}else{
					System.out.println("��ǻ�� : ��\t ����� : ����");
					System.out.println("����� �����ϴ�.");
					money-=batting;
					System.out.println("����� �ݾ��� " + money + "�� �Դϴ�.");
				}
			}else if(user == 3){
				if(com == 1){
					System.out.println("��ǻ�� : ����\t ����� : ��");
					System.out.println("����� �����ϴ�.");
					money-=batting;
					System.out.println("����� �ݾ��� " + money + "�� �Դϴ�.");
				}else if(com == 2){
					System.out.println("��ǻ�� : ����\t ����� : ��");
					System.out.println("����� �̰���ϴ�.");
					money+=batting;
					System.out.println("����� �ݾ��� " + money + "�� �Դϴ�.");
				}else{
					System.out.println("��ǻ�� : ��\t ����� : ��");
					System.out.println("�����ϴ�.");
					System.out.println("����� �ݾ��� " + money + "�� �Դϴ�.");
				}
			}else{
				System.out.println("��ȣ�� �߸� �Է��Ͽ����ϴ�.");
			}//if -> ���� ����

			System.out.println();
		}//while

		scanner.close();
	}

	public static void pause() {
		try {
		System.in.read();
		} catch (IOException e) { }
	}

}
