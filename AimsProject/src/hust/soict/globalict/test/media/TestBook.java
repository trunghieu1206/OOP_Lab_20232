package hust.soict.globalict.test.media;
import hust.soict.globalict.aims.media.Book;

public class TestBook {

	public static void main(String[] args) {
		Book book = new Book(
				1,
				"Hieu",
				"hieu",
				20.0f
		);
		book.addAuthor("Hoang");
		book.addAuthor("Hieu");
		book.addAuthor("Long");
		book.removeAuthor("Hieu");
	}

}
