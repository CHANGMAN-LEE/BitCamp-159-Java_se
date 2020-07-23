class PersonDTO implements Comparable<PersonDTO>{
	private String name;
	private int age;

	public PersonDTO(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	@Override
	public String toString(){
		return "이름 = " + name + " 나이 = " + age;	
	}
	
	@Override
	public int compareTo(PersonDTO o){
		if(this.age < o.age) return -1;
		else if(this.age == o.age) return 0;
		else return 1;
		//=> return this.age < o.age ? -1: 1; - 오름차순
		//=> return this.age < o.age ? 1: -1; - 내림차순
	}
}