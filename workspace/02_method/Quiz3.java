import java.util.Random;
import java.util.Scanner;

class Quiz3 {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int user;
		int count = 0;

		for(int i=0; i<5; i++){
			int a = (int)(random.nextDouble()*90)+10;
			int b = (int)(random.nextDouble()*90)+10;
			System.out.println((i+1) + "�� ����");
			System.out.print(a + " + " + b + " = ");
			user = scanner.nextInt();
			if(user == (a+b)){
				System.out.println("����!!");
				System.out.println();
			}else{
				System.out.println("����̤�");
				System.out.println();
			}
		}//for

		scanner.close();
	}//main
}
