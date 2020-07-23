import java.util.Scanner;

class ExaminationMain{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ο��� �Է� : ");
		int size = scanner.nextInt();
		ExaminationDTO[] ar = new ExaminationDTO[size];
		System.out.println();

		for(int i=0; i<ar.length; i++){
			ar[i] = new ExaminationDTO();
			ar[i].compare();
			System.out.println();
		}//for i

		System.out.println("\n�̸�\t1 2 3 4 5\t����");
		for(int i=0; i<ar.length; i++){
			System.out.print(ar[i].getName() + "\t");
			for(int j=0; j<5; j++){
				 System.out.print(ar[i].getOx()[j] + " ");
			}//for j
			System.out.println(String.format("%9s", ar[i].getScore()) + "��");
		}//for i
	}//main
}

class ExaminationDTO{
	private String name;
	private String dap;
	private char[] ox;
	private int score;
	private static final String JUNG="11111";

	public ExaminationDTO(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ��� : ");
		name = scanner.next();
		System.out.print("������� �Է��ϼ��� : ");
		dap = scanner.next();
	}

	public void compare(){
		this.ox = new char[5];
		int count = 0;
		int i;
		for(i=0; i<5; i++){
			char[] answer = dap.toCharArray();
			if(answer[i] == JUNG.charAt(i)){
				this.ox[i] = 'O';
				count++;
			}else{
				this.ox[i] = 'X';
			}
		}
		this.score = (100/(i))*count;
	}

	public String getName(){
		return name;
	}

	public char[] getOx(){
		return ox;
	}

	public int getScore(){
		return score;
	}
}