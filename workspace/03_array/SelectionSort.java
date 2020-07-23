//중요!!
class SelectionSort {
	public static void main(String[] args) {
		System.out.println();
		
		int[] ar = new int[]{36, 25, 12, 48, 30};
		int[] ar2 = new int[]{36, 25, 12, 48, 30};
		int temp;
		int temp2;
		
		System.out.println("오름차순===================");
		for(int i = 0; i < ar.length-1; i++){
			for(int j = i + 1; j < ar.length; j++){
				if(ar[i] > ar[j]){
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}//if
			}//for j
		}//for i
		for(int data : ar){
			System.out.println(data + "  ");
		}//for data

		System.out.println("\n내림차순===================");
		for(int i = 0; i < ar2.length-1; i++){
			for(int j = i + 1; j < ar2.length; j++){
				if(ar2[i] < ar2[j]){
					temp2 = ar2[i];
					ar2[i] = ar2[j];
					ar2[j] = temp2;
				}//if
			}//for j
		}//for i
		for(int data2 : ar2){
			System.out.println(data2 + "  ");
		}//for data
	
	}//main
}
