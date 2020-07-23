import java.util.Scanner;

class ExceptionTest{
	public static void main(String[] args){
		if(args.length > 0) System.out.println("args[0] = " + args[0]);
		System.out.println();

		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num2 = scan.nextInt();

		try{
			int num = Integer.parseInt(args[0]);
			System.out.println(num + "/" + num2 + "=" + (num/num2));
			//System.out.println(num + "/" + num2 + "=" + ((double)num/num2)); Inpinity
		}catch(NumberFormatException e){
			System.out.println("숫자만 입력하세요!!");
		}catch(ArithmeticException e){
			System.out.println("0이 아닌 숫자를 입력하세요!!");
		}finally{
			System.out.println("Error가 있든 없든 무조건 실행!!");
		}
	}
}