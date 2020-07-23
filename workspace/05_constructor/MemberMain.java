import java.util.Scanner;

class MemberMain {
	Scanner scanner = new Scanner(System.in);
	MemberDTO[] ar = new MemberDTO[5];
	int count = 0;

	public static void main(String[] args) {

		MemberMain mm = new MemberMain();

		while (true) {
			mm.menu();
			int num = mm.scanner.nextInt();
			System.out.println("*************");
			if (num == 1) {
				mm.insert();
				// continue;
			} else if (num == 2) {
				mm.list();
			} else if (num == 3) {
				mm.update();
			} else if (num == 4) {
				mm.delete();
			} else if (num == 5) {
				mm.exit();
				break;
			}
		}

		mm.scanner.close();
	}

	// �޴�
	private void menu() {
		System.out.println("*************");
		System.out.println("  1. ����");
		System.out.println("  2. ���");
		System.out.println("  3. ����");
		System.out.println("  4. Ż��");
		System.out.println("  5. ������");
		System.out.println("*************");
		System.out.print("  ��ȣ : ");
	}// menu()

	// ����
	private void insert() {
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				continue;
			} else {
				System.out.print("�̸� �Է� : ");
				String name = scanner.next();
				System.out.print("���� �Է� : ");
				int age = scanner.nextInt();
				System.out.print("�ڵ��� �Է� : ");
				String phone = scanner.next();
				System.out.print("�ּ� �Է� : ");
				String address = scanner.next();

				ar[i] = new MemberDTO();
				ar[i].setData(name, age, phone, address);
				System.out.println("\n1 row created");
				count++;
				System.out.println((ar.length - count) + "�ڸ� ���ҽ��ϴ�.");
				break;
			} // if & else
		} // for() i
		System.out.println();
	}// insert()

	// ���
	private void list() {
		System.out.println("�̸�\t\t����\t��ȣ\t\t�ּ�");
		for (int i = 0; i < ar.length; i++) {
			// ar[i] = new MemberDTO();
			// ar[i].setData(name, age, phone, address);
			if (ar[i] == null) {
				// break;
			} else {
				System.out.println(ar[i].getName() + "\t\t" + ar[i].getAge()
									+ "\t" + ar[i].getPhone() + "\t" + ar[i].getAddress());
			} // if & else
		} // for i
	}// list()

	// ����
	private void update() {
		System.out.print("�����Ͻ� �ڵ��� ��ȣ�� �Է��ϼ��� : ");
		String phone = scanner.next();
		for (int i = 0; i < ar.length; i++) {
			if (ar[i].getPhone().equals(phone)) {
				System.out.print("�̸� �Է� : ");
				String name = scanner.next();
				System.out.print("���� �Է� : ");
				int age = scanner.nextInt();
				System.out.print("�ڵ��� �Է� : ");
				phone = scanner.next();
				scanner.nextLine();
				System.out.print("�ּ� �Է� : ");
				String address = scanner.nextLine();
				ar[i].setData(name, age, phone, address);
				System.out.println("������ �Ϸ�Ǿ����ϴ�. ");
				break;
			} // if
		} // for i
		System.out.println();
	}// update()

	// Ż��
	private void delete() {
		System.out.print("Ż���Ͻ� �ڵ��� ��ȣ�� �Է��ϼ��� : ");
		String phone = scanner.next();
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == null) {
				continue;
			}
			if (ar[i].getPhone().equals(phone)) {
				System.out.println((i + 1) + "��°�� �ִ� ȸ���� Ż��Ǿ����ϴ�.");
				count--;
				ar[i] = null;
				break;
			} //else {
				//System.out.println("��ϵǾ� ���� �ʴ� �ڵ��� ��ȣ�Դϴ�.");
				//break;
			//}

		} // for i
	}// delete()

	// ������
	private void exit() {
		System.out.println("\n�̿��� �ּż� �����մϴ�.");
	}// exit()
}

class MemberDTO {
	private String name;
	private int age;
	private String phone, address;

	public void setData(String name, int age, String phone, String address) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

}
