import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ProtocolServer{
	private ServerSocket serverSocket;
	private BufferedReader bufReader;
	private BufferedWriter bufWriter;
	private Socket socket;

	public ProtocolServer(){
		try{
			serverSocket =  new ServerSocket(9500);
			System.out.println("�����غ�Ϸ�...");

			socket = serverSocket.accept();

			bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		}catch(IOException e){
			System.out.println("Ŭ���̾�Ʈ�� ������ �ȵǾ����ϴ�...");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void service(){
		String line, msg;
		while(true){
			try{
				//from Client
					line = bufReader.readLine();
					String[] ar = line.split(":");
						if(ar[0].equals(Protocol.ENTER)){
							bufWriter.write(ar[1] + "���� �����Ͽ����ϴ�." + "\n");
							bufWriter.flush();
						}else if(ar[0].equals(Protocol.EXIT)){
							bufWriter.write(ar[1] + "���� �����Ͽ����ϴ�." + "\n");
							bufWriter.flush();
							bufReader.close();
							bufWriter.close();
							socket.close();
							System.exit(0);
						}else if(ar[0].equals(Protocol.SEND_MESSAGE)){
							bufWriter.write(ar[1] + " : " + ar[2] + "\n");
							bufWriter.flush();
						}
				//to Client
		}//while
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		new ProtocolServer().service();
	}
}
