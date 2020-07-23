import java.io.*;

class DataStream{
	public static void main(String[] args) throws IOException{
		//DataOutputStream dos = new DataOutputStream(new FileOutputStream("reslut.txt"));

		FileOutputStream fos = new FileOutputStream("reslut.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeUTF("ȫ�浿");
		dos.writeInt(25);
		dos.writeDouble(185.3);
		dos.close();

		DataInputStream dis = new DataInputStream(new FileInputStream("reslut.txt"));
		System.out.println("�̸� = " + dis.readUTF());
		System.out.println("���� = " + dis.readInt());
		System.out.println("Ű = " + dis.readDouble());
	}
}
