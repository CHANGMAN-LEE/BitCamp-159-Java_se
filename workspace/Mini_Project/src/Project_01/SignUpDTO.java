package Project_01;

public class SignUpDTO {
	private String id, pw, pw2, name, phone, mail, address, question, answer;
	
	public void setData(String id, String pw, String pw2, String name, String phone, String mail, String address, String question, String answer) {
		this.id = id; this.pw = pw; this.pw2 = pw2; this.name = name; this.phone = phone; 
		this.mail = mail; this.address = address; this.question = question; this.answer = answer;
	}
	
//	public void setId(String id) {this.id = id;}
//	public void setPw(String pw) {this.pw = pw;}
//	public void setPw2(String pw2) {this.pw2 = pw2;}
//	public void setName(String name) {this.name = name;}
//	public void setPhone(String phone) {this.phone = phone;}
//	public void setMail(String mail) {this.mail = mail;}
//	public void setAddres(String address) {this.address = address;}
//	public void setQuestion(String question) {this.question = question;}
//	public void setAnswer(String answer) {this.answer = answer;}
	
	public String getId() {return id;}
	public String getPw() {return pw;}
	public String getPw2() {return pw2;}
	public String getName() {return name;}
	public String getPhone() {return phone;}
	public String getMail() {return mail;}
	public String getAddres() {return address;}
	public String getQuestion() {return question;}
	public String getAnswer() {return answer;}
}
