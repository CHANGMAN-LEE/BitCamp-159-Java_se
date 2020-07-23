import java.util.Scanner;

class EmployeeMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		EmployeeDTO dto = new EmployeeDTO();

		System.out.print("이름 입력 : ");
		String name = scanner.nextLine();
		System.out.print("직급 입력 : ");
		String position = scanner.nextLine();
		System.out.print("기본급 입력 : ");
		int basicPay = scanner.nextInt();
		System.out.print("수당 입력 : ");
		int extraPay = scanner.nextInt();

		dto.setData(name, position, basicPay, extraPay);
		dto.taxRate();
		dto.salary();

		System.out.println(dto.getName() + "  " + dto.getPosition() + "  " + dto.getBasicPay() + "  " + dto.getExtraPay() + "  " + dto.getTaxRate() + "  " + dto.getSalary());

		scanner.close();
	}
}
