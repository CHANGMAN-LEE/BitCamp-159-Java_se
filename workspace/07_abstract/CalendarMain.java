import java.util.*;

class CalendarTest{
	int year, month, day, dow, lastday;

	CalendarTest(){
		Scanner scanner = new Scanner(System.in);

		System.out.print("년도를 입력하세요 : ");
		year = scanner.nextInt();
		System.out.print("월을 입력하세요 : ");
		month = scanner.nextInt();

		find();
		display();

		scanner.close();
	}//생성자

	public void find(){
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day+1);
		dow = cal.get(Calendar.DAY_OF_WEEK);
		if (month == 4 || month == 6 || month == 9 || month == 11) {
            lastday = 30;
        } else if (month == 2 && (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) == true) {
            lastday = 29;
        } else if (month == 2 && (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) == false) {
			lastday = 28;
        } else {
            lastday = 31;
        }
	}//find()

	public void display(){
		System.out.println("\n" + "\t\t" + year + "년 " + month + "월 달력!!");
		System.out.println("====================================================");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("====================================================");
		for(day=1; day<=lastday; day++){
			if(day==1){
				for(int j=1; j<dow; j++){
					System.out.print("\t");
				}//for j
			}//if
			System.out.print(day + "\t");
			if(dow % 7 == 0){
				System.out.println();
			}//if
			dow++;
		}//for i
		System.out.println("\n====================================================");
	}//display()
}

//-------------------------------------------------------------------------------------------

class CalendarMain {
	public static void main(String[] args) {
		System.out.println("* * * * * * 달력 과제 * * * * * *");
		new CalendarTest();
	}//main()
}