class FruitDTO {
	private String PUM;
	private int jan, feb, mar, tot;
	private static int sumJan, sumFeb, sumMar;

	public void FruitDTO(String PUM, int jan, int feb, int mar){
		this.PUM = PUM;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
	}

	public void calcTot(){
		this.tot = jan + feb + mar;
		sumJan += jan;
		sumFeb += feb;
		sumMar += mar;
	}

	public static void output(){
		System.out.println("\t" + sumJan + "\t" + sumFeb + "\t" + sumMar);
	}

	public void display(){
		System.out.println(PUM + "\t" + jan + "\t" + feb + "\t" + mar + "\t" + tot);
	}
	
	public String getPUM(){
		return PUM;
	}

	public int getJan(){
		return jan;
	}

	public int getFeb(){
		return feb;
	}

	public int getMar(){
		return mar;
	}

	public int getTot(){
		return tot;
	}

}

class FruitMain {
	FruitDTO[] ar = new FruitDTO[3];
	public static void main(String[] args) {
		FruitMain fm = new FruitMain();
		fm.display();
		fm.output();
	}

	private void display(){
		ar[0] = new FruitDTO();
		ar[1] = new FruitDTO();
		ar[2] = new FruitDTO();
		ar[0].FruitDTO("사과", 100, 80, 75);
		ar[1].FruitDTO("포도", 30, 25, 10);
		ar[2].FruitDTO("사과", 25, 30, 90);
		ar[0].calcTot();
		ar[1].calcTot();
		ar[2].calcTot();

		System.out.println("--------------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("--------------------------------------");
		for(int i=0; i<ar.length; i++){
			ar[i].display();
		}
		System.out.println("--------------------------------------");
	}

	private void output(){
		FruitDTO.output();
	}
}
