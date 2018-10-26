
import java.io.Serializable;

public class Book implements Serializable {

	int numberOfBook;
	private String title;
	boolean issued;
	private static int counterOfBooks;

	public Book() {
		counterOfBooks++;
	}

	public static int getNumberOfBook() {
		return counterOfBooks;
	}

	public void setNumberOfBook(int numberOfBook) {
		this.numberOfBook = numberOfBook;
	}

	public boolean isIssued() {
		return issued;
	}

	public void issued() {
		issued = true;
	}

	public void avaliable() {
		issued = false;
	}

	public Book(int numberOfBook, String title, boolean issued) {
		this.numberOfBook = numberOfBook;
		this.setTitle(title);
		this.issued = issued;
		counterOfBooks++;
	}

	@Override
	public String toString() {
		return "Book [\n numberOfBook=" + numberOfBook + ",\ntitle=" + getTitle() + ", \nissued=" + issued + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
