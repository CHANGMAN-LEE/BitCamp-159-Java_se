package salary;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SalaryManager sm = new SalaryManager();
		int choice;
		
		while(true) {
			System.out.println("**********");
			System.out.println("  1.���");
			System.out.println("  2.���");
			System.out.println("  3.����");
			System.out.println("  4.�˻�");
			System.out.println("  5.����");
			System.out.println("**********");
			System.out.print("���Ͻô� �޴��� ��ȣ�� �Է��ϼ���. : ");
			choice = scan.nextInt();
			
			if(choice == 1) {
				sm.insert();
			}else if(choice == 2){
				sm.print();
			}else if(choice == 3){
				sm.update();
			}else if(choice == 4){
				sm.serch();
			}else if(choice == 5){
				break;
			}
			
		}
	}
}
