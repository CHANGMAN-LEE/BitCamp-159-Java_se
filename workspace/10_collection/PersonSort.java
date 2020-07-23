import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class PersonSort{
	public static void main(String[] args){
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
		System.out.print("���� �� = ");
		for(String data : ar){
			System.out.print(data + "  ");
		}
		System.out.println();

		Arrays.sort(ar);
		System.out.print("���� �� = ");
		for(String data : ar){
			System.out.print(data + "  ");
		}
		System.out.println();

		System.out.println("\nPersonDTO�� ���� ������ ����");
		PersonDTO aa = new PersonDTO("ȫ�浿", 25);
		PersonDTO bb = new PersonDTO("��ġ", 40);
		PersonDTO cc = new PersonDTO("�����", 30);
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		System.out.println("���� �� = " + list);
		Collections.sort(list);
		System.out.println("���� �� = " + list);
		System.out.println();

		System.out.println("\nPersonDTO�� �̸� ������ ����");
		Comparator<PersonDTO> com = new Comparator<PersonDTO>(){
			@Override
			public int compare(PersonDTO o1, PersonDTO o2){
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(list, com);	//�������� �ٲ���ٴ� ���� �˷��ֱ� ���� �ڿ� com�� ���ش�.
		System.out.println("�������� ���� �� = " + list);

		Comparator<PersonDTO> com2 = new Comparator<PersonDTO>(){
			@Override
			public int compare(PersonDTO o1, PersonDTO o2){
				return o1.getName().compareTo(o2.getName()) * -1;
			}
		};
		Collections.sort(list, com2);	//�������� �ٲ���ٴ� ���� �˷��ֱ� ���� �ڿ� com�� ���ش�.
		System.out.println("�������� ���� �� = " + list);
	}	
}
