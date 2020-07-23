import java.util.Scanner;
import java.io.*;

class Ex {
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello World!");

		System.out.print("숫자입력 : ");
		int aa = scanner.nextInt();

		//scanner.nextLine();
		//scanner.nextLine();

		System.in.read();

		System.out.println("끝!!");

		scanner.close();
	}
}
