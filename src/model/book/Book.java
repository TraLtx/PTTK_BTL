package model.book;

import java.util.Date;

public class Book{
	private int id;
	private String isbn;
	private String title;
	private String summary;
	private Date publiccationDate;
	private int numPage;
	private String language;
	private String size;
	private String appearance;
	
	private Publisher publisher;
	private Author author;
	
	public Book(String isbn, String title, String summary, Date publiccationDate, int numPage, String language,
			String size, String appearance) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.summary = summary;
		this.publiccationDate = publiccationDate;
		this.numPage = numPage;
		this.language = language;
		this.size = size;
		this.appearance = appearance;
	}
	
	public Book() {
		super();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getPubliccationDate() {
		return publiccationDate;
	}

	public void setPubliccationDate(Date publiccationDate) {
		this.publiccationDate = publiccationDate;
	}

	public int getNumPage() {
		return numPage;
	}

	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAppearance() {
		return appearance;
	}

	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}
	
	
}
