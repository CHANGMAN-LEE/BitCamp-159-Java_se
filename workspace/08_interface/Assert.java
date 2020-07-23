import java.util.Scanner;

class Assert{
	private int x, y;

	public void input(){
		//x와 y의 값을 입력
		Scanner scanner = new Scanner(System.in);
		x = scanner.nextInt();
		y = scanner.nextInt();
	}

	public void output(){
		//for문을 이용하여 x의 y승을 계산!!
		assert y>=0 : "y는 0보다 크거나 같아야한다.";
		int temp = 1;
		for(int i=0; i<y; i++){
			temp = temp*x;
		}
		System.out.println(temp);
	}

	public static void main(String[] args){
		Assert as = new Assert();
		as.input();
		as.output();
	}
}