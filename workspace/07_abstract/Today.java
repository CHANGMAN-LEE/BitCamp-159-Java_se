import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class Today {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println("오늘 날짜 : " + date);
		SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 dd일 E요일 a h:m:s");
		System.out.println("오늘 날짜 : " + sdf.format(date));

		System.out.println();
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19940914165900");
		System.out.println("이창만님의 태어난 날짜 : " + birth);
		System.out.println("이창만님의 태어난 날짜 : " + sdf.format(birth));

		System.out.println();
		//Calendar cal = new GregorianCalendar();
		Calendar cal = Calendar.getInstance(Locale.KOREA);
		//int year = cal.get(Calendar.YEAR);
		int year = cal.get(1);
		int month = cal.get(Calendar.MONTH)+1;	//1월을 0으로 보고있기 떄문에!! +1을 해준다.
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		String week = null;
		switch(dayofweek){
			case 1: week="일요일"; break;
			case 2: week="월요일"; break;
			case 3: week="화요일"; break;
			case 4: week="수요일"; break;
			case 5: week="목요일"; break;
			case 6: week="금요일"; break;
			case 7: week="토요일"; break;
		}
		System.out.println(year + "-" + month + "-" + day  + " " + "("+ week + ")");
	}
}
