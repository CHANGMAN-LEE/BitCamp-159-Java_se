class PersonTest{
	//사람 - 가상화
	//이름, 나이, 성별, 키 등등....
	private String name; //<<필드, 초기화, null
	private int age; //<<필드, 초기화, 0

	//이름, 나이을 받는 메소드를 구현한다!!
	public void setName(String n){ //구현
		name = n;
	}
	public void setAge(int a){ //구현
		age = a;
	}

	//이름, 나이 값을 반환!!
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}

	//이름과 나이 한번에 있는데 데이터 메소드
	public void setData(String n, int a){
		name = n;
		age = a;
	}
	//Over load << 사람으로 표현하면 쌍둥이..!!, 생긴건 같지만 독립적이다.
	public void setData(){ }
}

public class PersonMain{
	public static void main(String[] agrs){
		PersonTest aa = new PersonTest(); // 객체
		aa.setName("홍길동"); //호출
		aa.setAge(25); //호출
		System.out.println("이름 = " + aa.getName());
		System.out.println("나이 = " + aa.getAge());
		
		System.out.println();
		PersonTest bb = new PersonTest();
		bb.setName("코난");
		bb.setAge(13);
		System.out.println("이름 = " + bb.getName());
		System.out.println("나이 = " + bb.getAge());
		
		System.out.println();
		PersonTest cc = new PersonTest();
		cc.setData("또치", 100);
		System.out.println("이름 = " + cc.getName());
		System.out.println("나이 = " + cc.getAge());

		System.out.println();
		PersonTest dd = new PersonTest();
		dd.setData();
		System.out.println("이름 = " + dd.getName());
		System.out.println("나이 = " + dd.getAge());

	}
}