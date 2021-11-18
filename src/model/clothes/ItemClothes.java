package model.clothes;

public class ItemClothes {
	private int id;
	private float price;
	private String discount;
	private Clothes clothes;
	public ItemClothes() {
		
	}
	
	public ItemClothes(float price, String discount, Clothes clothes) {
		super();
		this.price = price;
		this.discount = discount;
		this.clothes = clothes;
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
	public Clothes getClothes() {
		return clothes;
	}
	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	
}
