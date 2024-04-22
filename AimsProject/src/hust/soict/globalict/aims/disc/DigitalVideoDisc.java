package hust.soict.globalict.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title) {
		this.title = title;
	}
	
	public DigitalVideoDisc(String title, String category) {
		this.title = title;
		this.category = category;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public String getTitle() {
		if(this.title == null) {
			return null;
		}
		return title;
	}
	public String getCategory() {
		if(this.category == null) {
			return null;
		}
		return category;
	}
	public String getDirector() {
		if(this.director == null) {
			return null;
		}
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public boolean isMatch(String title) {
		if(this.getTitle().contains(title)) {
			return true;
		}
		return false;
	}
}
