package hust.soict.globalict.aims.media;

import java.util.*;

public abstract class Media{
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public Media(String title, String category) {
		this.title = title;
		this.category = category;
	}
	
	public Media(String title) {
		this.title = title;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public abstract boolean isMatch(String title);
	
	public boolean equals(Media media) {
		if(this.getTitle().equals(media.getTitle())) {
			return true;
		}
		return false;
	}
	
	/*
	public int compareTo(Media media) {
		if(this.getTitle().compareTo(media.getTitle()) != 0) {
			return this.getTitle().compareTo(media.getTitle());
		}
		float compare = this.getCost() - media.getCost();
		if(compare < 0) {
			return -1;
		}
		else if(compare > 0) {
			return 1;
		}
		return 0;
	}*/
}
