class BookDTO{
	private String title;
	private String auther;
	private int price;
	private int qty;
	private int total;

/*�����ڸ� ���ؼ� å ����, ����, �ܰ� ������ �Է�!! calc()���� total�� ���Ѵ�.
	[������]
	å����		����			�ܰ�			����			�հ�
	�ų���Java	ȫ�浿		25000		10			
	��մ� ��		������		35000		7			
	�ű��� ��ũ��Ʈ	������		30000		8			
*/

	public BookDTO(){}
	public BookDTO(String title, String auther, int price, int qty){
		this.title = title;
		this.auther = auther;
		this.price = price;
		this.qty = qty;
	}

	public void calc(){
		total = price * qty;
	}

	public String getTitle(){
		return title;
	}
	public String getAuther(){
		return auther;
	}
	public int getPrice(){
		return price;
	}
	public int getQty(){
		return qty;
	}
	public int getTotal(){
		return total;
	}


}

class BookOrder {
	public static void main(String[] args) {
		BookDTO[] aa = { new BookDTO("�ų���Java", "ȫ�浿", 25000, 10),
						new BookDTO("��մ� ��", "������", 35000, 7),
						new BookDTO("�ű��� ��ũ��Ʈ", "������", 30000, 8) };

		for(BookDTO dto : aa){
			dto.calc();
			System.out.println(dto.getTitle() + "\t\t" + dto.getAuther() + "\t\t" + dto.getPrice() + "\t" + dto.getQty() + "\t" + dto.getTotal());
		}

		System.out.println();
	
		/*for(int i=0; i<aa.length; i++){
			aa[i].calc();
			System.out.println(aa[i].getTitle() + "\t\t" + aa[i].getAuther() + "\t\t" + aa[i].getPrice() + "\t" + aa[i].getQty() + "\t" + aa[i].getTotal());
		}*/

	}
}
