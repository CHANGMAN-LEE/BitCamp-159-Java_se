/*
	1~100사이의 난수를 발생하여 맞추는 게임
	
	[실행결과]
	1~100 사이의 난수가 발생하였습니다.
	
	숫자입력은 스캐너!!

	숫자 입력 : 60
	60보다 큽니다.

	숫자입력 : 90
	90보다 작습니다.

	...

	숫자입력 : 85
	딩동댕~
	??번만에 맞추셨습니다.
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

		System.out.println("1~100까지 중에서 하나의 숫자가 발생하였습니다.");
		System.out.println("=========== 맞춰보세요~!! ===========");

		while(true){
			System.out.print("숫자를 입력해주세요 : ");
			num = scanner.nextInt();
			if(num != r){
				if(num > r){
					System.out.println(num + "보다 작습니다.");
				}else if(num < r){
					System.out.println(num + "보다 큽니다.");
				}
				count++;
				System.out.println();
			}else if(num == r){
					System.out.println("정답입니다!!");
					System.out.println(count + "번만에 맞추셨습니다.");
				break;
			}//if

		}//while
		
		scanner.close();
	}//main
}
