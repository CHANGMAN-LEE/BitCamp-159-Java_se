import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class PersonSort{
	public static void main(String[] args){
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
		System.out.print("정렬 전 = ");
		for(String data : ar){
			System.out.print(data + "  ");
		}
		System.out.println();

		Arrays.sort(ar);
		System.out.print("정렬 후 = ");
		for(String data : ar){
			System.out.print(data + "  ");
		}
		System.out.println();

		System.out.println("\nPersonDTO를 나이 순으로 정렬");
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("또치", 40);
		PersonDTO cc = new PersonDTO("도우너", 30);
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		System.out.println("정렬 전 = " + list);
		Collections.sort(list);
		System.out.println("정렬 후 = " + list);
		System.out.println();

		System.out.println("\nPersonDTO를 이름 순으로 정렬");
		Comparator<PersonDTO> com = new Comparator<PersonDTO>(){
			@Override
			public int compare(PersonDTO o1, PersonDTO o2){
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(list, com);	//기준점이 바뀌었다는 것을 알려주기 위해 뒤에 com을 써준다.
		System.out.println("오름차순 정렬 후 = " + list);

		Comparator<PersonDTO> com2 = new Comparator<PersonDTO>(){
			@Override
			public int compare(PersonDTO o1, PersonDTO o2){
				return o1.getName().compareTo(o2.getName()) * -1;
			}
		};
		Collections.sort(list, com2);	//기준점이 바뀌었다는 것을 알려주기 위해 뒤에 com을 써준다.
		System.out.println("내림차순 정렬 후 = " + list);
	}	
}
