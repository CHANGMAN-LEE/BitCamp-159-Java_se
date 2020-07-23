import java.util.Random;

class MethodTest3 {

	public static void main(String[] args) {
		System.out.println("큰값 = " + Math.max(10,52));
		System.out.println("작은값 = " + Math.min(10,52));

		int power = (int)Math.pow(2,5);
		System.out.println("2의 5제곱 = " + power);
		
		int r1;
		r1 = (int)(Math.random()*100)+1;
		System.out.println("랜덤함수 = " + r1);
		
		Random r2 = new Random();
		int b;
		b = (int)(r2.nextDouble()*100);
		System.out.println("랜덤함수 = " + b);
	}

}
