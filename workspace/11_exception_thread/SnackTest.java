class SnackTest extends Thread{
	private String str;

	public SnackTest(String str){
		this.str = str;
	}

	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(str + "/t i = " + i + "\t" + Thread.currentThread());
		}
	}


	public static void main(String[] args){
		SnackTest aa = new SnackTest("새우깡");
		SnackTest bb = new SnackTest("포카칩");
		SnackTest cc = new SnackTest("꼬북이");

		aa.setName("새우깡");
		bb.setName("포카칩");
		cc.setName("꼬북이");

		//우선순위
		aa.setPriority(Thread.NORM_PRIORITY);		//현재 기본값 5
		bb.setPriority(Thread.MIN_PRIORITY);		//1
		cc.setPriority(Thread.MAX_PRIORITY);		//10

		aa.start();			//스레드 시작 - 스레드 실행 (run Method를 call -> run())
		try{
			aa.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		bb.start();
		cc.start();
	}
}