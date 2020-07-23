class VarArgs{
	private int a, b, sum;

	public VarArgs(){}
	public int sum(int...ar){ //배열타입으로 들어옴.
		int hap = 0;
		for(int i=0; i<ar.length; i++){
			hap += ar[i];
		}
		return hap;
	}
}

class VarArgsMain {
	public static void main(String[] args) {
		VarArgs aa = new VarArgs();
		System.out.println("합 = " + aa.sum(10, 20));
		System.out.println("합 = " + aa.sum(10, 20, 30));
		System.out.println("합 = " + aa.sum(10, 20, 30, 40));
	}
}
