import java.util.Scanner;

class StringMain2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int countNum = 0;
		System.out.print("���ڿ� �Է� : ");
		String str = scanner.next();
		System.out.print("���� ���ڿ� �Է� : ");
		String str1 = scanner.next();
		System.out.print("�ٲ� ���ڿ� �Է� : ");
		String str2 = scanner.next();

		if(str.length() < str1.length()){
			System.out.println("�Է��� ���ڿ��� �ٲ� ���ڿ��� ũ�Ⱑ �ٸ��ϴ�.");
		}else{
			String str3 = str.toLowerCase();			//str�� �ҹ��ڷ� ��ȯ
			String str4 = str3.replace(str1, str2);		//�ҹ��ڷ� ��ȯ�� str3�� �ִ� aa�� dd�� ġȯ
			for(int i=0; i<str.length(); i+=countNum){
				if(str3.indexOf(str1, i) != i){			//�ҹ��ڷ� ��ȯ�� str3�� �ִ� aa�� index ��!!
					countNum = 1;
				}else{
					//System.out.println(str3.indexOf(str1, i));
					count++;
					countNum = str1.length();
				}
			}
			System.out.println(str + " --> " + str4);
			System.out.println(str1 + "��(��) " + str2 + "�� " + count + "�� ġȯ!!");
		}
	}
}
/*
	ġȯ ���α׷� �����
	[������]
	���ڿ� �Է� : aabba
	���� ���ڿ� �Է� : aa
	�ٲ� ���ڿ� �Է� : dd
	ddbba
	1�� ġȯ

	���ڿ� �Է� : aAbbA
	���� ���ڿ� �Է� : aa
	�ٲ� ���ڿ� �Է� : dd
	ddbba
	1�� ġȯ
	�빮�ڸ� �ҹ��ڷ� �ٲ��ְ�!! aa�Է½� dd�� ġȯ

	���ڿ� �Է� : aabbaa
	���� ���ڿ� �Է� : aa
	�ٲ� ���ڿ� �Է� : dd
	ddbbdd
	2�� ġȯ
	
	���ڿ� �Է� : AAccaabbaaaaatt
	���� ���ڿ� �Է� : aa
	�ٲ� ���ڿ� �Է� : dd
	ddccddbbddddatt
	4�� ġȯ
	�빮�ڸ� �ҹ��ڷ� �ٲ��ְ�!! aa�Է½� dd�� ġȯ

	���ڿ� �Է� : aabb
	���� ���ڿ� �Է� : aaaaa
	�ٲ� ���ڿ� �Է� : ddddd
	�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�.
	if���� ����ؼ� �Է��� ���ڿ��� �ٲ��� ���ڿ� ũ�⺸�� ������!!

	indexOf(?, ?)<<��� ã�ƾ���..
*/