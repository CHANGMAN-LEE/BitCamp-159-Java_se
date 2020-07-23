package Project_01;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PracticeEmail {
	
	private SignUp2 practiceSignUp;
	private PracticeLostPW practiceLostPW;
	private Login practiceLogin;
	private String code;
	
	
	public String getCode() {
		return this.code;
	}
	
	
	//ȸ�� ���Խ� �̿�Ǵ� �ڵ���� �߼ۿ� ������.
	//�����빮�� 2�� + 1~9���� 4�ڸ�
	public PracticeEmail(SignUp2 practiceSignUp) {
		char ranChar1 = (char) ((int)(Math.random()*(90-65+1))+65); 
		char ranChar2 = (char) ((int)(Math.random()*(90-65+1))+65); 
		int ranNum1 = (int)(Math.random()*(9-1+1))+1;
		int ranNum2 = (int)(Math.random()*(9-1+1))+1;
		int ranNum3 = (int)(Math.random()*(9-1+1))+1;
		int ranNum4 = (int)(Math.random()*(9-1+1))+1;
		
		code = new String(""+ranChar1+ranChar2+ranNum1+ranNum2+ranNum3+ranNum4);
		
		
		this.practiceSignUp = practiceSignUp;
		
        String userName = "Bit159.Richard"; // ���̹��� ��� ���̹� ����, gmail��� gmail ����
        String password = "richbit159";   // �н�����

        // SMTP ���� ������ �����Ѵ�.
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com"); 
        prop.put("mail.smtp.port", 465); 
        prop.put("mail.smtp.auth", "true"); 
        prop.put("mail.smtp.ssl.enable", "true"); 
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));

            // Customer email input
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(practiceSignUp.getInputEmail().getText())); 

            // Subject
            message.setSubject("Verification Code : " + code); //���� ������ �Է�

            // Text
            message.setText("Thanks for using our services." + "\n" + "Your Verification Code is below:" + "\n\n\n" + code);    //���� ������ �Է�

            // send the message
            Transport.send(message); ////����
            System.out.println("message sent successfully...");
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	
	
	}
	
	public PracticeEmail(String email, Login practiceLogin) {
		this.practiceLogin = practiceLogin;

		char ranChar1 = (char) ((int)(Math.random()*(90-65+1))+65); 
		char ranChar2 = (char) ((int)(Math.random()*(90-65+1))+65); 
		char ranNum1 = (char) ((int)(Math.random()*(9-1+1))+49);
		char ranNum2 = (char) ((int)(Math.random()*(9-1+1))+49);
		char ranNum3 = (char) ((int)(Math.random()*(9-1+1))+49);
		char ranNum4 = (char) ((int)(Math.random()*(9-1+1))+49);
		
		char[] tempPW = {ranChar1,ranChar2,ranNum1,ranNum2,ranNum3,ranNum4};
		code = new String("" + ranChar1 + ranChar2 + ranNum1 + ranNum2 + ranNum3 + ranNum4);

		for (DTO dto : practiceLogin.getDB()) {
			if(dto.getEmail().equals(email)) {
				dto.setPw(tempPW);
				dto.setTempSW(1);
			}
		}
		
		String userName = "Bit159.Richard"; // ���̹��� ��� ���̹� ����, gmail��� gmail ����
		String password = "richbit159";   // �н�����
		
		// SMTP ���� ������ �����Ѵ�.
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com"); 
		prop.put("mail.smtp.port", 465); 
		prop.put("mail.smtp.auth", "true"); 
		prop.put("mail.smtp.ssl.enable", "true"); 
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));
			
			// Customer email input
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
			
			// Subject
			message.setSubject("Your temporary password : " + code); //���� ������ �Է�
			
			// Text
			message.setText("Your temporary password is below:" + "\n\n\n" + code);    //���� ������ �Է�
			
			// send the message
			Transport.send(message); ////����
			System.out.println("message sent successfully...");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//