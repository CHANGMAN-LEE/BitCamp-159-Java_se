class AbstractMain extends AbstractTest {

	@Override
	public void setName(String name){
		this.name = name;
	}

	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest();	//X
		AbstractTest at = new AbstractMain();
		at.setName("��â��");
		at.getName();
		System.out.println(at.getName());
	}
}
