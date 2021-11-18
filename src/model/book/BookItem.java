package model.book;

public class BookItem {
	private int id;
	private float price;
	private String discount;
	
	private Book book;
	
	public BookItem() {
		super();
	}
	
	public BookItem(float price, String discount, Book book) {
		super();
		this.price = price;
		this.discount = discount;
		this.book = book;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
