abstract class AbstractTest {	//POJO형식(Plain Old Java Object) -> 다른 애한데 상속받지 않고 일반적인 클래스!!
	protected String name;	//public으로 열면 안대~

	public abstract void setName(String name);	//추상메소드
	
	public String getName(){			//구현부
		return this.name;
	}
}
