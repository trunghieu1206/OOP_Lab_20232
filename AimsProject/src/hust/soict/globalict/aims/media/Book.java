package hust.soict.globalict.aims.media;

import java.util.*;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("\n" + authorName + " already exists");
			return;
		}
		authors.add(authorName);
		System.out.println("Successfully added " + authorName + "!");
	}

	public void removeAuthor(String authorName) {
		if(authors.remove(authorName)) {
			System.out.println("\nSuccessfully remove " + authorName + "!");
			return;
		}
		System.out.println("\n" + authorName + " does not exist, cannot remove!");
	}
	
	public boolean isMatch(String title) {
		return true;
	}
}
