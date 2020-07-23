package salary;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class SalaryManager {
	private List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
	private EmployeeDTO dto;
	Scanner scan = new Scanner(System.in);

	public void insert() {//등록
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("직급 입력 : ");
		String position = scan.next();
		System.out.print("기본급 입력 : ");
		int basicPay = scan.nextInt();
		System.out.print("수당 입력 : ");
		int extraPay = scan.nextInt();
		System.out.println();

		dto = new EmployeeDTO();
		dto.setData(name, position, basicPay, extraPay);
		dto.taxRate();
		dto.salary();

		list.add(dto);
	}// insert()

	public void print() {//출력
		System.out.println("이름\t직급\t기본급\t수당\t세율\t월급");
		for (EmployeeDTO dto : list) {
			System.out.println(dto.getName() + "\t" + dto.getPosition() + "\t" + dto.getBasicPay() + "\t" + dto.getExtraPay() + "\t" + dto.getTaxRate() + "\t" + dto.getSalary());
		}
		System.out.println();
	}//print

	public void update() {// 특정 직원의...
		System.out.print("수정하실 직원의 이름을 입력하세요. : ");
		String name = scan.next();
		for (EmployeeDTO dto : list) {
			if (dto.getName().equals(name)) {
				System.out.print("직급 입력 : ");
				String position = scan.next();
				System.out.print("기본급 입력 : ");
				int basicPay = scan.nextInt();
				System.out.print("수당 입력 : ");
				int extraPay = scan.nextInt();
				dto.setData(name, position, basicPay, extraPay);
				dto.taxRate();
				dto.salary();
				System.out.println("수정이 완료되었습니다. ");
				break;
			}
		}//for
		System.out.println();
	}//update

	public void serch() {// 이름을 검색
		System.out.print("검색하실 직원의 이름을 입력하세요. : ");
		String name = scan.next();
		for (EmployeeDTO dto : list) {
			if(dto.getName().equals(name)) {
				System.out.println("이름\t직급\t기본급\t수당\t세율\t월급");
				System.out.println(dto.getName() + "\t" + dto.getPosition() + "\t" + dto.getBasicPay() + "\t" + dto.getExtraPay() + "\t" + dto.getTaxRate() + "\t" + dto.getSalary());
				break;
			}
		}
	}//serch
}