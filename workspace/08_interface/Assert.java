import java.util.Scanner;

class Assert{
	private int x, y;

	public void input(){
		//x�� y�� ���� �Է�
		Scanner scanner = new Scanner(System.in);
		x = scanner.nextInt();
		y = scanner.nextInt();
	}

	public void output(){
		//for���� �̿��Ͽ� x�� y���� ���!!
		assert y>=0 : "y�� 0���� ũ�ų� ���ƾ��Ѵ�.";
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