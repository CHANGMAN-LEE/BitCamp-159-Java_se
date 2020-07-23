import java.io.IOException;

class ExceptionTest2{
	private int dan;
	public void input() throws IOException{
		System.out.print("���ϴ� ���� �Է� : ");
		dan = System.in.read() - '0';		//1�� ����!!
	}
	public void output(){
		if(dan > 1 && dan < 10){
			for(int i=1; i<=9; i++){
				System.out.println(dan + "*" + i + "= " + (dan*i));
			}
		}else{
			//System.out.println("���ڴ� 2~9���� ���ڸ� �Է����ּ���.");
			//Exception �߻�
			try{
				throw new MakeException("���ڴ� 2~9���� ���ڸ� �Է����ּ���.");
			}catch(Exception e){
				e.printStackTrace();		//Error ��� �޼���!!
			}
		}
	}
	public static void main(String[] args) throws IOException{
		ExceptionTest2 et = new ExceptionTest2();
		et.input();
		et.output();
	}
}
