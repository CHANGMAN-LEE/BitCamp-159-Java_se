import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;

		PersonDTO dto = new PersonDTO("홍길동", 25, 185.3);

		try {
			fos = new FileOutputStream("result2.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(dto);
			fos.close();
			oos.close();
		} catch (IOException e) {

			e.printStackTrace();

		}

		ObjectInputStream ois = null;
		FileInputStream fis = null;
		fis = new FileInputStream("result2.txt");
		ois = new ObjectInputStream(fis);

		PersonDTO dto2 = (PersonDTO) ois.readObject();
		System.out.println(dto2.getName());
		System.out.println(dto2.getAge());
		System.out.println(dto2.getHeight());
		fis.close();
		ois.close();

	}
}
