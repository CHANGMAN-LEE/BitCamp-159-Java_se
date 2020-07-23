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
			System.out.println("서버준비완료...");

			socket = serverSocket.accept();

			bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		}catch(IOException e){
			System.out.println("클라이언트와 연결이 안되었습니다...");
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
							bufWriter.write(ar[1] + "님이 입장하였습니다." + "\n");
							bufWriter.flush();
						}else if(ar[0].equals(Protocol.EXIT)){
							bufWriter.write(ar[1] + "님이 퇴장하였습니다." + "\n");
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
