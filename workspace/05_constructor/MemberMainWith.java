import java.util.Scanner;

class MemberMainWith {
	Scanner scanner = new Scanner(System.in);
	MemberDTOWith[] ar = new MemberDTOWith[5];

	public void menu(){
		while(true){
			System.out.println();
			System.out.println("*************");
			System.out.println("  1. ����");
			System.out.println("  2. ���");
			System.out.println("  3. ����");
			System.out.println("  4. Ż��");
			System.out.println("  5. ������");
			System.out.println("*************");
			System.out.print("  ��ȣ : ");
			int choice = scanner.nextInt();			
			if (choice == 5) break;
			if (choice == 1) this.insert();
			else if (choice == 2) this.list();
			else if (choice == 3) this.update();
			else if (choice == 4) this.delete();
			else System.out.println("\n1~5�� ���ڸ� �Է��ϼ���.");
		}
	}

	public void insert(){
		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] == null) break;
		}//for i
		if (i == ar.length) {
			System.out.println("5���� ������ �� á���ϴ�.");
			return;	//�޼ҵ带 ������ �Լ�!!
		}
		ar[i] = new MemberDTOWith();
		System.out.print("�̸� �Է� : ");
		ar[i].setName(scanner.next());
		System.out.print("���� �Է� : ");
		ar[i].setAge(scanner.nextInt());
		System.out.print("�ڵ��� �Է� : ");
		ar[i].setPhone(scanner.next());
		System.out.print("�ּ� �Է� : ");
		ar[i].setAddress(scanner.next());
		int count = 0;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] == null) count++;
		}//for i
		System.out.println(count + "�ڸ� ���ҽ��ϴ�.");
	}

	private void list(){
		System.out.println();
		System.out.println("�̸�\t\t����\t��ȣ\t\t�ּ�");
		for (MemberDTOWith data : ar) {
			if (data != null) {
				System.out.println(data.getName() + "\t\t" + data.getAge()
									+ "\t" + data.getPhone() + "\t" + data.getAddress());
			} 
		}//for i
	}

	private void update(){
		int i;
		System.out.println();
		System.out.print("�ڵ��� ��ȣ�� �Է� : ");
		String phone = scanner.next();
		for (i = 0; i < ar.length; i++){
			if (ar[i] != null){
				if (ar[i].getPhone().equals(phone)){
					System.out.println("\n�̸�\t\t����\t��ȣ\t\t�ּ�");
					System.out.println(ar[i].getName() + "\t\t" + ar[i].getAge()
									+ "\t" + ar[i].getPhone() + "\t" + ar[i].getAddress());
					System.out.print("������ �̸� �Է� : ");
					ar[i].setName(scanner.next());
					System.out.print("������ ���� �Է� : ");
					ar[i].setAge(scanner.nextInt());
					System.out.print("������ �ڵ��� �Է� : ");
					ar[i].setPhone(scanner.next());
					System.out.println("���� �Ϸ�");
					break;
				}
			}
		}//for i
		if(i == ar.length){
			System.out.println("ã�� ȸ���� �����ϴ�.");
		}
	}

	private void delete(){
		int i;
		System.out.println();
		System.out.print("�ڵ��� ��ȣ�� �Է� : ");
		String phone = scanner.next();
		for (i = 0; i < ar.length; i++){
			if (ar[i] != null){
				if (ar[i].getPhone().equals(phone)){
					ar[i] = null;
					System.out.println("Ż�� �Ϸ�");
					break;
				}
			}
		}//for i
		if(i == ar.length){
			System.out.println("ã�� ȸ���� �����ϴ�.");
		}
	}

	public static void main(String[] args) {
		MemberMainWith main = new MemberMainWith();
		main.menu();
		System.out.println("\n���α׷��� �����մϴ�.");
	}

}
