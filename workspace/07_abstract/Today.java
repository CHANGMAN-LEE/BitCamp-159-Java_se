import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class Today {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println("���� ��¥ : " + date);
		SimpleDateFormat sdf = new SimpleDateFormat("y�� MM�� dd�� E���� a h:m:s");
		System.out.println("���� ��¥ : " + sdf.format(date));

		System.out.println();
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19940914165900");
		System.out.println("��â������ �¾ ��¥ : " + birth);
		System.out.println("��â������ �¾ ��¥ : " + sdf.format(birth));

		System.out.println();
		//Calendar cal = new GregorianCalendar();
		Calendar cal = Calendar.getInstance(Locale.KOREA);
		//int year = cal.get(Calendar.YEAR);
		int year = cal.get(1);
		int month = cal.get(Calendar.MONTH)+1;	//1���� 0���� �����ֱ� ������!! +1�� ���ش�.
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		String week = null;
		switch(dayofweek){
			case 1: week="�Ͽ���"; break;
			case 2: week="������"; break;
			case 3: week="ȭ����"; break;
			case 4: week="������"; break;
			case 5: week="�����"; break;
			case 6: week="�ݿ���"; break;
			case 7: week="�����"; break;
		}
		System.out.println(year + "-" + month + "-" + day  + " " + "("+ week + ")");
	}
}
