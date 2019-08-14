package ProductProject;

public class Book extends Product {
	private String bookName,bookAuthor;
	
	public Book(String bN, String bA,int rt) {
		super(rt);
		this.bookName = bN;
		this.bookAuthor = bA;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	
	
	
}
