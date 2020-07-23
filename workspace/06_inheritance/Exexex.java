import java.util.Arrays;

class Exexex {
	public static void main(String[] args) {
		int num = 13296;

		char[] xd = String.valueOf(num).toCharArray();

		Arrays.sort(xd);

		String str = String.valueOf(xd);
		num = Integer.parseInt(str);

		System.out.println(num);
	}
}