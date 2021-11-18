package model.employee;

public class Employee {
	private int id;
	private String fullName;
	private String username;
	private String password;
	private String position;
	
	public Employee(){
		
	}

	public Employee(String fullName, String username, String password, String position) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
