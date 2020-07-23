import java.util.Scanner;

class StringMain2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int countNum = 0;
		System.out.print("문자열 입력 : ");
		String str = scanner.next();
		System.out.print("현재 문자열 입력 : ");
		String str1 = scanner.next();
		System.out.print("바꿀 문자열 입력 : ");
		String str2 = scanner.next();

		if(str.length() < str1.length()){
			System.out.println("입력한 문자열과 바꿀 문자열의 크기가 다릅니다.");
		}else{
			String str3 = str.toLowerCase();			//str을 소문자로 변환
			String str4 = str3.replace(str1, str2);		//소문자로 변환된 str3에 있는 aa를 dd로 치환
			for(int i=0; i<str.length(); i+=countNum){
				if(str3.indexOf(str1, i) != i){			//소문자로 변환된 str3에 있는 aa의 index 비교!!
					countNum = 1;
				}else{
					//System.out.println(str3.indexOf(str1, i));
					count++;
					countNum = str1.length();
				}
			}
			System.out.println(str + " --> " + str4);
			System.out.println(str1 + "을(를) " + str2 + "로 " + count + "번 치환!!");
		}
	}
}
/*
	치환 프로그램 만들기
	[실행결과]
	문자열 입력 : aabba
	현재 문자열 입력 : aa
	바꿀 문자열 입력 : dd
	ddbba
	1번 치환

	문자열 입력 : aAbbA
	현재 문자열 입력 : aa
	바꿀 문자열 입력 : dd
	ddbba
	1번 치환
	대문자를 소문자로 바꿔주고!! aa입력시 dd로 치환

	문자열 입력 : aabbaa
	현재 문자열 입력 : aa
	바꿀 문자열 입력 : dd
	ddbbdd
	2번 치환
	
	문자열 입력 : AAccaabbaaaaatt
	현재 문자열 입력 : aa
	바꿀 문자열 입력 : dd
	ddccddbbddddatt
	4개 치환
	대문자를 소문자로 바꿔주고!! aa입력시 dd로 치환

	문자열 입력 : aabb
	현재 문자열 입력 : aaaaa
	바꿀 문자열 입력 : ddddd
	입력한 문자열의 크기가 작습니다.
	if문을 사용해서 입력한 문자열이 바꿔줄 문자열 크기보다 작으면!!

	indexOf(?, ?)<<요거 찾아야해..
*/