/*
	���� �޾Ƽ� �������� ���Ͻÿ�.
	[������]
	java GuGuDan 5
*/
class GuGuDan {

	public static void main(String[] args) {

		int dan= Integer.parseInt(args[0]);
		
		for(int i=1; i<10; i++){
			System.out.println(dan + " * " + i + " = " + (dan*i));
		}//for
		
	}//main

}
