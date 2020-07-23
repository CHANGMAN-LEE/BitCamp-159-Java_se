class SingleTon{
	private int num = 3;
	private static SingleTon instance;

	public static SingleTon getInstance(){
		synchronized(SingleTon.class){
			if(instance == null){
				instance = new SingleTon();
			}
		}
		return instance;
	}

	public static void main(String[] args){
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = " + aa);
		System.out.println("num = " + aa.num);
		System.out.println();

		SingleTon bb = new SingleTon();
		bb.num++;
		System.out.println("bb = " + bb);
		System.out.println("num = " + bb.num);
		System.out.println();

		System.out.println("====== ΩÃ±€≈Ê ======");
		SingleTon cc = SingleTon.getInstance();
		cc.num++;
		System.out.println("cc = " + cc);
		System.out.println("num = " + cc.num);
		System.out.println();

		SingleTon dd = SingleTon.getInstance();
		dd.num++;
		System.out.println("dd = " + dd);
		System.out.println("num = " + dd.num);
		System.out.println();
	}	
}
