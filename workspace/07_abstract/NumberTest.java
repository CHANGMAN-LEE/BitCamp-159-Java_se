import java.text.DecimalFormat;		//자식
import java.text.NumberFormat;		//부모
import java.util.Locale;


class NumberTest {
	public static void main(String[] args) {
		NumberFormat nf = new DecimalFormat();			//sub 클래스 이용
		//세자리마다 , 찍고 소수이하 3째자리!!
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();

		NumberFormat nf2 = new DecimalFormat("#,###.##원");
		//숫자가 아닌것은 표현하지 않는다.
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();

		NumberFormat nf3 = new DecimalFormat("#,###.00원");
		//0을 강제로 표시
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();

		//NumberFormat nf4 = NumberFormat.getInstance();	//메소드 이용
		NumberFormat nf4 = NumberFormat.getCurrencyInstance(Locale.KOREA);
		nf4.setMaximumFractionDigits(2);
		nf4.setMinimumFractionDigits(2);	//소수이하 값이 없어도 0이 강제 출력
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();

		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US);
		nf5.setMaximumFractionDigits(2);
		nf5.setMinimumFractionDigits(2);
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
	}
}
