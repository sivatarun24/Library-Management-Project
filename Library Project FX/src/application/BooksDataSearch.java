package application;


public class BooksDataSearch {

	private String bookId;
	private String name;
	private String isbn;
	private String publisher;
	private String cost;
	public BooksDataSearch(String bookId, String name, String isbn, String publisher, String cost) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.isbn = isbn;
		this.publisher = publisher;
		this.cost = cost;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
}
