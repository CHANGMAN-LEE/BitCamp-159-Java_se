/*
	������ ����...!!

	*************
	1. ����
	2. ����
	3. ���
	4. ��
	*************
	��ȣ :
*/

import java.util.Scanner;

class ArrayTest5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean[] car = new boolean[5];
		int count = 0;

		while(true){
			System.out.println("***********�������ּ���***********");
			System.out.print("1.����  2.����  3.���  4.�� : ");
			
			int choice = scanner.nextInt();

			if(choice == 1){			//----------------------------------����
				System.out.print("1~5 �ڸ��� �������ּ��� : ");
				int place = scanner.nextInt();
				if(place == 1){
					if(car[0] == true){
						System.out.println("������� �ڸ��Դϴ�.");
					}else{
						car[0] = true;
						System.out.println("�����Ǿ����ϴ�.");
						count++;
					}
					System.out.println();
				}else if(place == 2){
					if(car[1] == true){
						System.out.println("������� �ڸ��Դϴ�.");
					}else{
						car[1] = true;
						System.out.println("�����Ǿ����ϴ�.");
						count++;
					}
					System.out.println();
				}else if(place == 3){
					if(car[2] == true){
						System.out.println("������� �ڸ��Դϴ�.");
					}else{
						car[2] = true;
						System.out.println("�����Ǿ����ϴ�.");
						count++;
					}
					System.out.println();
				}else if(place == 4){
					if(car[3] == true){
						System.out.println("������� �ڸ��Դϴ�.");
					}else{
						car[3] = true;
						System.out.println("�����Ǿ����ϴ�.");
						count++;
					}
					System.out.println();
				}else if(place == 5){
					if(car[4] == true){
						System.out.println("������� �ڸ��Դϴ�.");
					}else{
						car[4] = true;
						System.out.println("�����Ǿ����ϴ�.");
						count++;
					}
					System.out.println();
				}else{
					System.out.println("�ٽ� �������ּ���.");
					System.out.println();
				}
			}else if(choice == 2){		//----------------------------------����
				System.out.print("1~5 �ڸ��� �������ּ��� : ");
				int place = scanner.nextInt();
				if(place == 1){
					if(car[0] != true){
						System.out.println("����ִ� �ڸ��Դϴ�.");
					}else{
						car[0] = false;
						System.out.println("�����Ǿ����ϴ�.");
						count--;
					}
					System.out.println();
				}else if(place == 2){
					if(car[1] != true){
						System.out.println("����ִ� �ڸ��Դϴ�.");
					}else{
						car[1] = false;
						System.out.println("�����Ǿ����ϴ�.");
						count--;
					}
					System.out.println();
				}else if(place == 3){
					if(car[2] != true){
						System.out.println("����ִ� �ڸ��Դϴ�.");
					}else{
						car[2] = false;
						System.out.println("�����Ǿ����ϴ�.");
						count--;
					}
					System.out.println();
				}else if(place == 4){
					if(car[3] != true){
						System.out.println("����ִ� �ڸ��Դϴ�.");
					}else{
						car[3] = false;
						System.out.println("�����Ǿ����ϴ�.");
						count--;
					}
					System.out.println();
				}else if(place == 5){
					if(car[4] != true){
						System.out.println("����ִ� �ڸ��Դϴ�.");
					}else{
						car[4] = false;
						System.out.println("�����Ǿ����ϴ�.");
						count--;
					}
					System.out.println();
				}else{
					System.out.println("�ٽ� �������ּ���.");
					System.out.println();
				}
			}else if(choice == 3){		//----------------------------------���
				for(int i = 0; i < car.length; i++){
					System.out.println((i+1) + "��° ��ġ : " + car[i]);
				}
				System.out.println("���� ������� �ڸ��� " + count + "�ڸ��̰� ��밡���� �ڸ��� " + (5-count) + "�Դϴ�.");
				System.out.println();
			}else if(choice == 4){		//----------------------------------����
				System.out.println("�̿����ּż� �����մϴ�.");
				break;
			}else{
				System.out.println("�ٽ� �������ּ���.");
				System.out.println();
			}

		}//while


		System.out.println();

		scanner.close();
	}
}
