abstract class AbstractTest {	//POJO����(Plain Old Java Object) -> �ٸ� ���ѵ� ��ӹ��� �ʰ� �Ϲ����� Ŭ����!!
	protected String name;	//public���� ���� �ȴ�~

	public abstract void setName(String name);	//�߻�޼ҵ�
	
	public String getName(){			//������
		return this.name;
	}
}
