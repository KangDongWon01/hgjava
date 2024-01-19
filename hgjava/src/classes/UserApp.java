package classes;
class User {
	private String id;
	private String pw;
	private String name;
	// 생성자
	public User(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	//
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

public class UserApp {
	private User[] users;	
	
	//로그인 기능
	public UserApp() {
		users = new User[5];
		users[0]=new User("user1","1111","전영재");
		users[1]=new User("user2","2222","최원영");
		users[2]=new User("user3","3333","강동원");
	}
	public boolean login(String id, String pw) {
		for(int i= 0; i<users.length; i++) {
			if(users[i] != null) {
				if(users[i].getId().equals(id) && users[i].getId().equals(pw));{
					return true;
				}
			}
		}
		return false;
	}
}