/*
	2~9단 만들기
*/

class GuGuDan {
	public static void main(String[] args) {
		int dan, i;

		for(dan = 2; dan < 10; dan++){
			for(i = 1; i < 10; i++){
				System.out.println(dan + " * " + i + " = " + (dan*i));
			}//for i
			System.out.println();
		}//for dan
	}
}
