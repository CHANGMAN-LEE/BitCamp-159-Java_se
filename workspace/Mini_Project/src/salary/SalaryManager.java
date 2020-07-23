package salary;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class SalaryManager {
	private List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
	private EmployeeDTO dto;
	Scanner scan = new Scanner(System.in);

	public void insert() {//���
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���� �Է� : ");
		String position = scan.next();
		System.out.print("�⺻�� �Է� : ");
		int basicPay = scan.nextInt();
		System.out.print("���� �Է� : ");
		int extraPay = scan.nextInt();
		System.out.println();

		dto = new EmployeeDTO();
		dto.setData(name, position, basicPay, extraPay);
		dto.taxRate();
		dto.salary();

		list.add(dto);
	}// insert()

	public void print() {//���
		System.out.println("�̸�\t����\t�⺻��\t����\t����\t����");
		for (EmployeeDTO dto : list) {
			System.out.println(dto.getName() + "\t" + dto.getPosition() + "\t" + dto.getBasicPay() + "\t" + dto.getExtraPay() + "\t" + dto.getTaxRate() + "\t" + dto.getSalary());
		}
		System.out.println();
	}//print

	public void update() {// Ư�� ������...
		System.out.print("�����Ͻ� ������ �̸��� �Է��ϼ���. : ");
		String name = scan.next();
		for (EmployeeDTO dto : list) {
			if (dto.getName().equals(name)) {
				System.out.print("���� �Է� : ");
				String position = scan.next();
				System.out.print("�⺻�� �Է� : ");
				int basicPay = scan.nextInt();
				System.out.print("���� �Է� : ");
				int extraPay = scan.nextInt();
				dto.setData(name, position, basicPay, extraPay);
				dto.taxRate();
				dto.salary();
				System.out.println("������ �Ϸ�Ǿ����ϴ�. ");
				break;
			}
		}//for
		System.out.println();
	}//update

	public void serch() {// �̸��� �˻�
		System.out.print("�˻��Ͻ� ������ �̸��� �Է��ϼ���. : ");
		String name = scan.next();
		for (EmployeeDTO dto : list) {
			if(dto.getName().equals(name)) {
				System.out.println("�̸�\t����\t�⺻��\t����\t����\t����");
				System.out.println(dto.getName() + "\t" + dto.getPosition() + "\t" + dto.getBasicPay() + "\t" + dto.getExtraPay() + "\t" + dto.getTaxRate() + "\t" + dto.getSalary());
				break;
			}
		}
	}//serch
}