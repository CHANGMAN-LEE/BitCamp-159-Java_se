class ArrayTest {
	public static void main(String[] args) {
		int[] ar;
		ar = new int[5];

		ar[0] = 27;
		ar[1] = 35;
		ar[2] = 12;
		ar[3] = 64;
		ar[4] = 31;
		
		System.out.println("순서대로 출력!!");
		for(int i=0; i<ar.length; i++){
			System.out.println((i+1) + "번째 배열명 ar[" + i + "] = " + ar[i]);
		}

		System.out.println("\n거꾸로 출력!!");
		for(int i=ar.length-1; i>=0; i--){
			System.out.println((i+1) + "번째 배열명 ar[" + i + "] = " + ar[i]);
		}

		System.out.println("\n홀수데이터만 출력!!");
		for(int i=0; i<ar.length; i++){
			if((ar[i] % 2) != 0){
				System.out.println((i+1) + "번째 배열명 ar[" + i + "] = " + ar[i]);
			}
		}

	}
}
