class InputTest {

	public static void main(String[] args){

		System.out.println("�迭�� agrs = " + args);

		for(int i=0; i<args.length; i++){
			System.out.println();
			System.out.println("args[" + i + "] = " + args[i]);
			System.out.println("���� �� = " + args[i].length());
			System.out.println("ù ���� = " + args[i].charAt(0));
		}//for

		System.out.println();

		System.out.println("Ȯ���� for");
		for(String data : args){
			System.out.println(data);
		}

	}

}



/*
	* ����				* �迭
	�ڷ��� ������			�ڷ���[] �迭�� = {��, ��, ��};

	* �޼ҵ�()
*/
