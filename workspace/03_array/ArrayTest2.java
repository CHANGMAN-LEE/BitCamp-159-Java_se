/*
	ũŰ�� 50���� ������ �迭�� ������!!
	�迭�ȿ� 65~90������ ������ �߻��Ͽ� �����Ͻÿ�!!
*/

import java.util.Random;

class ArrayTest2 {
	public static void main(String[] args) {
		Random random = new Random();

		int[] ar = new int[50];

		for(int i = 0; i < ar.length; i++){
			ar[i] = (int)(random.nextDouble()*26)+65;			
			//System.out.println((i+1) + "��° �迭�� ar[" + i + "] = " + (char)ar[i]);
			System.out.print((char)ar[i] + " ");
			if((i+1) % 10 == 0){
				System.out.println();
			}
		}

	}
}
