//10������ �Է� �޾Ƽ� 2����, 8����, 16������ ���
//��, Integer�� ��ȯ�����ִ� method�� ã���ÿ�.

//[������]
//10���� �Է� : 250
//2���� = toBinaryString
//8���� = toOctalString
//16���� = 	toHexString

import java.util.Scanner;

class jinsu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		
		System.out.print("��ȯ�� ���ڸ� �Է��ϼ��� : ");
		int num = scanner.nextInt();

		String binary = Integer.toBinaryString(num);
		String oct = Integer.toOctalString(num);
		String hexa = Integer.toHexString(num);

		System.out.println("10���� = "+num);
		System.out.println(" 2���� = "+binary);
		System.out.println(" 8���� = "+oct);
		System.out.println("16���� = "+hexa);

		scanner.close();
	}

}
