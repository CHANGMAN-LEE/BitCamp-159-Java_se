import java.util.Scanner;

class ATMTest implements Runnable{
	private long depositeMoney = 100000;	//�ܾ�
	private long balance;					//ã���� �ϴ� �ݾ�

	public static void main(String[] args){
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(atm, "����");
		Thread son = new Thread(atm, "�Ƶ�");
		mom.start();
		son.start();
	}

	@Override
	public synchronized void run(){		//synchronized << ���� ���°ź��� ó��!!
		System.out.println(Thread.currentThread().getName()+"�� �ȳ��ϼ���.");
		Scanner scan = new Scanner(System.in);
		System.out.print("ã�����ϴ� �ݾ��� �Է��ϼ���. : ");
		balance = scan.nextLong();

		withDraw();
	}

	public void withDraw(){
		if(balance > depositeMoney){
			System.out.println("�ܾ� �ʰ�!!");
		}else{
			if(balance%10000 == 0){
				depositeMoney = depositeMoney - balance;
				System.out.println("�ܾ��� " + depositeMoney + "�� �Դϴ�.");
			}else{
				System.out.println("���� ������ �Է����ּ���.");
			}
		}
	}
}
