class GuGuDan3 {
	public static void main(String[] args) {

		int dan, i, j;

		System.out.println("=============================================");
		for(j=2; j<10; j+=3){
			for(i = 1; i < 10; i++){
				for(dan = j; dan < j+3; dan++){
					if(dan < 10){
						System.out.print(dan + " * " + i + " = " + (dan*i) + "\t");
					}//if
				}//for dan
				System.out.println();
			}//for i
			System.out.println("=============================================");
		}//for j

	}
}
