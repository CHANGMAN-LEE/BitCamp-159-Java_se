package airline.bean;

public class MemberDTO {
	private String id, pw, pw2, name, phone, mail, address, question, answer;
	private int seq, code;

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public void setCode(int code) {
		this.code= code;
	}

	public int getSeq() {
		return seq;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getPw2() {
		return pw2;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getMail() {
		return mail;
	}

	public String getAddress() {
		return address;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}
	
	public int getCode() {
		return code;
	}
}
