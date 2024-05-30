package hust.soict.globalict.aims.media;

import java.util.*;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("\n" + authorName + " already exists");
			return;
		}
		authors.add(authorName);
		System.out.println("Successfully added " + authorName + " as an author of " + this.getTitle() + "!");
	}

	public void removeAuthor(String authorName) {
		if(authors.remove(authorName)) {
			System.out.println("\nSuccessfully remove " + authorName +  "as an author of " + this.getTitle() + "!");
			return;
		}
		System.out.println("\n" + authorName + " does not exist, cannot remove!");
	}
	
	public boolean isMatch(String title) {
		if(this.getTitle().toLowerCase().contains(title.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("");
		str.append("Book - ");
		str.append(this.getTitle());
		str.append(" - ");
		str.append(this.getCategory());
		str.append(" - ");
		for(String author : authors) {
			str.append(author);
			str.append(", ");
		}
		str.deleteCharAt(str.length() - 1);
		str.deleteCharAt(str.length() - 1);
		str.append(" : ");
		str.append(this.getCost());
		return str.toString();
	}
}
