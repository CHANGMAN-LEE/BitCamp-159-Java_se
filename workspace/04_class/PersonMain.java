class PersonTest{
	//��� - ����ȭ
	//�̸�, ����, ����, Ű ���....
	private String name; //<<�ʵ�, �ʱ�ȭ, null
	private int age; //<<�ʵ�, �ʱ�ȭ, 0

	//�̸�, ������ �޴� �޼ҵ带 �����Ѵ�!!
	public void setName(String n){ //����
		name = n;
	}
	public void setAge(int a){ //����
		age = a;
	}

	//�̸�, ���� ���� ��ȯ!!
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}

	//�̸��� ���� �ѹ��� �ִµ� ������ �޼ҵ�
	public void setData(String n, int a){
		name = n;
		age = a;
	}
	//Over load << ������� ǥ���ϸ� �ֵ���..!!, ����� ������ �������̴�.
	public void setData(){ }
}

public class PersonMain{
	public static void main(String[] agrs){
		PersonTest aa = new PersonTest(); // ��ü
		aa.setName("ȫ�浿"); //ȣ��
		aa.setAge(25); //ȣ��
		System.out.println("�̸� = " + aa.getName());
		System.out.println("���� = " + aa.getAge());
		
		System.out.println();
		PersonTest bb = new PersonTest();
		bb.setName("�ڳ�");
		bb.setAge(13);
		System.out.println("�̸� = " + bb.getName());
		System.out.println("���� = " + bb.getAge());
		
		System.out.println();
		PersonTest cc = new PersonTest();
		cc.setData("��ġ", 100);
		System.out.println("�̸� = " + cc.getName());
		System.out.println("���� = " + cc.getAge());

		System.out.println();
		PersonTest dd = new PersonTest();
		dd.setData();
		System.out.println("�̸� = " + dd.getName());
		System.out.println("���� = " + dd.getAge());

	}
}