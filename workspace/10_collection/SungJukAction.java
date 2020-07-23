import java.util.*;

class SungJukAction{
	private ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();
	Scanner scanner = new Scanner(System.in);	

	public void menu(){
		//list =  new ArrayList<SungJukDTO>();
		while(true){
			System.out.println("***************");
			System.out.println("    1. �Է�");
			System.out.println("    2. ���");
			System.out.println("    3. �˻�");
			System.out.println("    4. ����");
			System.out.println("    5. ����");
			System.out.println("    6. ��");
			System.out.println("***************");
			System.out.print("�޴� ��ȣ �Է� : ");
			int choice = scanner.nextInt();
			if(choice == 1){
				insertArticle();
			}else if(choice == 2){
				printArticle();
			}else if(choice == 3){
				searchArticle();
			}else if(choice == 4){
				deleteArticle();
			}else if(choice == 5){
				sortArticle();
			}else if(choice == 6){
				System.out.println("�̿��� �ּż� �����մϴ�.");
				break;
			}
		}
	}//menu()
	public void insertArticle(){
		System.out.print("��ȣ �Է� : ");
		int no = scanner.nextInt();
		/*for(SungJukDTO dto : list){
			if(no == dto.getNo()){
				System.out.println("�ߺ��� ��ȣ�Դϴ�.");
				return;
			}
		}*/
		System.out.print("�̸� �Է� : ");
		String name = scanner.next();
		System.out.print("���� �Է� : ");
		int kor = scanner.nextInt();
		System.out.print("���� �Է� : ");
		int eng = scanner.nextInt();
		System.out.print("���� �Է� : ");
		int math = scanner.nextInt();
		SungJukDTO dto = new SungJukDTO(no, name, kor, eng, math);
		dto.calcTot();
		dto.calcAvg();
		list.add(dto);
	}//insertArticle()
	public void printArticle(){
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(SungJukDTO data : list){
			System.out.println(data);
		}
	}//printArticle()
	public void searchArticle(){
		System.out.print("�˻��� �̸� �Է� : ");
		String searchName = scanner.next();
		int check = 0;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getName().equals(searchName)){
				check = 1;
			}
		}
		if(check == 1){
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
         for(int i=0; i<list.size(); i++) {
            if(list.get(i).getName().equals(searchName)) {
               System.out.println(list.get(i));
            }
         }
      }else if(check == 0){
         System.out.println("ã���� �ϴ� �̸��� �����ϴ�.");
      }
	}//searchArticle()
	public void deleteArticle(){
		System.out.print("������ �̸� �Է� : ");
		String deleteName = scanner.next();
		int check = 0;
		/*
		Iterator<SungJukDTO> it = list.iterator();
		while(it.hasNext()){								//���� ��ġ�� �׸��� ������ T, ������ F
			SungJukDTO dto = it.next();						//���� ��ġ�� �׸��� ������ �������� �̵�
			if(dto.getName().equals(deleteName)) {
               list.remove(i);								//it.next()���� ��ȯ�� �׸��� �����.
			   check = 1;
			}
		}													//�̰� �Ϸ��� �ؿ� �ΰ� for���� �ּ�ó����!!
		*/
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getName().equals(deleteName)){
				check = 1;
			}
		}
		if(check == 1) {
         for(int i=0; i<list.size(); i++) {
            if(list.get(i).getName().equals(deleteName)) {
               list.remove(i);
			   i--;
            }
         }
		 System.out.println("�����͸� �����Ͽ����ϴ�.");
      }else if(check == 0){
         System.out.println("ã���� �ϴ� �̸��� �����ϴ�.");
      }
	}//deleteArticle()
	public void sortArticle(){
		while(true){
			System.out.println("***************");
			System.out.println("    1. �̸����� ��������");
			System.out.println("    2. �������� ��������");
			System.out.println("    3. �����޴�");
			System.out.println("***************");
			System.out.print("�޴� ��ȣ �Է� : ");
			int choice = scanner.nextInt();
			if(choice == 1){
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>(){
				@Override
				public int compare(SungJukDTO o1, SungJukDTO o2){
					return o1.getName().compareTo(o2.getName());
				}
			};
				Collections.sort(list, com);
				System.out.println("�̸����� �������� �����Ͽ����ϴ�.");
				printArticle();
			}else if(choice == 2){
				Collections.sort(list); 
				System.out.println("�������� �������� �����Ͽ����ϴ�.");
				printArticle();
			}else if(choice == 3){
				break;
			}
		}	
	}//sortArticle()
}
