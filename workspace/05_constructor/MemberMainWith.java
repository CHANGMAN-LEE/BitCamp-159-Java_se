import java.util.Scanner;

class MemberMainWith {
	Scanner scanner = new Scanner(System.in);
	MemberDTOWith[] ar = new MemberDTOWith[5];

	public void menu(){
		while(true){
			System.out.println();
			System.out.println("*************");
			System.out.println("  1. 가입");
			System.out.println("  2. 출력");
			System.out.println("  3. 수정");
			System.out.println("  4. 탈퇴");
			System.out.println("  5. 끝내기");
			System.out.println("*************");
			System.out.print("  번호 : ");
			int choice = scanner.nextInt();			
			if (choice == 5) break;
			if (choice == 1) this.insert();
			else if (choice == 2) this.list();
			else if (choice == 3) this.update();
			else if (choice == 4) this.delete();
			else System.out.println("\n1~5번 숫자만 입력하세요.");
		}
	}

	public void insert(){
		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] == null) break;
		}//for i
		if (i == ar.length) {
			System.out.println("5명의 정원이 꽉 찼습니다.");
			return;	//메소드를 벗어나라는 함수!!
		}
		ar[i] = new MemberDTOWith();
		System.out.print("이름 입력 : ");
		ar[i].setName(scanner.next());
		System.out.print("나이 입력 : ");
		ar[i].setAge(scanner.nextInt());
		System.out.print("핸드폰 입력 : ");
		ar[i].setPhone(scanner.next());
		System.out.print("주소 입력 : ");
		ar[i].setAddress(scanner.next());
		int count = 0;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] == null) count++;
		}//for i
		System.out.println(count + "자리 남았습니다.");
	}

	private void list(){
		System.out.println();
		System.out.println("이름\t\t나이\t번호\t\t주소");
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
		System.out.print("핸드폰 번호를 입력 : ");
		String phone = scanner.next();
		for (i = 0; i < ar.length; i++){
			if (ar[i] != null){
				if (ar[i].getPhone().equals(phone)){
					System.out.println("\n이름\t\t나이\t번호\t\t주소");
					System.out.println(ar[i].getName() + "\t\t" + ar[i].getAge()
									+ "\t" + ar[i].getPhone() + "\t" + ar[i].getAddress());
					System.out.print("수정할 이름 입력 : ");
					ar[i].setName(scanner.next());
					System.out.print("수정할 나이 입력 : ");
					ar[i].setAge(scanner.nextInt());
					System.out.print("수정할 핸드폰 입력 : ");
					ar[i].setPhone(scanner.next());
					System.out.println("수정 완료");
					break;
				}
			}
		}//for i
		if(i == ar.length){
			System.out.println("찾는 회원이 없습니다.");
		}
	}

	private void delete(){
		int i;
		System.out.println();
		System.out.print("핸드폰 번호를 입력 : ");
		String phone = scanner.next();
		for (i = 0; i < ar.length; i++){
			if (ar[i] != null){
				if (ar[i].getPhone().equals(phone)){
					ar[i] = null;
					System.out.println("탈퇴 완료");
					break;
				}
			}
		}//for i
		if(i == ar.length){
			System.out.println("찾는 회원이 없습니다.");
		}
	}

	public static void main(String[] args) {
		MemberMainWith main = new MemberMainWith();
		main.menu();
		System.out.println("\n프로그램을 종료합니다.");
	}

}
