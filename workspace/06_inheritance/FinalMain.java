class Final{
	public final String FRUIT = "���";
	public final String FRUIT2;

	public static final String ANIMAL = "����";
	public static final String ANIMAL2;

	static{
		ANIMAL2 ="�⸰";
	}

	public Final(){
		this.FRUIT2 = "����";
	}
}

//--------------------

class FinalMain{
	public static void main(String[] args){
		final int AGE = 10;
		System.out.println("��� AGE = " + AGE);

		final int AGE2;
		AGE2 = 20;
		System.out.println("��� AGE2 = " + AGE2);
		
		Final f = new Final();
		System.out.println("FRUIT = " + f.FRUIT);
		System.out.println("FRUIT2 = " + f.FRUIT2);
		System.out.println("ANIMAL = " + Final.ANIMAL);
		System.out.println("ANIMAL2 = " + Final.ANIMAL2);
	}
}