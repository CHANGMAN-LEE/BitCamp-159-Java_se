import java.util.ArrayList;

class PersonMain{
	public ArrayList<PersonDTO> init(){
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("또치", 40);
		PersonDTO cc = new PersonDTO("도우너", 30);

		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();

		list.add(aa);
		list.add(bb);
		list.add(cc);

		return list;
	}

	public static void main(String[] args){
		PersonMain main = new PersonMain();
		ArrayList<PersonDTO> list = main.init();

		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}

		System.out.println("--------------------");

		for(PersonDTO dto : list){
			System.out.println(dto);
		}

	}
}
