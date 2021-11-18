package model.electronic;

public class Electronic {
	private String code, name, producer, material, color, origin, weight, warranty, guide;
	private int id;
	public Electronic() {
		
	}
	public Electronic(String code, String name, String producer, String material, String color, String origin,
			String weight, String warranty, String guide) {
		super();
		this.code = code;
		this.name = name;
		this.producer = producer;
		this.material = material;
		this.color = color;
		this.origin = origin;
		this.weight = weight;
		this.warranty = warranty;
		this.guide = guide;
	}
	public int getId() {
		return id;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}
	
}
