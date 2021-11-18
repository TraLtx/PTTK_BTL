package model.book;

public class Author {
	private String name;
	private String biography;
	private String email;
	private String address;
	
	public Author(){
		
	}

	public Author(String name, String biography, String email, String address) {
		super();
		this.name = name;
		this.biography = biography;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
