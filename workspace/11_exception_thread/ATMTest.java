import java.util.Scanner;

class ATMTest implements Runnable{
	private long depositeMoney = 100000;	//잔액
	private long balance;					//찾고자 하는 금액

	public static void main(String[] args){
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");
		mom.start();
		son.start();
	}

	@Override
	public synchronized void run(){		//synchronized << 먼저 들어온거부터 처리!!
		System.out.println(Thread.currentThread().getName()+"님 안녕하세요.");
		Scanner scan = new Scanner(System.in);
		System.out.print("찾고자하는 금액을 입력하세요. : ");
		balance = scan.nextLong();

		withDraw();
	}

	public void withDraw(){
		if(balance > depositeMoney){
			System.out.println("잔액 초과!!");
		}else{
			if(balance%10000 == 0){
				depositeMoney = depositeMoney - balance;
				System.out.println("잔액은 " + depositeMoney + "원 입니다.");
			}else{
				System.out.println("만원 단위로 입력해주세요.");
			}
		}
	}
}
