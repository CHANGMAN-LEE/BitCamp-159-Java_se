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

	// 메뉴
	private void menu() {
		System.out.println("*************");
		System.out.println("  1. 가입");
		System.out.println("  2. 출력");
		System.out.println("  3. 수정");
		System.out.println("  4. 탈퇴");
		System.out.println("  5. 끝내기");
		System.out.println("*************");
		System.out.print("  번호 : ");
	}// menu()

	// 가입
	private void insert() {
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				continue;
			} else {
				System.out.print("이름 입력 : ");
				String name = scanner.next();
				System.out.print("나이 입력 : ");
				int age = scanner.nextInt();
				System.out.print("핸드폰 입력 : ");
				String phone = scanner.next();
				System.out.print("주소 입력 : ");
				String address = scanner.next();

				ar[i] = new MemberDTO();
				ar[i].setData(name, age, phone, address);
				System.out.println("\n1 row created");
				count++;
				System.out.println((ar.length - count) + "자리 남았습니다.");
				break;
			} // if & else
		} // for() i
		System.out.println();
	}// insert()

	// 출력
	private void list() {
		System.out.println("이름\t\t나이\t번호\t\t주소");
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

	// 수정
	private void update() {
		System.out.print("수정하실 핸드폰 번호를 입력하세요 : ");
		String phone = scanner.next();
		for (int i = 0; i < ar.length; i++) {
			if (ar[i].getPhone().equals(phone)) {
				System.out.print("이름 입력 : ");
				String name = scanner.next();
				System.out.print("나이 입력 : ");
				int age = scanner.nextInt();
				System.out.print("핸드폰 입력 : ");
				phone = scanner.next();
				scanner.nextLine();
				System.out.print("주소 입력 : ");
				String address = scanner.nextLine();
				ar[i].setData(name, age, phone, address);
				System.out.println("수정이 완료되었습니다. ");
				break;
			} // if
		} // for i
		System.out.println();
	}// update()

	// 탈퇴
	private void delete() {
		System.out.print("탈퇴하실 핸드폰 번호를 입력하세요 : ");
		String phone = scanner.next();
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == null) {
				continue;
			}
			if (ar[i].getPhone().equals(phone)) {
				System.out.println((i + 1) + "번째에 있는 회원이 탈퇴되었습니다.");
				count--;
				ar[i] = null;
				break;
			} //else {
				//System.out.println("등록되어 있지 않는 핸드폰 번호입니다.");
				//break;
			//}

		} // for i
	}// delete()

	// 끝내기
	private void exit() {
		System.out.println("\n이용해 주셔서 감사합니다.");
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
