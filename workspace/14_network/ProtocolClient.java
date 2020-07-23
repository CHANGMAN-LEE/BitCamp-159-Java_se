import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

class ProtocolClient{
	private Socket socket;
	private BufferedReader bufReader;			//소켓을 통해서 들어옴.
	private BufferedWriter bufWriter;
	private BufferedReader bufReaderKeyboard;	//키보드를 통해서 들어옴.

	public ProtocolClient(){
		try{
			socket = new Socket("192.168.0.143", 9500);
			bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufReaderKeyboard = new BufferedReader(new InputStreamReader(System.in));
		}catch(UnknownHostException e){
			System.out.println("서버를 찾을 수 없습니다...");
			e.printStackTrace();
			System.exit(0);
		}catch(IOException e){
			System.out.println("서버와 연결이 안되었습니다...");
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
					bufWriter.flush();					//버퍼를 보내고 비워줘야함!!

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
