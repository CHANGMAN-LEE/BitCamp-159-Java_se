import java.util.Scanner;

class ShapeTest{
	Scanner scanner = new Scanner(System.in);
	protected double area;

	public ShapeTest(){
		System.out.println("ShapeTest 기본생성자");
	}
	public void calcArea(){
		System.out.println("도형을 계산합니다.");
	}
	public void dispArea(){
		System.out.println("도형을 출력합니다.");
	}
	
}
//---------------------------------------
class SamTest extends ShapeTest {
	protected int base, height;

	public SamTest(){
		System.out.println("SamTest 기본생성자");
		System.out.print("밑변 : ");
		base = scanner.nextInt();
		System.out.print("높이 : ");
		height = scanner.nextInt();
	}

	@Override
	public void calcArea(){
		area = base * height / 2.0;
	}
	public void dispArea(){
		System.out.println("삼각형 넓이 = " + area);
	}
}
//---------------------------------------
class SaTest extends ShapeTest{
	protected int width, height;

	public SaTest(){
		System.out.println("SaTest 기본생성자");
		System.out.print("가로 : ");
		width = scanner.nextInt();
		System.out.print("높이 : ");
		height = scanner.nextInt();
	}

	@Override
	public void calcArea(){
		area = width * height;
	}
	public void dispArea(){
		System.out.println("사각형 넓이 = " + area);
	}
}
//---------------------------------------
class SadariTest extends ShapeTest{
	protected int top, bottom, height;

	public SadariTest(){
		System.out.println("SadariTest 기본생성자");
		System.out.print("윗변 : ");
		top = scanner.nextInt();
		System.out.print("밑변 : ");
		bottom = scanner.nextInt();
		System.out.print("높이 : ");
		height = scanner.nextInt();
	}

	@Override
	public void calcArea(){
		area = (top + bottom) * height / 2.0;
	}
	public void dispArea(){
		System.out.println("사다리꼴 넓이 = " + area);
	}
}
//---------------------------------------
class ShapeMain {
	public static void main(String[] args) {
		/*SamTest sam = new SamTest();		// 1:1관계, 결합도 100%
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
		shape = new SamTest();			// 부모 = 자식, (다형성)
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SaTest();			// 부모 = 자식, (다형성)
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SadariTest();		// 부모 = 자식, (다형성)
		shape.calcArea();
		shape.dispArea();
		System.out.println();
	}
}
