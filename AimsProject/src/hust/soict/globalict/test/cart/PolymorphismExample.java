package hust.soict.globalict.test.cart;

import java.util.*;
import hust.soict.globalict.aims.media.*;

public class PolymorphismExample {

	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		
		Media cd = new CompactDisc(
				"A CD",
				"cd",
				"Hoang",
				20,
				15.5f,
				"Hoang"
		);
		mediae.add(cd);
		
		Media dvd = new DigitalVideoDisc(
				"The Lion King",
				"Animation",
				"Roger Allers",
				87,
				19.95f
		);
		mediae.add(dvd);
		
		Media book = new Book(
				"A Book",
				"book",
				50.0f
		);
		mediae.add(book);
		
		System.out.println(cd.toString());
		System.out.println(dvd.toString());
		System.out.println(book.toString());
	}

}
