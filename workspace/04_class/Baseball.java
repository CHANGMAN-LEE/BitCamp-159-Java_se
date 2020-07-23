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

		System.out.println("*******���� �߱� ����!!*******");
		
		while(true){
			System.out.print("1.����  2.���� : ");
			int a = scanner.nextInt();			//System.in.read(); <<�� �ѱ��ڸ� ����!!
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
				}//for -> com ���� ���� 3�� �߻� �� �ߺ� üũ

				System.out.println("���� ���� 3���� �����Ǿ����ϴ�.");

				while(true){
					System.out.print("���� 3���� �Է����ּ��� : ");
					str = scanner.next();

					for(int i=0; i<user.length; i++){
						//user[i] = scanner.nextInt();
						user[i] = (int)str.charAt(i)-48; //'1'�� 49�̹Ƿ� -48�� ���ָ� 1, (int)'2'-48 = 2
					}//for -> user ���� 3�� �Է�					

					for(int i=0; i<com.length; i++){
						for(int j=0; j<user.length; j++){
							if(com[i] == user[j] && i == j){
								strike++;
							}else if(com[i] == user[j] && i != j){
									ball++;
								}
						}
					}//for -> strike�� ball ī��Ʈ!!

					System.out.println(strike + "strike  " + ball + "ball");
					System.out.println();
					if(strike == 3){
						break;
					}
					strike = 0;
					ball = 0;
				}
				if(strike == 3){
						System.out.println("������ ���߼̽��ϴ�!!");
						System.out.println("�̿��� �ּż� �����մϴ�.");
						break;
					}
			}else if(a == 2){
				System.out.println("������ ���� �Ǿ����ϴ�.");
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
