import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

class ProtocolClient{
	private Socket socket;
	private BufferedReader bufReader;			//������ ���ؼ� ����.
	private BufferedWriter bufWriter;
	private BufferedReader bufReaderKeyboard;	//Ű���带 ���ؼ� ����.

	public ProtocolClient(){
		try{
			socket = new Socket("192.168.0.143", 9500);
			bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufReaderKeyboard = new BufferedReader(new InputStreamReader(System.in));
		}catch(UnknownHostException e){
			System.out.println("������ ã�� �� �����ϴ�...");
			e.printStackTrace();
			System.exit(0);
		}catch(IOException e){
			System.out.println("������ ������ �ȵǾ����ϴ�...");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void service(){
		String msg, line;
		while(true){
			try{
				//to Server
					msg = bufReaderKeyboard.readLine();
					bufWriter.write(msg + "\n");		//=>bufWriter = println(msg);
					bufWriter.flush();					//���۸� ������ ��������!!

				//from Server
					line = bufReader.readLine();
					System.out.println(line);

					String[] ar = msg.split(":");
					if(ar[0].equals(Protocol.EXIT)){
						bufReader.close();
						bufWriter.close();
						socket.close();

						System.exit(0);
					}
			}catch(IOException e){
				e.printStackTrace();
			}
		}//while
	}

	public static void main(String[] args){
		new ProtocolClient().service();
	}
}
