package airline.action;

public class Member_ {
	private String id;
	public Member_(String id) {
		this.id = id;
		new Member_BookInfo(id).event();
	}
}