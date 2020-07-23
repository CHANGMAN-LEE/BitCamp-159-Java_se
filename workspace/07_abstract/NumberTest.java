import java.text.DecimalFormat;		//�ڽ�
import java.text.NumberFormat;		//�θ�
import java.util.Locale;


class NumberTest {
	public static void main(String[] args) {
		NumberFormat nf = new DecimalFormat();			//sub Ŭ���� �̿�
		//���ڸ����� , ��� �Ҽ����� 3°�ڸ�!!
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();

		NumberFormat nf2 = new DecimalFormat("#,###.##��");
		//���ڰ� �ƴѰ��� ǥ������ �ʴ´�.
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();

		NumberFormat nf3 = new DecimalFormat("#,###.00��");
		//0�� ������ ǥ��
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();

		//NumberFormat nf4 = NumberFormat.getInstance();	//�޼ҵ� �̿�
		NumberFormat nf4 = NumberFormat.getCurrencyInstance(Locale.KOREA);
		nf4.setMaximumFractionDigits(2);
		nf4.setMinimumFractionDigits(2);	//�Ҽ����� ���� ��� 0�� ���� ���
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
