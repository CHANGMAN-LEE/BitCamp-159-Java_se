package bit0506;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerObject {
	private ServerSocket serverSocket;
	private Socket socket;
	private ArrayList<ChatHandlerObject> list;

	public ChatServerObject() {
		try {
			serverSocket = new ServerSocket(9500);
			System.out.println("�����غ�Ϸ�...");
			list = new ArrayList<ChatHandlerObject>();
			while (true) {
				socket = serverSocket.accept();
				ChatHandlerObject handler = new ChatHandlerObject(socket, list);
				Thread t = new Thread(handler);
				t.start();

				list.add(handler);
			}
		} catch (IOException e) {
			System.out.println("Ŭ���̾�Ʈ�� ������ �ȵǾ����ϴ�...");
			e.printStackTrace();
			System.exit(0);
		} // try&catch
	}

	public static void main(String[] args) {
		new ChatServerObject();
	}
}
