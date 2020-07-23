class Synchronized extends Thread{
	private static int count = 0;

	public static void main(String[] args){
		System.out.println();
		Synchronized aa = new Synchronized();
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();

		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");

		//스레드 시작 - 스레드 실행
		aa.start();
		bb.start();
		cc.start();
	}

	/*public synchronized void run(){		//동기화 X
		for(int i=1; i<=5; i++){
			count++;
			System.out.println(Thread.currentThread().getName() + ",  count = " + count);
		}
	}*/

	public void run(){						//동기화 O
		synchronized(Synchronized.class){
			for(int i=1; i<=5; i++){
				count++;
				System.out.println(Thread.currentThread().getName() + ",  count = " + count);
			}
		}
	}

	/*public void run(){						//동기화 X
		synchronized(this){
			for(int i=1; i<=5; i++){
				count++;
				System.out.println(Thread.currentThread().getName() + ",  count = " + count);
			}
		}
	}*/
}
