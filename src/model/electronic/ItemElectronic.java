package model.electronic;

public class ItemElectronic {
	private int id;
	private float price;
	private String discount;
	private Electronic electronic;
	public ItemElectronic() {
		
	}
	
	public ItemElectronic(float price, String discount, Electronic electronic) {
		super();
		this.price = price;
		this.discount = discount;
		this.electronic = electronic;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public Electronic getElectronic() {
		return electronic;
	}
	public void setElectronic(Electronic electronic) {
		this.electronic = electronic;
	}
	
}
