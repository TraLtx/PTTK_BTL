package model.shoe;

public class ShoeItem {
	private int id;
	private float price;
	private String discount;
	private Shoe shoe;
	
	public ShoeItem() {
		super();
	}

	public ShoeItem(float price, String discount) {
		super();
		this.price = price;
		this.discount = discount;
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
	
	
}
