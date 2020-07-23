class InputTest {

	public static void main(String[] args){

		System.out.println("배열명 agrs = " + args);

		for(int i=0; i<args.length; i++){
			System.out.println();
			System.out.println("args[" + i + "] = " + args[i]);
			System.out.println("글자 수 = " + args[i].length());
			System.out.println("첫 글자 = " + args[i].charAt(0));
		}//for

		System.out.println();

		System.out.println("확장형 for");
		for(String data : args){
			System.out.println(data);
		}

	}

}



/*
	* 변수				* 배열
	자료형 변수명			자료형[] 배열명 = {값, 값, 값};

	* 메소드()
*/
