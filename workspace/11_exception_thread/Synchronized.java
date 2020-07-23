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

		//������ ���� - ������ ����
		aa.start();
		bb.start();
		cc.start();
	}

	/*public synchronized void run(){		//����ȭ X
		for(int i=1; i<=5; i++){
			count++;
			System.out.println(Thread.currentThread().getName() + ",  count = " + count);
		}
	}*/

	public void run(){						//����ȭ O
		synchronized(Synchronized.class){
			for(int i=1; i<=5; i++){
				count++;
				System.out.println(Thread.currentThread().getName() + ",  count = " + count);
			}
		}
	}

	/*public void run(){						//����ȭ X
		synchronized(this){
			for(int i=1; i<=5; i++){
				count++;
				System.out.println(Thread.currentThread().getName() + ",  count = " + count);
			}
		}
	}*/
}
