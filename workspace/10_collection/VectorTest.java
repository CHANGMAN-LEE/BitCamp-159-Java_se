import java.util.Vector;

class VectorTest{
	public static void main(String[] args){
		Vector<String> v = new Vector<String>();
		System.out.println("º¤ÅÍ Å©±â = " + v.size());
		System.out.println("º¤ÅÍ ¿Ë·® = " + v.capacity());
		System.out.println();

		System.out.println("Ç×¸ñ Ãß°¡");
		for(int i=1; i<=10; i++){
			v.add(i+"");
		}

		System.out.println("º¤ÅÍ Å©±â = " + v.size());
		System.out.println("º¤ÅÍ ¿Ë·® = " + v.capacity());
		System.out.println();

		v.addElement(5+"");
		System.out.println("º¤ÅÍ Å©±â = " + v.size());
		System.out.println("º¤ÅÍ ¿Ë·® = " + v.capacity());
		System.out.println();

		System.out.println(v);
		System.out.println();

		System.out.println("Ç×¸ñ »èÁ¦");
		v.remove(10);
		System.out.println(v);

	}
}