import java.util.Scanner;

class StringMain2With {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int index = 0;
		System.out.print("문자열 입력 : ");
		String str = scanner.next();
		System.out.print("현재 문자열 입력 : ");
		String find = scanner.next();
		System.out.print("바꿀 문자열 입력 : ");
		String change = scanner.next();

		if(str.length() < find.length()){
			System.out.println("입력한 문자열과 바꿀 문자열의 크기가 다릅니다.");
		}else{
			str = str.toLowerCase();
			find = find.toLowerCase();
			while((index=str.indexOf(find, index)) != -1){
				index += find.length();
				count++;
			}
		}
			System.out.println(str.replace(find, change));
			System.out.println(count + "번 치환!!");
	
	}
}