import java.util.Random;

class ArrayTest4 {
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] ar = new int[50];
		int[] count = new int[26];

		for(int i = 0; i < ar.length; i++){
			ar[i] = (int)(random.nextDouble()*26)+65;			
			//System.out.println((i+1) + "번째 배열명 ar[" + i + "] = " + (char)ar[i]);
			System.out.print((char)ar[i] + " ");
			if((i+1) % 10 == 0){
				System.out.println();
			}//if (i+1) % 10 == 0
			for(int j=0; j<count.length; j++){
				if(ar[i] == (j+65)){
					count[j]++;
				}
			}//for j
		}//for i
		System.out.println();
		for(int i=0; i<count.length; i++){
			System.out.println((char)ar[i] + "의 개수 = " + count[i] + "개");
		}
	}
}
