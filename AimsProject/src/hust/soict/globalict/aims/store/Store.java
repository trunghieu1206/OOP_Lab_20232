package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.*;
import java.util.*;

public class Store {
	private List<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if(itemsInStore.contains(media)) {
			System.out.println("\n" + media.getTitle() + " already exists in the store!");
			return;
		}
		itemsInStore.add(media);
		System.out.println("\nSuccessfully added " + media.getTitle() + " to the store!");
	}
	
	public void removeMedia(Media media) {
		if(!itemsInStore.contains(media)) {
			System.out.println("\n" + media.getTitle() + " does not exist in the store, cannot remove!");
			return;
		}
		itemsInStore.remove(media);
		System.out.println("\n" + media.getTitle() + " successfully removed from the store!");
	}	
	
	/**
	Print all available Medias in the Store
	*/
	public void print() {
		System.out.println("\n***********************Store***********************");
		System.out.print("Available Medias in Store:");
		for(Media itemInStore : itemsInStore) {
			System.out.print("\n" + itemInStore.toString());
		}
		System.out.println("\n***************************************************");
	}
	
	/**Search for available Media inside the Store
	@return true if Media is available in the Store, false otherwise
	*/
	public Media search(String title) {
		for(Media item : itemsInStore) {
			if(item.isMatch(title)) {
				return item;
			}
		}
		return null;
		}
}
