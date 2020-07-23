/*
	학생의 이름과 답안지를 입력받아서 점수를 구하시오.
	[실행결과]
	이름 입력 : 홍길동
	답안지 입력 : 12141 (문자열)

	이름		1 2 3 4 5		점수
	Lee		o x o x o		60
*/

import java.util.Scanner;

class Quiz6_changman {
	public static void main(String[] args) {
		final String ANSWER = "11111";
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름을 입력하세요 : ");
		String name = scanner.nextLine();
		System.out.print("답안지를 입력하세요 : ");
		String answer_sheet = scanner.nextLine();
		String[] a = new String[5];
		int count = 0;
		int i;

		for(i=0; i<5; i++){
			//System.out.print((i+1) + "번 문제의 정답을 입력하세요 : ");
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
		System.out.println("= = = = = = = = = " + name + "님의 답안지 = = = = = = = = =");
		System.out.println("이름\t 1번\t2번\t3번\t4번\t5번\t 점수");
		System.out.println(name + "\t  " + a[0] + "\t " + a[1] + "\t " + a[2] + "\t " + a[3] + "\t " + a[4] + "\t  " + (100/i)*count);
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = =");

		scanner.close();
	}
}
