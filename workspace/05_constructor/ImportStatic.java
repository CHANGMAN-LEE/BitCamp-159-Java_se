//import static java.lang.Math.random;
//import static java.lang.Math.pow;
import static java.lang.Math.*;

//import static java.lang.System.*;
import static java.lang.System.out;

import static java.lang.String.format;


class ImportStatic {
	public static void main(String[] args) {
		out.println("���� = " + random());		//0 <= ���� < 1
		out.println("���� = " + pow(2,5));
		out.println("�Ҽ� ���� 2° �ڸ� = " + format("%.2f", 43.56789));
	}
}
