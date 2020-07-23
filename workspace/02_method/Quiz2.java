/*
	10 ~ 99 사이의 난수를 2개 발생하여 합을 맞추는 게임.
	[실행결과]
	12 + 36 = 답을 넣어줘

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

		System.out.println("1~100까지 중에서 두개의 숫자가 발생하였습니다.");
		System.out.println("=========== 두 숫자의 합을 맞춰보세요~!! ===========");
		while(true){
			System.out.print("숫자를 입력해주세요 : ");
			user = scanner.nextInt();
			if(user < (a+b)){
				System.out.println(user + "보다 큽니다.");
				//System.out.println("발생한 난수 a는 " + a + ", 발생한 난수 b는 " + b + "입니다.");
				count++;
				System.out.println();
			}else if(user > (a+b)){
				System.out.println(user + "보다 작습니다.");
				//System.out.println("발생한 난수 a는 " + a + ", 발생한 난수 b는 " + b + "입니다.");
				count++;
				System.out.println();
			}else{
				System.out.println("정답입니다!!");
				System.out.println("발생한 난수 a는 " + a + ", 발생한 난수 b는 " + b + "입니다.");
				System.out.println(count + "번만에 맞추셨습니다.");
				break;
			}//if
		}//while

		scanner.close();
	}//main
}

//System.out.println();