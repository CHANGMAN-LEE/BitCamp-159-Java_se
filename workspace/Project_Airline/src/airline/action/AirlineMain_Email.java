package airline.action;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AirlineMain_Email {
	private AirlineMain_SignUp su;
	private String code;

	public AirlineMain_Email(AirlineMain_SignUp su) {
		this.su = su;
		int codeNum = (int) (Math.random() * (900000)) + 10000;

	      code = new String(codeNum + "");
	      //this.su.getCodenum();

	      String userMail = "bitairline@gmail.com";
	      String password = "bitbit111!";

	      Properties prop = new Properties();
	      prop.put("mail.smtp.host", "smtp.gmail.com");
	      prop.put("mail.smtp.port", 465);
	      prop.put("mail.smtp.auth", "true");
	      prop.put("mail.smtp.ssl.enable", "true");
	      prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

	      Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(userMail, password);
	         }
	      });
	      MimeMessage message = new MimeMessage(session);
	      try {
	         message.setFrom(new InternetAddress(userMail));
	         // user email 넣는다
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.su.getMail().getText()));       
	         // 메일 제목
	         message.setSubject("BitAirline 인증번호");
	         // 메일 내용을 추가해준다
	         message.setText("인증 번호: " + code);
	         // 메일 전송
	         Transport.send(message);
	      } catch (AddressException e) {
	         e.printStackTrace();
	      } catch (MessagingException e) {
	         e.printStackTrace();
	      }
	}
	
	public String getCode() {
		return code;
	}

}