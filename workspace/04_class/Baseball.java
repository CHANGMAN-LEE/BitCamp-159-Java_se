import java.util.Random;
import java.util.Scanner;
import java.io.*;

class Baseball {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int[] com = new int[3];
		int[] user = new int[3];
		String str;
		int strike = 0;
		int ball = 0;

		System.out.println("*******숫자 야구 게임!!*******");
		
		while(true){
			System.out.print("1.시작  2.종료 : ");
			int a = scanner.nextInt();			//System.in.read(); <<딱 한글자만 들어옴!!
			if((a != 1) && (a != 2)){
				continue;
			}else if(a == 1){
				for(int i=0; i<com.length; i++){
					com[i] = (int)(random.nextDouble()*9)+1;
					for(int j=0; j<i; j++){
						if(com[j] == com[i]){
							i--;
							break;
						}
					}
					//System.out.print(com[i] + "\t");
				}//for -> com 랜덤 숫자 3개 발생 및 중복 체크

				System.out.println("랜덤 숫자 3개가 생성되었습니다.");

				while(true){
					System.out.print("숫자 3개를 입력해주세요 : ");
					str = scanner.next();

					for(int i=0; i<user.length; i++){
						//user[i] = scanner.nextInt();
						user[i] = (int)str.charAt(i)-48; //'1'은 49이므로 -48을 해주면 1, (int)'2'-48 = 2
					}//for -> user 숫자 3개 입력					

					for(int i=0; i<com.length; i++){
						for(int j=0; j<user.length; j++){
							if(com[i] == user[j] && i == j){
								strike++;
							}else if(com[i] == user[j] && i != j){
									ball++;
								}
						}
					}//for -> strike와 ball 카운트!!

					System.out.println(strike + "strike  " + ball + "ball");
					System.out.println();
					if(strike == 3){
						break;
					}
					strike = 0;
					ball = 0;
				}
				if(strike == 3){
						System.out.println("정답을 맞추셨습니다!!");
						System.out.println("이용해 주셔서 감사합니다.");
						break;
					}
			}else if(a == 2){
				System.out.println("게임이 종료 되었습니다.");
				break;
			}
		}//while

		scanner.close();
	}

	public static void pause() {
		try {
		System.in.read();
		} catch (IOException e) { }
	}

}
