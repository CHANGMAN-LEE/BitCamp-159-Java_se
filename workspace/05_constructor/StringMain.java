class StringMain {
	public static void main(String[] args) {
		String aa= "apple";		//literal 생성
		String bb= "apple";
		if(aa == bb) System.out.println("a와 b의 참조값은 같다.");	//글씨를 보는게 아니라 주소값을 비교...!!
		else System.out.println("a와 b의 참조값은 다르다.");
		if(aa.equals(bb)) System.out.println("a와 b의 문자열은 같다.");	//문자열을 비교하기 위해서는 equals를 이용한다.
		else System.out.println("a와 b의 문자열은 다르다.");
		System.out.println();

		String cc = new String("apple");
		String dd = new String("apple");
		if(cc == dd) System.out.println("a와 b의 참조값은 같다.");
		else System.out.println("a와 b의 참조값은 다르다.");
		if(cc.equals(dd)) System.out.println("a와 b의 문자열은 같다.");
		else System.out.println("a와 b의 문자열은 다르다.");
		System.out.println();

		String ee = "오늘 오늘 날짜는 " + 2020 + "-" + 4 + "-" + 13 + "(Mon)";
		System.out.println(ee);
		System.out.println("문자열 크기 " + ee.length());
		System.out.println("문자 추출 " + ee.charAt(4));
		System.out.println("문자열 " + ee.substring(7));
		System.out.println("문자열 " + ee.substring(7, 11));
		
		System.out.println();
		System.out.println("대문자 변경 " + "Hello".toUpperCase());
		System.out.println("소문자 변경 " + "Hello".toLowerCase());
		
		System.out.println();
		System.out.println("문자열 검색 " + ee.indexOf("짜"));
		System.out.println("문자열 검색 " + ee.indexOf("날짜"));
		System.out.println("문자열 검색 " + ee.indexOf("개바부"));

		System.out.println();
		System.out.println("문자열 치환 = " + ee.replace("오늘", "현재"));
	}
}