import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


class URLTest{
	public static void main(String[] args) throws MalformedURLException, IOException{
		URL url = new URL("https://www.google.co.kr/index.html");
		System.out.println("프로토콜 = " + url.getProtocol());
		System.out.println("호스트 = " + url.getHost());
		System.out.println("포트 = " + url.getPort());
		System.out.println("기본 포트 = " + url.getDefaultPort());
		System.out.println("파일 = " + url.getFile());
		System.out.println();

		//--------------------------------------------------------------------

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
		while((line=br.readLine()) != null){
			System.out.println(line);
		}
		br.close();
	}
}
