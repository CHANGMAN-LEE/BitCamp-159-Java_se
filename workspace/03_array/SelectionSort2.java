import java.util.Arrays;

class SelectionSort2 {
	public static void main(String[] args) {
		System.out.println();

		int[] ar = new int[]{36, 25, 12, 48, 30};
		
		Arrays.sort(ar);

		for(int data : ar){
			System.out.println(data + "  ");
		}//for data

	}
}
