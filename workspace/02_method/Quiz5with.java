import java.util.Random;
import java.util.Scanner;

class Quiz5with {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int i, j, user;
		int count = 0;

		for(i=0; i<5; i++){
			int a = (int)(random.nextDouble()*90)+10;
			int b = (int)(random.nextDouble()*90)+10;
			for(j=1; j<2; j++){
				System.out.println((i+1) + "�� ����");
				System.out.print(a + " + " + b + " = ");
				user = scanner.nextInt();
				if(user == (a+b)){
					System.out.println("����!!");
					System.out.println();
					count++;
					break;
				}else{
					if(j==1){
						System.out.println("����̤�");
					}else{
						System.out.println("����̤�");
						System.out.println("������ " + (a+b));
					System.out.println();}
				}
			}
		}//for

		System.out.println("����� " + count + "���� ���߾ "
										+ (100/i)*count + "�� �Դϴ�.");

		scanner.close();
	}//main
}
