import java.io.*;

class DataStream{
	public static void main(String[] args) throws IOException{
		//DataOutputStream dos = new DataOutputStream(new FileOutputStream("reslut.txt"));

		FileOutputStream fos = new FileOutputStream("reslut.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeUTF("홍길동");
		dos.writeInt(25);
		dos.writeDouble(185.3);
		dos.close();

		DataInputStream dis = new DataInputStream(new FileInputStream("reslut.txt"));
		System.out.println("이름 = " + dis.readUTF());
		System.out.println("나이 = " + dis.readInt());
		System.out.println("키 = " + dis.readDouble());
	}
}
