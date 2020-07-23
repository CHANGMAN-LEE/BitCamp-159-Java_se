import java.util.Scanner;

class EmployeeMain2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		EmployeeDTO[] dto = new EmployeeDTO[2];
		int i;

		for(i = 0; i < dto.length; i++){
			dto[i] = new EmployeeDTO();

			System.out.print("이름 입력 : ");
			String name = scanner.next();
			System.out.print("직급 입력 : ");
			String position = scanner.next();
			System.out.print("기본급 입력 : ");
			int basicPay = scanner.nextInt();
			System.out.print("수당 입력 : ");
			int extraPay = scanner.nextInt();
			System.out.println();
			
			dto[i].setData(name, position, basicPay, extraPay);
			dto[i].taxRate();
			dto[i].salary();
		}

		
		/*for(i = 0; i < dto.length; i++){
			System.out.println(dto[i].getName() + "  " + dto[i].getPosition() + "  " + dto[i].getBasicPay() + "  " + dto[i].getExtraPay() + "  " + dto[i].getTaxRate() + "  " + dto[i].getSalary());
		}*/
		for(EmployeeDTO data : dto){
			System.out.println(data.getName() + "  " + data.getPosition() + "  " + data.getBasicPay() + "  " + data.getExtraPay() + "  " + data.getTaxRate() + "  " + data.getSalary());
		}

		scanner.close();
	}
}
