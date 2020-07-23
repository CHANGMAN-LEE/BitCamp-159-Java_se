import java.util.Scanner;

class EmployeeMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		EmployeeDTO dto = new EmployeeDTO();

		System.out.print("�̸� �Է� : ");
		String name = scanner.nextLine();
		System.out.print("���� �Է� : ");
		String position = scanner.nextLine();
		System.out.print("�⺻�� �Է� : ");
		int basicPay = scanner.nextInt();
		System.out.print("���� �Է� : ");
		int extraPay = scanner.nextInt();

		dto.setData(name, position, basicPay, extraPay);
		dto.taxRate();
		dto.salary();

		System.out.println(dto.getName() + "  " + dto.getPosition() + "  " + dto.getBasicPay() + "  " + dto.getExtraPay() + "  " + dto.getTaxRate() + "  " + dto.getSalary());

		scanner.close();
	}
}
