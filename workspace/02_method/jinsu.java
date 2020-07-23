//10진수를 입력 받아서 2진수, 8진수, 16진수로 출력
//단, Integer에 변환시켜주는 method를 찾으시오.

//[실행결과]
//10진수 입력 : 250
//2진수 = toBinaryString
//8진수 = toOctalString
//16진수 = 	toHexString

import java.util.Scanner;

class jinsu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		
		System.out.print("변환할 숫자를 입력하세요 : ");
		int num = scanner.nextInt();

		String binary = Integer.toBinaryString(num);
		String oct = Integer.toOctalString(num);
		String hexa = Integer.toHexString(num);

		System.out.println("10진수 = "+num);
		System.out.println(" 2진수 = "+binary);
		System.out.println(" 8진수 = "+oct);
		System.out.println("16진수 = "+hexa);

		scanner.close();
	}

}
