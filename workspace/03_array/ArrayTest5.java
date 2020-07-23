/*
	주차장 관리...!!

	*************
	1. 입차
	2. 출차
	3. 목록
	4. 끝
	*************
	번호 :
*/

import java.util.Scanner;

class ArrayTest5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean[] car = new boolean[5];
		int count = 0;

		while(true){
			System.out.println("***********선택해주세요***********");
			System.out.print("1.입차  2.출차  3.목록  4.끝 : ");
			
			int choice = scanner.nextInt();

			if(choice == 1){			//----------------------------------입차
				System.out.print("1~5 자리를 선택해주세요 : ");
				int place = scanner.nextInt();
				if(place == 1){
					if(car[0] == true){
						System.out.println("사용중인 자리입니다.");
					}else{
						car[0] = true;
						System.out.println("입차되었습니다.");
						count++;
					}
					System.out.println();
				}else if(place == 2){
					if(car[1] == true){
						System.out.println("사용중인 자리입니다.");
					}else{
						car[1] = true;
						System.out.println("입차되었습니다.");
						count++;
					}
					System.out.println();
				}else if(place == 3){
					if(car[2] == true){
						System.out.println("사용중인 자리입니다.");
					}else{
						car[2] = true;
						System.out.println("입차되었습니다.");
						count++;
					}
					System.out.println();
				}else if(place == 4){
					if(car[3] == true){
						System.out.println("사용중인 자리입니다.");
					}else{
						car[3] = true;
						System.out.println("입차되었습니다.");
						count++;
					}
					System.out.println();
				}else if(place == 5){
					if(car[4] == true){
						System.out.println("사용중인 자리입니다.");
					}else{
						car[4] = true;
						System.out.println("입차되었습니다.");
						count++;
					}
					System.out.println();
				}else{
					System.out.println("다시 선택해주세요.");
					System.out.println();
				}
			}else if(choice == 2){		//----------------------------------출차
				System.out.print("1~5 자리를 선택해주세요 : ");
				int place = scanner.nextInt();
				if(place == 1){
					if(car[0] != true){
						System.out.println("비어있는 자리입니다.");
					}else{
						car[0] = false;
						System.out.println("출차되었습니다.");
						count--;
					}
					System.out.println();
				}else if(place == 2){
					if(car[1] != true){
						System.out.println("비어있는 자리입니다.");
					}else{
						car[1] = false;
						System.out.println("출차되었습니다.");
						count--;
					}
					System.out.println();
				}else if(place == 3){
					if(car[2] != true){
						System.out.println("비어있는 자리입니다.");
					}else{
						car[2] = false;
						System.out.println("출차되었습니다.");
						count--;
					}
					System.out.println();
				}else if(place == 4){
					if(car[3] != true){
						System.out.println("비어있는 자리입니다.");
					}else{
						car[3] = false;
						System.out.println("출차되었습니다.");
						count--;
					}
					System.out.println();
				}else if(place == 5){
					if(car[4] != true){
						System.out.println("비어있는 자리입니다.");
					}else{
						car[4] = false;
						System.out.println("출차되었습니다.");
						count--;
					}
					System.out.println();
				}else{
					System.out.println("다시 선택해주세요.");
					System.out.println();
				}
			}else if(choice == 3){		//----------------------------------목록
				for(int i = 0; i < car.length; i++){
					System.out.println((i+1) + "번째 위치 : " + car[i]);
				}
				System.out.println("현재 사용중인 자리는 " + count + "자리이고 사용가능한 자리는 " + (5-count) + "입니다.");
				System.out.println();
			}else if(choice == 4){		//----------------------------------종료
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}else{
				System.out.println("다시 선택해주세요.");
				System.out.println();
			}

		}//while


		System.out.println();

		scanner.close();
	}
}
