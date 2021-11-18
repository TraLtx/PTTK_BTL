package model.clothes;

public class Clothes {
	private String name, material, size, brand, color, summary, guild,type;
	private float price ;
	private int id;
	public Clothes() {
		
	}
	public Clothes(String name, String material, String size, String brand, String color, String summary, String guild,
			String type, float price) {
		super();
		this.name = name;
		this.material = material;
		this.size = size;
		this.brand = brand;
		this.color = color;
		this.summary = summary;
		this.guild = guild;
		this.type = type;
		this.price = price;
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
	public String getGuild() {
		return guild;
	}
	public void setGuild(String guild) {
		this.guild = guild;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}