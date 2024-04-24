package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.*;
import java.util.*;

class MediaComparatorByCostTitle implements Comparator<Media>{
	public int compare(Media media1, Media media2) {
		float compare = media1.getCost() - media2.getCost();
		if(compare < 0) {
			return -1;
		}
		else if(compare > 0) {
			return 1;
		}
		return media1.getTitle().compareTo(media2.getTitle());
	}
}

class MediaComparatorByTitleCost implements Comparator<Media>{
	public int compare(Media media1, Media media2) {
		int result = media1.getTitle().compareTo(media2.getTitle());
		if(result != 0) {
			return result;
		}
		float compare = media1.getCost() - media2.getCost();
		if(compare < 0) {
			return -1;
		}
		else if(compare > 0) {
			return 1;
		}
		return 0;
	}
}

public class Cart {
	private List<Media> itemsOrdered = new ArrayList<Media>();
	
	//second way to sort List
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	//
	
	public boolean addMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			System.out.println("\nYou already ordered " + media.getTitle() + "!");
			return false;
		}
		itemsOrdered.add(media);
		System.out.println("\nSuccessfully ordered " + media.getTitle());
		return true;
	}
	
	public boolean removeMedia(Media media) {
		if(!itemsOrdered.contains(media)) {
			System.out.println("\n" + media.getTitle() + " does not exist in the Cart, cannot remove");
			return false;
		}
		itemsOrdered.remove(media);
		System.out.println("\nSuccessfully removed " + media.getTitle() + " from the Cart");
		return true;
	}
	
	public float totalCost() {
		float sum = 0;
		for(Media item : itemsOrdered) {
			sum += item.getCost();
		}
		return sum;
	}
	
	public void print() {
		System.out.println("\n***********************CART***********************");
		System.out.print("Ordered Items:");
		int count = 0;
		for(Media item : itemsOrdered) {
			System.out.print("\n" + (count + 1) + ". " + item.toString());
			count++;
		}
		System.out.println("\n***************************************************");
	}
	
	public Media searchByID(int ID) {
		for(Media item : itemsOrdered) {
			if(item.getId() == ID) {
				return item;
			}
		}
		return null;
	}
	
	public Media searchByTitle(String title) {
		for(Media item : itemsOrdered) {
			if(item.isMatch(title)) {
				return item;
			}
		}
		return null;
	}
	
	public void sortByTitle() {
		Collections.sort(itemsOrdered, new MediaComparatorByTitleCost());
//		Collections.sort(itemsOrdered, COMPARE_BY_TITLE_COST);
		System.out.println("\nCart successfully sorted by title");
		
	}
	
	public void sortByCost() {
		Collections.sort(itemsOrdered, new MediaComparatorByCostTitle());
//		Collections.sort(itemsOrdered, COMPARE_BY_COST_TITLE);
		System.out.println("\nCart successfully sorted by cost");
		
	}
	
	public int numberOfItems() {
		return itemsOrdered.size();
	}
	
	public void clearCart() {
		while(!this.itemsOrdered.isEmpty()) {
			this.itemsOrdered.remove(0);
		}
	}
	
}
