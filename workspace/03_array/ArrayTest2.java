/*
	크키가 50개인 정수형 배열을 만들어라!!
	배열안에 65~90사이의 난수를 발생하여 저장하시오!!
*/

import java.util.Random;

class ArrayTest2 {
	public static void main(String[] args) {
		Random random = new Random();

		int[] ar = new int[50];

		for(int i = 0; i < ar.length; i++){
			ar[i] = (int)(random.nextDouble()*26)+65;			
			//System.out.println((i+1) + "번째 배열명 ar[" + i + "] = " + (char)ar[i]);
			System.out.print((char)ar[i] + " ");
			if((i+1) % 10 == 0){
				System.out.println();
			}
		}

	}
}
