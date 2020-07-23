
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class BaseballWith {
	public static void main(String[] args) throws IOException{

		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int[] com = new int[3];
		int[] user = new int[3];
		int choice;
		int strike = 0;
		int ball = 0;

		do{
			System.out.print("������ �����Ͻðڽ��ϱ�? (y/n) : ");
			choice = System.in.read();
			scanner.nextLine();
		}while(choice !='Y' && choice !='y' && choice !='N' && choice !='N');

		if(choice == 'Y' || choice == 'y'){
			for(int i=0; i<com.length; i++){
				com[i] = (int)(random.nextDouble()*9)+1;
				for(int j=0; j<i; j++){
					if(com[j] == com[i]){
						i--;
						break;
					}//if
				}//for j
			}//for i
			System.out.println(com[0] + ", " + com[1] + ", " + com[2]);

			while(true){
				System.out.print("���ڸ� �Է����ּ���. : ");
				for(int i=0; i<user.length; i++){
					user[i] = System.in.read()-'0';
				}//for i
				System.in.read();
				System.in.read();
				strike = ball = 0;
				for(int i=0; i<com.length; i++){
					for(int j=0; j<user.length; j++){
						if(com[i] == user[j]){
							if(i == j) strike++;
							else ball++;
						}
					}//for j
				}//for i
				System.out.println(strike + "strike  " + ball + "ball");
				System.out.println();
				if(strike == 3){
					System.out.println("����! ���ӳ�!");
					break;
				}
			}//while
		}//if

		System.out.println("���α׷��� �����մϴ�.");
	
	}
}
