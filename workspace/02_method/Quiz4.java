import java.util.Random;
import java.util.Scanner;

class Quiz4 {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int i;
		int user;
		int count = 0;

		for(i=0; i<5; i++){
			int a = (int)(random.nextDouble()*90)+10;
			int b = (int)(random.nextDouble()*90)+10;
			System.out.println((i+1) + "번 문제");
			System.out.print(a + " + " + b + " = ");
			user = scanner.nextInt();
			if(user == (a+b)){
				System.out.println("정답!!");
				System.out.println();
				count++;
			}else{
				System.out.println("오답ㅜㅜ");
				System.out.println();
			}
		}//for

		System.out.println("당신은 " + count + "개를 맞추어서 "
										+ (100/i)*count + "점 입니다.");

		scanner.close();
	}
}
