import java.io.IOException;

class ExceptionTest2{
	private int dan;
	public void input() throws IOException{
		System.out.print("원하는 단을 입력 : ");
		dan = System.in.read() - '0';		//1개 문자!!
	}
	public void output(){
		if(dan > 1 && dan < 10){
			for(int i=1; i<=9; i++){
				System.out.println(dan + "*" + i + "= " + (dan*i));
			}
		}else{
			//System.out.println("숫자는 2~9까지 숫자만 입력해주세요.");
			//Exception 발생
			try{
				throw new MakeException("숫자는 2~9까지 숫자만 입력해주세요.");
			}catch(Exception e){
				e.printStackTrace();		//Error 출력 메세지!!
			}
		}
	}
	public static void main(String[] args) throws IOException{
		ExceptionTest2 et = new ExceptionTest2();
		et.input();
		et.output();
	}
}
