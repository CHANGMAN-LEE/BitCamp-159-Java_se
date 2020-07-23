import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

class Lotto {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int [] lotto = new int[6];

		System.out.print("µ· ÀÔ·Â : ");
		int money = scanner.nextInt();

		for(int m=1; m<=money/1000; m++){
			for(int i=0; i<lotto.length; i++){
				lotto[i] = (int)(random.nextDouble()*45)+1;
				for(int j=0; j<i; j++){
					if(lotto[i] == lotto[j]){
						i--;
						break;//for j¸¦ ¹þ¾î³ª¶ó!!
					}//if
				}//for j
			}//for i

			Arrays.sort(lotto);

			for(int data : lotto){
				System.out.print(String.format("%-5d", data));
			}//for data

			if(m%5==0){
				System.out.println();
			}

			System.out.println();
		}
		
		scanner.close();
	}
}
