import java.util.*;

class SungJukAction{
	private ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();
	Scanner scanner = new Scanner(System.in);	

	public void menu(){
		//list =  new ArrayList<SungJukDTO>();
		while(true){
			System.out.println("***************");
			System.out.println("    1. 입력");
			System.out.println("    2. 출력");
			System.out.println("    3. 검색");
			System.out.println("    4. 삭제");
			System.out.println("    5. 정렬");
			System.out.println("    6. 끝");
			System.out.println("***************");
			System.out.print("메뉴 번호 입력 : ");
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
				System.out.println("이용해 주셔서 감사합니다.");
				break;
			}
		}
	}//menu()
	public void insertArticle(){
		System.out.print("번호 입력 : ");
		int no = scanner.nextInt();
		/*for(SungJukDTO dto : list){
			if(no == dto.getNo()){
				System.out.println("중복된 번호입니다.");
				return;
			}
		}*/
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("국어 입력 : ");
		int kor = scanner.nextInt();
		System.out.print("영어 입력 : ");
		int eng = scanner.nextInt();
		System.out.print("수학 입력 : ");
		int math = scanner.nextInt();
		SungJukDTO dto = new SungJukDTO(no, name, kor, eng, math);
		dto.calcTot();
		dto.calcAvg();
		list.add(dto);
	}//insertArticle()
	public void printArticle(){
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTO data : list){
			System.out.println(data);
		}
	}//printArticle()
	public void searchArticle(){
		System.out.print("검색할 이름 입력 : ");
		String searchName = scanner.next();
		int check = 0;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getName().equals(searchName)){
				check = 1;
			}
		}
		if(check == 1){
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
         for(int i=0; i<list.size(); i++) {
            if(list.get(i).getName().equals(searchName)) {
               System.out.println(list.get(i));
            }
         }
      }else if(check == 0){
         System.out.println("찾고자 하는 이름이 없습니다.");
      }
	}//searchArticle()
	public void deleteArticle(){
		System.out.print("삭제할 이름 입력 : ");
		String deleteName = scanner.next();
		int check = 0;
		/*
		Iterator<SungJukDTO> it = list.iterator();
		while(it.hasNext()){								//현재 위치에 항목이 있으면 T, 없으면 F
			SungJukDTO dto = it.next();						//현재 위치에 항목을 꺼내고 다음으로 이동
			if(dto.getName().equals(deleteName)) {
               list.remove(i);								//it.next()에서 반환한 항목을 지운다.
			   check = 1;
			}
		}													//이걸 하려면 밑에 두개 for문을 주석처리해!!
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
		 System.out.println("데이터를 삭제하였습니다.");
      }else if(check == 0){
         System.out.println("찾고자 하는 이름이 없습니다.");
      }
	}//deleteArticle()
	public void sortArticle(){
		while(true){
			System.out.println("***************");
			System.out.println("    1. 이름으로 오름차순");
			System.out.println("    2. 총점으로 내림차순");
			System.out.println("    3. 이전메뉴");
			System.out.println("***************");
			System.out.print("메뉴 번호 입력 : ");
			int choice = scanner.nextInt();
			if(choice == 1){
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>(){
				@Override
				public int compare(SungJukDTO o1, SungJukDTO o2){
					return o1.getName().compareTo(o2.getName());
				}
			};
				Collections.sort(list, com);
				System.out.println("이름으로 오름차순 정렬하였습니다.");
				printArticle();
			}else if(choice == 2){
				Collections.sort(list); 
				System.out.println("총점으로 내림차순 정렬하였습니다.");
				printArticle();
			}else if(choice == 3){
				break;
			}
		}	
	}//sortArticle()
}
