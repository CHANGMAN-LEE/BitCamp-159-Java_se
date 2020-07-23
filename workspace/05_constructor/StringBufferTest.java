import java.util.Scanner;

class StringBufferTest {
	Scanner scanner = new Scanner(System.in);
	private int dan;

	public StringBufferTest(){
		System.out.print("원하는 단을 입력 : ");
		this.dan = scanner.nextInt();
	}

	/*public void display(){
		for(int i = 1; i < 10; i++){
			System.out.println(this.dan + "*" + i + "=" + dan*i);
		}
	}*/

	//String 버퍼로 처리!!
	public void display(){
		StringBuffer buffer = new StringBuffer();
		for(int i = 1; i < 10; i++){
			buffer.append(dan);
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan*i);

			System.out.println(buffer);
			buffer.delete(0, buffer.length());
		}
	}

	public static void main(String[] args) {
		StringBufferTest d = new StringBufferTest();
		d.display();
	}	
}
/*
	원하는 단을 입력 : 7 << 생성자
	---------------------
	7*1=7		<<display();
	7*2=14
	..
	7*9=63
*/