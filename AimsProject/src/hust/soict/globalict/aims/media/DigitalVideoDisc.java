package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc{
	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, director, length, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category, director, length, cost);
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category) {
		super(title, category);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public boolean isMatch(String title) {
		if(this.getTitle().contains(title)) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("");
		str.append("DVD - ");
		str.append(this.getTitle());
		str.append(" - ");
		str.append(this.getCategory());
		str.append(" - ");
		str.append(this.getDirector());
		str.append(" - ");
		str.append(this.getLength());
		str.append(": ");
		str.append(this.getCost());
		return str.toString();
	}
}
