/*
	가위 바위 보 게임!!
	가위는 1, 바위는 2, 보는 3으로 설정!!
	컴퓨터는 1~3사이의 난수를 발생!!
	돈은 1000원으로 시작.

	[실행결과]
	***************
	1.가위 2.바위 3.보
	***************
	번호 입력 : 2

	배팅금액 : 200

	결과를 보려면 Enter를 치세요.

	컴퓨터 : 가위		사용자 : 바위

	You Win!!
	당신의 금액 1200원 입니다.
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

		System.out.print("충전할 금액을 입력해주세요 : ");
		money = scanner.nextInt();
		System.out.println(money + "원이 충전되었습니다.");
		System.out.println();
		
		while(true){
			int com = (int)(random.nextDouble()*3)+1;

			if(money <= 0){
				System.out.println("게임을 다시 하시겠습니까?");
				System.out.print("\t Y\t N : ");
				//int answer = scanner.nextInt();
				String answer = scanner.next();
				System.out.println();
				if(answer.equalsIgnoreCase("y")){
					System.out.println("얼마를 충전하시겠습니까 ?");
					money = scanner.nextInt();
					System.out.println(money + "원이 충전되었습니다.");
					System.out.println();
				}else{
					System.out.println("이용해 주셔서 감사합니다.");
					break;
				}
			}//if -> money가 0원 일때

			System.out.println("*******************************");
			System.out.println(" 1.가위  2.바위  3.보  4.종료");
			System.out.println("*******************************");

			System.out.print("번호 입력 : ");
			int user = scanner.nextInt();

			if(user == 4){
				System.out.println("이용해 주셔서 감사합니다.");
				break;
			}//if -> 종료버튼 4번을 눌렀을 때

			System.out.println();
			
			while(true){
				System.out.print("배팅 금액 : ");
				batting = scanner.nextInt();
				if(batting > money){
					System.out.println("배팅하신 금액이 소지하신 금액을 초과하였습니다.");
					System.out.println();
					continue;
				}else{
					System.out.println();
					break;
				}
			}
		
			System.out.println("결과를 보려면 Enter를 치세요.");
			pause();

			if(user == 1){
				if(com == 1){
					System.out.println("컴퓨터 : 가위\t 사용자 : 가위");
					System.out.println("비겼습니다.");
					System.out.println("당신의 금액은 " + money + "원 입니다.");
				}else if(com == 2){
					System.out.println("컴퓨터 : 바위\t 사용자 : 가위");
					System.out.println("당신이 졌습니다.");
					money-=batting;
					System.out.println("당신의 금액은 " + money + "원 입니다.");
				}else{
					System.out.println("컴퓨터 : 보\t 사용자 : 가위");
					System.out.println("당신이 이겼습니다.");
					money+=batting;
					System.out.println("당신의 금액은 " + money + "원 입니다.");
				}
			}else if(user == 2){
				if(com == 1){
					System.out.println("컴퓨터 : 가위\t 사용자 : 바위");
					System.out.println("당신이 이겼습니다.");
					money+=batting;
					System.out.println("당신의 금액은 " + money + "원 입니다.");
				}else if(com == 2){
					System.out.println("컴퓨터 : 바위\t 사용자 : 바위");
					System.out.println("비겼습니다.");
					System.out.println("당신의 금액은 " + money + "원 입니다.");
				}else{
					System.out.println("컴퓨터 : 보\t 사용자 : 바위");
					System.out.println("당신이 졌습니다.");
					money-=batting;
					System.out.println("당신의 금액은 " + money + "원 입니다.");
				}
			}else if(user == 3){
				if(com == 1){
					System.out.println("컴퓨터 : 가위\t 사용자 : 보");
					System.out.println("당신이 졌습니다.");
					money-=batting;
					System.out.println("당신의 금액은 " + money + "원 입니다.");
				}else if(com == 2){
					System.out.println("컴퓨터 : 바위\t 사용자 : 보");
					System.out.println("당신이 이겼습니다.");
					money+=batting;
					System.out.println("당신의 금액은 " + money + "원 입니다.");
				}else{
					System.out.println("컴퓨터 : 보\t 사용자 : 보");
					System.out.println("비겼습니다.");
					System.out.println("당신의 금액은 " + money + "원 입니다.");
				}
			}else{
				System.out.println("번호를 잘못 입력하였습니다.");
			}//if -> 게임 실행

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
