class FactoryMain{
	private int product;

	public synchronized void produce(){
		if(product>4){
			System.out.println("생산 중단 : " + product);
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		product++;
		System.out.println("생산 : " + product);
		notifyAll();
	}

	public synchronized void sell(){
		if(product<1){
			System.out.println("소비 중단 : " + product);
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		product--;
		System.out.println("소비 : " + product);
		notifyAll();
	}
//------------
	class Worker extends Thread{
		private Factory factory;

		public Worker(Factory factory){
			this.factory = factory;
		}

		public void run(){
			for(int i=0; i<10; i++){
				factory.produce();
			}
		}
	}
//------------
	class Buyer extends Thread{
		private Factory factory;

		public Buyer(Factory factory){
			this.factory = factory;
		}

		public void run(){
			for(int i=0; i<10; i++){
				factory.sell();
			}
		}
	}
//------------
	public static void main(String[] args){
		Factory f = new Factory();

		Worker w = new Worker(f);
		Buyer b = new Buyer(f);
		
		w.start();
		b.start();
	}
}
