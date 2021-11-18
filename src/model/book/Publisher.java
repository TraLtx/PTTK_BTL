package model.book;

public class Publisher {
	private String name;
	private String Address;
	
	public Publisher(){
		
	}
	
	public Publisher(String name, String address) {
		super();
		this.name = name;
		Address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	
}
