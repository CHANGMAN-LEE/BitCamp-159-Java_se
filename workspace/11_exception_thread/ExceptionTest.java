import java.util.Scanner;

class ExceptionTest{
	public static void main(String[] args){
		if(args.length > 0) System.out.println("args[0] = " + args[0]);
		System.out.println();

		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num2 = scan.nextInt();

		try{
			int num = Integer.parseInt(args[0]);
			System.out.println(num + "/" + num2 + "=" + (num/num2));
			//System.out.println(num + "/" + num2 + "=" + ((double)num/num2)); Inpinity
		}catch(NumberFormatException e){
			System.out.println("���ڸ� �Է��ϼ���!!");
		}catch(ArithmeticException e){
			System.out.println("0�� �ƴ� ���ڸ� �Է��ϼ���!!");
		}finally{
			System.out.println("Error�� �ֵ� ���� ������ ����!!");
		}
	}
}