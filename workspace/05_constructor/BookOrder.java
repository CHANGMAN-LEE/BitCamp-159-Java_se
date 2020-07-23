class BookDTO{
	private String title;
	private String auther;
	private int price;
	private int qty;
	private int total;

/*생성자를 통해서 책 제목, 저자, 단가 개수를 입력!! calc()에서 total를 구한다.
	[실행결과]
	책제목		저자			단가			개수			합계
	신나는Java	홍길동		25000		10			
	재밌는 웹		김전일		35000		7			
	신기한 스크립트	남도일		30000		8			
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
		BookDTO[] aa = { new BookDTO("신나는Java", "홍길동", 25000, 10),
						new BookDTO("재밌는 웹", "김전일", 35000, 7),
						new BookDTO("신기한 스크립트", "남도일", 30000, 8) };

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
