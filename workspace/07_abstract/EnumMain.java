/*class EnumColor{
	static final String RED = "»¡°­";
	static final String GREEN = "ÃÊ·Ï";
	static final String BLUE = "ÆÄ¶û";
	static final String MAGENTA = "º¸¶ó";
}*/

enum EnumColor{
	RED, GREEN, BLUE, MAGENTA
}
//------------------------------------------------
class EnumMain{
	String colorName;
	EnumColor color;

	public static void main(String[] args){
		System.out.println(EnumColor.RED);
		System.out.println();

		EnumMain em = new EnumMain();
		em.colorName = "»¡°­";
		em.color = EnumColor.RED;
		System.out.println(em.colorName + "\t" + em.color);

		em.colorName = "º¸¶ó";
		EnumColor VIOLET = EnumColor.MAGENTA;
		System.out.println(em.colorName + "\t" + VIOLET);
		System.out.println();

		for(EnumColor data : EnumColor.values()){
			System.out.println(data + "\t" + data.ordinal() + "\t" + data.valueOf(data+""));
		}
	}
}
