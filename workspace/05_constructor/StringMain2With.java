import java.util.Scanner;

class StringMain2With {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int index = 0;
		System.out.print("���ڿ� �Է� : ");
		String str = scanner.next();
		System.out.print("���� ���ڿ� �Է� : ");
		String find = scanner.next();
		System.out.print("�ٲ� ���ڿ� �Է� : ");
		String change = scanner.next();

		if(str.length() < find.length()){
			System.out.println("�Է��� ���ڿ��� �ٲ� ���ڿ��� ũ�Ⱑ �ٸ��ϴ�.");
		}else{
			str = str.toLowerCase();
			find = find.toLowerCase();
			while((index=str.indexOf(find, index)) != -1){
				index += find.length();
				count++;
			}
		}
			System.out.println(str.replace(find, change));
			System.out.println(count + "�� ġȯ!!");
	
	}
}