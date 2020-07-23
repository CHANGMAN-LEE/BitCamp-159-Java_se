import java.util.Random;

class ArrayTest3 {
	public static void main(String[] args) {
		Random random = new Random();

		int[] ar = new int[50];
		int count = 0;

		for(int i = 0; i < ar.length; i++){
			ar[i] = (int)(random.nextDouble()*26)+65;			
			//System.out.println((i+1) + "번째 배열명 ar[" + i + "] = " + (char)ar[i]);
			System.out.print((char)ar[i] + " ");
			if((i+1) % 10 == 0){
				System.out.println();
			}//if (i+1) % 10 == 0
			if(ar[i] == 65){
			count++;
			}//if ar[i] == 65
		}//for i
		System.out.println("\nA의 개수" + count);
	}
}
