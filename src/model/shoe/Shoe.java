package model.shoe;

public class Shoe {
	private int id;
	private String name;
	private String material;
	private String size;
	private String brand;
	private String color;
	private String summary;
	private float price;
	private String discriminator;
	public Shoe(String name, String material, String size, String brand, String color, String summary, float price) {
		super();
		this.name = name;
		this.material = material;
		this.size = size;
		this.brand = brand;
		this.color = color;
		this.summary = summary;
		this.price = price;
	}
	public Shoe() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDiscriminator() {
		return discriminator;
	}
	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}
	
	
}
