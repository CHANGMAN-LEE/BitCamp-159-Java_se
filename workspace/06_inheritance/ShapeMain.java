import java.util.Scanner;

class ShapeTest{
	Scanner scanner = new Scanner(System.in);
	protected double area;

	public ShapeTest(){
		System.out.println("ShapeTest �⺻������");
	}
	public void calcArea(){
		System.out.println("������ ����մϴ�.");
	}
	public void dispArea(){
		System.out.println("������ ����մϴ�.");
	}
	
}
//---------------------------------------
class SamTest extends ShapeTest {
	protected int base, height;

	public SamTest(){
		System.out.println("SamTest �⺻������");
		System.out.print("�غ� : ");
		base = scanner.nextInt();
		System.out.print("���� : ");
		height = scanner.nextInt();
	}

	@Override
	public void calcArea(){
		area = base * height / 2.0;
	}
	public void dispArea(){
		System.out.println("�ﰢ�� ���� = " + area);
	}
}
//---------------------------------------
class SaTest extends ShapeTest{
	protected int width, height;

	public SaTest(){
		System.out.println("SaTest �⺻������");
		System.out.print("���� : ");
		width = scanner.nextInt();
		System.out.print("���� : ");
		height = scanner.nextInt();
	}

	@Override
	public void calcArea(){
		area = width * height;
	}
	public void dispArea(){
		System.out.println("�簢�� ���� = " + area);
	}
}
//---------------------------------------
class SadariTest extends ShapeTest{
	protected int top, bottom, height;

	public SadariTest(){
		System.out.println("SadariTest �⺻������");
		System.out.print("���� : ");
		top = scanner.nextInt();
		System.out.print("�غ� : ");
		bottom = scanner.nextInt();
		System.out.print("���� : ");
		height = scanner.nextInt();
	}

	@Override
	public void calcArea(){
		area = (top + bottom) * height / 2.0;
	}
	public void dispArea(){
		System.out.println("��ٸ��� ���� = " + area);
	}
}
//---------------------------------------
class ShapeMain {
	public static void main(String[] args) {
		/*SamTest sam = new SamTest();		// 1:1����, ���յ� 100%
		sam.calcArea();
		sam.dispArea();
		System.out.println();

		SaTest sa = new SaTest();
		sa.calcArea();
		sa.dispArea();
		System.out.println();
		
		SadariTest sadan = new SadariTest();
		sadan.calcArea();
		sadan.dispArea();
		System.out.println();*/

		ShapeTest shape;
		shape = new SamTest();			// �θ� = �ڽ�, (������)
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SaTest();			// �θ� = �ڽ�, (������)
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SadariTest();		// �θ� = �ڽ�, (������)
		shape.calcArea();
		shape.dispArea();
		System.out.println();
	}
}
