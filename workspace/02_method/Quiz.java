/*
	1~100������ ������ �߻��Ͽ� ���ߴ� ����
	
	[������]
	1~100 ������ ������ �߻��Ͽ����ϴ�.
	
	�����Է��� ��ĳ��!!

	���� �Է� : 60
	60���� Ů�ϴ�.

	�����Է� : 90
	90���� �۽��ϴ�.

	...

	�����Է� : 85
	������~
	??������ ���߼̽��ϴ�.
*/

import java.util.Random;
import java.util.Scanner;

class Quiz {
	public static void main(String[] args) {
		//System.out.println();
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int num;
		int r = (int)(random.nextDouble()*100)+1;
		int count = 0;

		//System.out.println(r);

		System.out.println("1~100���� �߿��� �ϳ��� ���ڰ� �߻��Ͽ����ϴ�.");
		System.out.println("=========== ���纸����~!! ===========");

		while(true){
			System.out.print("���ڸ� �Է����ּ��� : ");
			num = scanner.nextInt();
			if(num != r){
				if(num > r){
					System.out.println(num + "���� �۽��ϴ�.");
				}else if(num < r){
					System.out.println(num + "���� Ů�ϴ�.");
				}
				count++;
				System.out.println();
			}else if(num == r){
					System.out.println("�����Դϴ�!!");
					System.out.println(count + "������ ���߼̽��ϴ�.");
				break;
			}//if

		}//while
		
		scanner.close();
	}//main
}
