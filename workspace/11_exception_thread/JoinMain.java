class JoinTest implements Runnable{
	@Override
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(i);
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				
			}
		}
	}
}

class JoinMain{
	public static void main(String[] args) throws InterruptedException{
		JoinTest jt = new JoinTest();
		Thread t = new Thread(jt);

		System.out.println("스레드 시작!!");
		t.start();

		t.join();

		System.out.println("스레드 종료!!");
	}
}
