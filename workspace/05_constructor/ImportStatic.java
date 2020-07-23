//import static java.lang.Math.random;
//import static java.lang.Math.pow;
import static java.lang.Math.*;

//import static java.lang.System.*;
import static java.lang.System.out;

import static java.lang.String.format;


class ImportStatic {
	public static void main(String[] args) {
		out.println("난수 = " + random());		//0 <= 난수 < 1
		out.println("제곱 = " + pow(2,5));
		out.println("소수 이하 2째 자리 = " + format("%.2f", 43.56789));
	}
}
